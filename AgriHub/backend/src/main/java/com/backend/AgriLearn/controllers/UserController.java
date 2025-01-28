package com.backend.AgriLearn.controllers;

import com.backend.AgriLearn.dtos.UserDTO;
import com.backend.AgriLearn.entities.User;
import com.backend.AgriLearn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create a new user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        User user = userService.createUser(userDTO);
        return ResponseEntity.ok(user);
    }

    // Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Get a user by ID
    @GetMapping("/{userID}")
    public ResponseEntity<User> getUserById(@PathVariable int userID) {
        Optional<User> user = userService.getUserById(userID);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a user
    @PutMapping("/{userID}")
    public ResponseEntity<User> updateUser(@PathVariable int userID, @RequestBody UserDTO userDTO) {
        User updatedUser = userService.updateUser(userID, userDTO);
        return ResponseEntity.ok(updatedUser);
    }

    //Delete a user
    @DeleteMapping("/{userID}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userID) {
        userService.deleteUser(userID);
        return ResponseEntity.noContent().build();
    }
}
