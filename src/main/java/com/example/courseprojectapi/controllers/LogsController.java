package com.example.courseprojectapi.controllers;

import com.example.courseprojectapi.models.LogModel;
import com.example.courseprojectapi.repositories.LogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/logs")
public class LogsController {
    @Autowired
    LogsRepository logsRepository;
    @GetMapping
    private Iterable<LogModel> getLogs(){
        return logsRepository.findAll();
    }
}
