package com.example.courseprojectapi.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Logs")
public class LogModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "app_id")
    private ApplicationModel application;

    @Column(name = "action_desc", nullable = false)
    private String actionDescription;

    @Column(name = "log_date", nullable = false)
    private Date logDate;

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

    public String getActionDescription() {
        return actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }
}
