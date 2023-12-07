package com.example.courseprojectapi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "notifications")
public class NotificationsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "is_read")
    private boolean isRead;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @Column(name = "message")
    private String message;

    public Long getId() {
        return id;
    }

    public boolean isRead() {
        return isRead;
    }

    public String getMessage() {
        return message;
    }

    public UserModel getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
