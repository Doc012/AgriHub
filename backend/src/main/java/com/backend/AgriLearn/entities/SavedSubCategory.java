package com.backend.AgriLearn.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "savedsubcategories")
public class SavedSubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long savedSubCategoryID;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private User user;

    @Column(nullable = false)
    private Long subCategoryID;

    private String picUrl;
    private LocalDateTime savedAt;

    @PrePersist
    protected void onSave() {
        savedAt = LocalDateTime.now();
    }

    public SavedSubCategory() {
    }

    public Long getSavedSubCategoryID() {
        return savedSubCategoryID;
    }

    public void setSavedSubCategoryID(Long savedSubCategoryID) {
        this.savedSubCategoryID = savedSubCategoryID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getSubCategoryID() {
        return subCategoryID;
    }

    public void setSubCategoryID(Long subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public LocalDateTime getSavedAt() {
        return savedAt;
    }

    public void setSavedAt(LocalDateTime savedAt) {
        this.savedAt = savedAt;
    }
}
