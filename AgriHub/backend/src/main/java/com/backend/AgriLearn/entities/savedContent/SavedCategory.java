package com.backend.AgriLearn.entities.savedContent;

import com.backend.AgriLearn.entities.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "savedcategories")
public class SavedCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SavedCategoryID")
    private int savedCategoryID;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @Column(nullable = false, name = "CategoryID")
    private int categoryID;

    @Column(name = "Pic_url")
    private String picUrl;

    @Column(name = "SavedAt")
    private LocalDateTime savedAt;

    @PrePersist
    protected void onSave() {
        savedAt = LocalDateTime.now();
    }

    public SavedCategory() {
    }

    public SavedCategory(int savedCategoryID, User user, int categoryID, String picUrl, LocalDateTime savedAt) {
        this.savedCategoryID = savedCategoryID;
        this.user = user;
        this.categoryID = categoryID;
        this.picUrl = picUrl;
        this.savedAt = savedAt;
    }

    public int getSavedCategoryID() {
        return savedCategoryID;
    }

    public void setSavedCategoryID(int savedCategoryID) {
        this.savedCategoryID = savedCategoryID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
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
