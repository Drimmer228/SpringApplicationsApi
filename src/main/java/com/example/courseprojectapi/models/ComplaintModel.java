package com.example.courseprojectapi.models;


import jakarta.persistence.*;

@Entity
@Table(name = "Complaints")
public class ComplaintModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "app_id")
    private ApplicationModel application;

    @Column(name = "complaint_text", columnDefinition = "TEXT", nullable = false)
    private String complaintText;

    @ManyToOne
    @JoinColumn(name = "solution_id")
    private SolutionModel solution;

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

    public String getComplaintText() {
        return complaintText;
    }

    public void setComplaintText(String complaintText) {
        this.complaintText = complaintText;
    }

    public void setSolution(SolutionModel solution) {
        this.solution = solution;
    }

    public SolutionModel getSolution() {
        return solution;
    }
}
