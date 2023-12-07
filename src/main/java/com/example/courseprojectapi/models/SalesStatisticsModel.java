package com.example.courseprojectapi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "SalesStatistics")
public class SalesStatisticsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "app_id")
    private ApplicationModel application;

    @Column(name = "purchase_count", nullable = false)
    private int purchaseCount;

    @Column(name = "purchase_month", nullable = false)
    private String purchaseMonth;

    @Column(name = "purchase_price", nullable = false)
    private double purchasePrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ApplicationModel getApplication() {
        return application;
    }

    public void setApplication(ApplicationModel application) {
        this.application = application;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(int purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public String getPurchaseMonth() {
        return purchaseMonth;
    }

    public void setPurchaseMonth(String purchaseMonth) {
        this.purchaseMonth = purchaseMonth;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}
