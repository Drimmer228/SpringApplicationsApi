package com.example.courseprojectapi.models;


import jakarta.persistence.*;

@Entity
@Table(name = "Applications")
public class ApplicationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "application_name", nullable = false)
    private String applicationName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "price", nullable = false)
    private double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private AppCategoryModel category;
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private UserModel publisher;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private ApplicationStatusModel status;

    @Column(name = "image_of_app", columnDefinition = "VARBINARY(MAX)")
    private byte[] imageApp;

    @Column(name = "name_executable_file")
    private String nameExecutableFile;

    @Column(name = "executable_file", columnDefinition = "VARBINARY(MAX)")
    private byte[] executableFile;

    @Column(name = "purchase_count", nullable = false)
    private int purchaseCount;

    @Column(name = "complaint_count", nullable = false)
    private double complaintCount;

    @Column(name = "occupied_space")
    private String occupiedSpace;

    @Column(name = "age_limit")
    private String ageLimit;

    @Column(name="is_active")
    private Boolean isActive;

    public void setImageApp(byte[] imageApp) {
        this.imageApp = imageApp;
    }

    public byte[] getImageApp() {
        return imageApp;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getActive() {
        return isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNameExecutableFile(String nameExecutableFile) {
        this.nameExecutableFile = nameExecutableFile;
    }

    public String getNameExecutableFile() {
        return nameExecutableFile;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public AppCategoryModel getCategory() {
        return category;
    }

    public void setCategory(AppCategoryModel category) {
        this.category = category;
    }

    public UserModel getPublisher() {
        return publisher;
    }

    public void setPublisher(UserModel publisher) {
        this.publisher = publisher;
    }

    public byte[] getExecutableFile() {
        return executableFile;
    }

    public void setExecutableFile(byte[] executableFile) {
        this.executableFile = executableFile;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(int purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public double getComplaintCount() {
        return complaintCount;
    }

    public void setComplaintCount(double complaintCount) {
        this.complaintCount = complaintCount;
    }

    public String getOccupiedSpace() {
        return occupiedSpace;
    }

    public void setOccupiedSpace(String occupiedSpace) {
        this.occupiedSpace = occupiedSpace;
    }

    public String getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }

    public ApplicationStatusModel getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatusModel status) {
        this.status = status;
    }
}
