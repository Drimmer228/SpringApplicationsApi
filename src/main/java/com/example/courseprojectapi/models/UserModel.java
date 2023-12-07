package com.example.courseprojectapi.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "paid_fee")
    private Boolean isPainFee;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleModel role;

    @Column(name = "purchased_apps_count", nullable = false)
    private int purchasedAppsCount;

    @Column(name = "total_spent", nullable = false)
    private double totalSpent;

    @Column(name = "personal_discount", nullable = false)
    private double personalDiscount;

    @Column(name = "balance", nullable = false)
    private double balance;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    public void setPainFee(Boolean painFee) {
        isPainFee = painFee;
    }

    public Boolean getPainFee() {
        return isPainFee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

    public int getPurchasedAppsCount() {
        return purchasedAppsCount;
    }

    public void setPurchasedAppsCount(int purchasedAppsCount) {
        this.purchasedAppsCount = purchasedAppsCount;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
    }

    public double getPersonalDiscount() {
        return personalDiscount;
    }

    public void setPersonalDiscount(double personalDiscount) {
        this.personalDiscount = personalDiscount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    // Constructors, getters, and setters
}
