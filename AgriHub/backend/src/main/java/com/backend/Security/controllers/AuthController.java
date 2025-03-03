package com.backend.Security.controllers;

import com.backend.Security.dtos.*;
import com.backend.Security.errors.ErrorResponse;
import com.backend.Security.services.AuthService;
import com.backend.Security.services.PasswordService;
import com.backend.Security.services.TokenBlacklistService;
import com.backend.User.entities.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private TokenBlacklistService tokenBlacklistService;

    private final PasswordService passwordService;

    public AuthController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {
//        {
//            "name": "John",
//                "surname": "Doe",
//                "phoneNumber": "0612345678",
//                "email": "sphashepherd@gmail.com",
//                "password": "SecurePass123",
//                "picUrl": "https://example.com/profile-pic.jpg",
//                "roleType": "ADMIN"
//        }

        authService.register(request);
        return ResponseEntity.ok("Registration successful. Please check your email for verification.");
    }

    @GetMapping("/verify")
    public ResponseEntity<?> verifyEmail(@RequestParam String token) {
        authService.verifyEmail(token);
        return ResponseEntity.ok("Email verified successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
//        {
//            "email": "sucredelacruz514@gmail.com",
//            "password": "1234"
//        }

        try {
            String jwt = authService.login(request);
            return ResponseEntity.ok(new JwtResponse(jwt));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponse(e.getMessage()));
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String token) {
        if (token != null && token.startsWith("Bearer ")) {
            String jwt = token.substring(7);
            tokenBlacklistService.blacklistToken(jwt);
            return ResponseEntity.ok().body("Logged out successfully");
        }
        return ResponseEntity.badRequest().body("Invalid token");
    }





    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody ForgotPasswordRequest request) {
//        {
//            "email": "user@example.com"
//        }
        try {
            passwordService.processForgotPassword(request.getEmail());
            return ResponseEntity.ok()
                    .body("Password reset link has been sent to your email");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error processing request: " + e.getMessage());
        }
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest request) {
//        {
//            "token": "reset-token-from-email",
//            "newPassword": "newPassword123"
//        }
        try {
            passwordService.resetPassword(request.getToken(), request.getNewPassword());
            return ResponseEntity.ok()
                    .body("Password has been reset successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error resetting password: " + e.getMessage());
        }
    }


    @PostMapping("/change-password")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> changePassword(@AuthenticationPrincipal org.springframework.security.core.userdetails.User userDetails, @RequestBody ChangePasswordRequest request) {
//        {
//            "currentPassword": "oldPassword123",
//            "newPassword": "newPassword123"
//        }


        try {
            User user = authService.findByEmail(userDetails.getUsername())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            passwordService.changePassword(user, request.getCurrentPassword(), request.getNewPassword());
            return ResponseEntity.ok().body("Password changed successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error changing password: " + e.getMessage());
        }
    }

}
