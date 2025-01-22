package com.backend.AgriLearn.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "savedcategories")
public class SavedCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long savedCategoryID;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private User user;

    @Column(nullable = false)
    private Long categoryID;

    private String picUrl;
    private LocalDateTime savedAt;

    @PrePersist
    protected void onSave() {
        savedAt = LocalDateTime.now();
    }

    public SavedCategory() {
    }

    public SavedCategory(Long savedCategoryID, User user, Long categoryID, String picUrl, LocalDateTime savedAt) {
        this.savedCategoryID = savedCategoryID;
        this.user = user;
        this.categoryID = categoryID;
        this.picUrl = picUrl;
        this.savedAt = savedAt;
    }

    public Long getSavedCategoryID() {
        return savedCategoryID;
    }

    public void setSavedCategoryID(Long savedCategoryID) {
        this.savedCategoryID = savedCategoryID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
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
