package com.example.courseprojectapi.controllers;

import com.example.courseprojectapi.models.AppCategoryModel;
import com.example.courseprojectapi.repositories.AppCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    AppCategoryRepository appCategoryRepository;

    @GetMapping
    public ResponseEntity<Iterable<AppCategoryModel>> getAllCategories() {
        try {
            Iterable<AppCategoryModel> categoriesList = appCategoryRepository.findAll();

            return ResponseEntity.ok(categoriesList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getCategoryById")
    public ResponseEntity<AppCategoryModel> getCategoryById(@RequestParam Long categoryId) {
        AppCategoryModel category = appCategoryRepository.findById(categoryId).orElse(null);

        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
