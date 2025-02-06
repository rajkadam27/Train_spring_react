package com.example.TrainBooking.controller;

import com.example.TrainBooking.model.User;
import com.example.TrainBooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    // Register a new user
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        // Check if the email is already taken
        if (userService.validateLogin(user.getEmail(), user.getPassword()) != null) {
            return new ResponseEntity<>("Email is already taken.", HttpStatus.BAD_REQUEST);
        }
        
        userService.registerUser(user);
        return new ResponseEntity<>("User registered successfully!", HttpStatus.CREATED);
    }

    // User login
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User loginDetails) {
        User user = userService.validateLogin(loginDetails.getEmail(), loginDetails.getPassword());
        if (user != null) {
            return new ResponseEntity<>("Login successful!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid credentials!", HttpStatus.UNAUTHORIZED);
        }
    }
}
