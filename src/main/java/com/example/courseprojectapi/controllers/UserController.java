package com.example.courseprojectapi.controllers;

import com.example.courseprojectapi.models.ApplicationModel;
import com.example.courseprojectapi.models.RoleModel;
import com.example.courseprojectapi.models.UserModel;
import com.example.courseprojectapi.repositories.ApplicationRepository;
import com.example.courseprojectapi.repositories.SalesStatisticsRepository;
import com.example.courseprojectapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private SalesStatisticsRepository salesStatisticsRepository;

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable Long id) {
        UserModel userModel = userRepository.findById(id).orElse(null);

        return ResponseEntity.ok(userModel);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody UserModel userModel) {
        try {
            userRepository.save(userModel);
            return ResponseEntity.ok("User saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save user");
        }
    }

    @GetMapping("/by-username/{username}")
    public ResponseEntity<UserModel> getUserByUsername(@PathVariable String username) {
        UserModel userModel = userRepository.findByUsername(username);
        return ResponseEntity.ok(userModel);
    }

    @GetMapping("/findByRole/{roleModel}")
    public ResponseEntity<UserModel> findByRole(@PathVariable RoleModel roleModel) {
        UserModel user = userRepository.findByRole(roleModel);

        return ResponseEntity.ok(user);
    }
}
