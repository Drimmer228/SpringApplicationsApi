package com.example.courseprojectapi.controllers;

import com.example.courseprojectapi.models.RoleModel;
import com.example.courseprojectapi.models.UserModel;
import com.example.courseprojectapi.repositories.ApplicationRepository;
import com.example.courseprojectapi.repositories.SalesStatisticsRepository;
import com.example.courseprojectapi.repositories.UserRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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

    @GetMapping("/getAllUsers")
    public Iterable<UserModel> getUsers() {
        return userRepository.findAll();
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

    @GetMapping("/exportUsersToExcel")
    public ResponseEntity<byte[]> exportUsersToExcel() {
        List<UserModel> users = userRepository.findAll();

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Users");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Username");
            headerRow.createCell(2).setCellValue("Email");
            headerRow.createCell(3).setCellValue("isPainFee");
            headerRow.createCell(4).setCellValue("userPassword");
            headerRow.createCell(5).setCellValue("registrationDate");
            headerRow.createCell(6).setCellValue("roleId");
            headerRow.createCell(7).setCellValue("purchasedAppsCount");
            headerRow.createCell(8).setCellValue("totalSpent");
            headerRow.createCell(9).setCellValue("personalDiscount");
            headerRow.createCell(10).setCellValue("balance");
            headerRow.createCell(11).setCellValue("isActive");

            int rowNum = 1;
            for (UserModel user : users) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(user.getId());
                row.createCell(1).setCellValue(user.getUsername());
                row.createCell(2).setCellValue(user.getEmail());
                if(user.getPainFee() == null) row.createCell(3).setCellValue("");
                else row.createCell(3).setCellValue(user.getPainFee());
                row.createCell(4).setCellValue(user.getUserPassword());
                row.createCell(5).setCellValue(user.getRegistrationDate());
                row.createCell(6).setCellValue(user.getRole().getId());
                row.createCell(7).setCellValue(user.getPurchasedAppsCount());
                row.createCell(8).setCellValue(user.getTotalSpent());
                row.createCell(9).setCellValue(user.getPersonalDiscount());
                row.createCell(10).setCellValue(user.getBalance());
                row.createCell(11).setCellValue(user.isActive());
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=usersData.xlsx");

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
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
