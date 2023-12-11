package com.example.courseprojectapi.controllers;

import com.example.courseprojectapi.models.RoleModel;
import com.example.courseprojectapi.models.UserModel;
import com.example.courseprojectapi.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/{id}")
    public ResponseEntity<RoleModel> getRoleById(@PathVariable Long id) {
        RoleModel roleModel = roleRepository.findById(id).orElse(null);

        return ResponseEntity.ok(roleModel);
    }

    @GetMapping("/findAtRoleName/{roleName}")
    public ResponseEntity<RoleModel> getRoleByRoleName(@PathVariable String roleName) {
        RoleModel roleModel = roleRepository.findByRoleName(roleName);

        return ResponseEntity.ok(roleModel);
    }
}
