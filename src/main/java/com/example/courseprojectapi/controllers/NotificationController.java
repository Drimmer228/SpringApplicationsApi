package com.example.courseprojectapi.controllers;

import com.example.courseprojectapi.models.ApplicationModel;
import com.example.courseprojectapi.models.NotificationsModel;
import com.example.courseprojectapi.models.UserModel;
import com.example.courseprojectapi.repositories.NotificationRepository;
import com.example.courseprojectapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/notify")
public class NotificationController {
    @Autowired
    private NotificationRepository notificationRepository;
    @PostMapping("/save")
    public ResponseEntity<String> saveNotification(@RequestBody NotificationsModel notificationsModel) {
        try {
            notificationRepository.save(notificationsModel);
            return ResponseEntity.ok("Notification saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save notification");
        }
    }

    @GetMapping("/findByUserId/{userId}")
    public ResponseEntity<List<NotificationsModel>> findByUserId(@PathVariable Long userId) {
        Iterable<NotificationsModel> notificationsIterable = notificationRepository.findAllByUserId(userId);

        List<NotificationsModel> notifications = new ArrayList<>();

        notificationsIterable.forEach(notifications::add);

        return ResponseEntity.ok(notifications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationsModel> getNotificationById(@PathVariable Long id) {
        Optional<NotificationsModel> notificationOptional = notificationRepository.findById(id);

        return ResponseEntity.ok(notificationOptional.get());
    }

    @DeleteMapping("/deleteByUserId/{userId}")
    public ResponseEntity<String> deleteNotificationsByUserId(@PathVariable Long userId) {
        try {
            notificationRepository.deleteAllByUserId(userId);
            return ResponseEntity.ok("Notifications for user with ID " + userId + " deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete notifications for user with ID " + userId);
        }
    }
}

