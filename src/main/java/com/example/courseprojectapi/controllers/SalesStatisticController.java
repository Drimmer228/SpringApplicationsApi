package com.example.courseprojectapi.controllers;

import com.example.courseprojectapi.models.SalesStatisticsModel;
import com.example.courseprojectapi.repositories.ApplicationRepository;
import com.example.courseprojectapi.repositories.SalesStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/statistic")
public class SalesStatisticController {
    @Autowired
    SalesStatisticsRepository salesStatisticsRepository;
    @Autowired
    ApplicationRepository applicationRepository;
    @GetMapping("/{id}")
    private String getPageStatistic(@PathVariable long id, Model model){
        model.addAttribute("appl", applicationRepository.findApplicationModelById(id));
        return "application/statistic_page";
    }

    @GetMapping("/salesData/{id}")
    public ResponseEntity<List<SalesStatisticsModel>> downloadImage(@PathVariable Long id) {
        List<SalesStatisticsModel> salesStatisticsModelList = salesStatisticsRepository.findAllByApplicationId(id);

        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(salesStatisticsModelList);
    }

    @GetMapping("/findByApplicationId/{applicationId}")
    public ResponseEntity<List<SalesStatisticsModel>> findByApplicationId(@PathVariable Long applicationId) {
        List<SalesStatisticsModel> sales = salesStatisticsRepository.findAllByApplicationId(applicationId);

        return ResponseEntity.ok(sales);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SalesStatisticsModel>> getAllSalesStatistics() {
        Iterable<SalesStatisticsModel> salesIterable = salesStatisticsRepository.findAll();
        List<SalesStatisticsModel> sales = new ArrayList<>();

        salesIterable.forEach(sales::add);

        return ResponseEntity.ok(sales);
    }
}
