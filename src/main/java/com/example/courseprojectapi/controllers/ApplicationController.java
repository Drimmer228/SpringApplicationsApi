package com.example.courseprojectapi.controllers;

import com.example.courseprojectapi.models.ApplicationModel;
import com.example.courseprojectapi.models.ApplicationStatusModel;
import com.example.courseprojectapi.models.UserModel;
import com.example.courseprojectapi.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/application")
public class ApplicationController {
    @Autowired
    private ApplicationRepository applicationRepository;

    @PostMapping("/save")
    public ResponseEntity<String> saveApplication(@RequestBody ApplicationModel applicationModel) {
        try {
            applicationRepository.save(applicationModel);
            return ResponseEntity.ok("Application saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save application");
        }
    }

    @GetMapping("/downloadFile/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        ApplicationModel applicationModel = applicationRepository.findApplicationModelById(id);
        if (applicationModel != null && applicationModel.getExecutableFile() != null) {
            byte[] apkFileContent = applicationModel.getExecutableFile();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.android.package-archive"));
            headers.setContentDispositionFormData("attachment", applicationModel.getNameExecutableFile());

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(apkFileContent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/downloadImage/{id}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable Long id) {
        ApplicationModel applicationModel = applicationRepository.findApplicationModelById(id);
        if (applicationModel != null && applicationModel.getImageApp() != null) {
            byte[] imgContent = applicationModel.getImageApp();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("image/jpeg"));

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(imgContent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationModel> getApplicationById(@PathVariable Long id) {
        ApplicationModel application = applicationRepository.findById(id).orElse(null);

        return ResponseEntity.ok(application);
    }

    @GetMapping("/uniqueNames")
    public ResponseEntity<List<String>> getUniqueApplicationNamesByPublisherId() {
        List<String> uniqueNames = applicationRepository.findDistinctPublisherIds();

        return ResponseEntity.ok(uniqueNames);
    }

    @GetMapping("/findByPublisherRole/{roleName}")
    public ResponseEntity<List<ApplicationModel>> findByPublisherRole(@PathVariable String roleName) {
        List<ApplicationModel> entities = applicationRepository.findAllByPublisherRoleRoleName(roleName);

        return ResponseEntity.ok(entities);
    }

    @GetMapping("/findByPublisherId/{publisherId}")
    public ResponseEntity<List<ApplicationModel>> findByPublisherId(@PathVariable Long publisherId) {
        List<ApplicationModel> users = applicationRepository.findAllByPublisherId(publisherId);

        return ResponseEntity.ok(users);
    }
}
