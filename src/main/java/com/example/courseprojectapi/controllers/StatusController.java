package com.example.courseprojectapi.controllers;

import com.example.courseprojectapi.models.ApplicationStatusModel;
import com.example.courseprojectapi.repositories.ApplicationStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private ApplicationStatusRepository applicationStatusRepository; // Ваш репозиторий для статусов

    @GetMapping("/{statusName}")
    public ResponseEntity<ApplicationStatusModel> getStatusByName(@PathVariable String statusName) {
        ApplicationStatusModel status = applicationStatusRepository.findApplicationStatusModelByName(statusName);

        return ResponseEntity.ok(status);
    }
}
