package com.backend.Security.services;

import com.backend.Security.dtos.LoginRequest;
import com.backend.Security.dtos.RegisterRequest;
import com.backend.User.entities.Role;
import com.backend.User.entities.User;
import com.backend.User.enums.RoleType;
import com.backend.User.repositories.RoleRepository;
import com.backend.User.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    // Register a new user
    public void register(RegisterRequest request) {
        // Check if user exists
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        // Fetch the default role (USER)
        Role defaultRole = roleRepository.findByRoleType(RoleType.USER)
                .orElseThrow(() -> new RuntimeException("Default role not found"));

        // Create new user
        User user = new User();
        user.setName(request.getName()); // Set name
        user.setSurname(request.getSurname()); // Set surname
        user.setPhoneNumber(request.getPhoneNumber()); // Set phone number
        user.setEmail(request.getEmail()); // Set email
        user.setPassword(passwordEncoder.encode(request.getPassword())); // Encode and set password
        user.setPicUrl(request.getPicUrl()); // Set profile picture URL (if provided)
        user.setRoleType(defaultRole); // Assign the default role
        user.setEnabled(false); // User is not enabled until email is verified

        // Generate verification token
        String token = generateVerificationToken();
        user.setVerificationToken(token);
        user.setVerificationTokenExpiry(LocalDateTime.now().plusHours(24));

        userRepository.save(user); // Save the user to the database

        // Send verification email
        String verificationLink = "http://localhost:8080/api/auth/verify?token=" + token;
        emailService.sendVerificationEmail(user.getEmail(), verificationLink);
    }
    // Verify user email
    public void verifyEmail(String token) {
        User user = userRepository.findByVerificationToken(token)
                .orElseThrow(() -> new RuntimeException("Invalid token"));

        if (LocalDateTime.now().isAfter(user.getVerificationTokenExpiry())) {
            throw new RuntimeException("Token expired");
        }

        user.setEnabled(true);
        user.setVerificationToken(null);
        user.setVerificationTokenExpiry(null);
        userRepository.save(user);
    }

    public String login(LoginRequest request) {
        try {
            // Authenticate user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            // Check if user is enabled (email verified)
            if (!userDetails.isEnabled()) {
                throw new RuntimeException("Email not verified");
            }

            // Generate JWT
            return jwtService.generateToken(userDetails);

        } catch (BadCredentialsException e) {
            throw new RuntimeException("Invalid email or password");
        }
    }

    private String generateVerificationToken() {
        return UUID.randomUUID().toString();
    }



    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


}

