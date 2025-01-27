package com.backend.AgriLearn.entities.savedContent;

import com.backend.AgriLearn.entities.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "savedsubcategories")
public class SavedSubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SavedSubCategoryID")
    private int savedSubCategoryID;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @Column(nullable = false, name = "SubCategoryID")
    private int subCategoryID;

    @Column(name = "Pic_url")
    private String picUrl;

    @Column(name = "SavedAt")
    private LocalDateTime savedAt;

    @PrePersist
    protected void onSave() {
        savedAt = LocalDateTime.now();
    }

    public SavedSubCategory() {
    }

    public int getSavedSubCategoryID() {
        return savedSubCategoryID;
    }

    public void setSavedSubCategoryID(int savedSubCategoryID) {
        this.savedSubCategoryID = savedSubCategoryID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getSubCategoryID() {
        return subCategoryID;
    }

    public void setSubCategoryID(int subCategoryID) {
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
