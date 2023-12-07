package com.example.courseprojectapi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "UserLibrary")
public class UserLibraryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "app_id")
    private ApplicationModel application;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public ApplicationModel getApplication() {
        return application;
    }

    public void setApplication(ApplicationModel application) {
        this.application = application;
    }

    // Constructors, getters, and setters
}
