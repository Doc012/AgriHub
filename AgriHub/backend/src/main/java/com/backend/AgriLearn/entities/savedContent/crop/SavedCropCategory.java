package com.backend.AgriLearn.entities.savedContent.crop;

import com.backend.AgriLearn.entities.User;
import com.backend.AgriLearn.entities.crop.CropCategory;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "SavedCropCategories")
public class SavedCropCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SavedCategoryID")
    private int savedCategoryID;

    @ManyToOne
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "CropCategoryID", nullable = false)
    private CropCategory cropCategory;

    @Column(name = "SavedAt", nullable = false, updatable = false)
    private LocalDateTime savedAt;

    @Column(name = "Pic_url")
    private String picUrl;


    @PrePersist
    protected void onCreate() {
        this.savedAt = LocalDateTime.now();
    }

    public SavedCropCategory() {
    }

    public SavedCropCategory(User user, CropCategory cropCategory, String picUrl) {
        this.user = user;
        this.picUrl = picUrl;
        this.cropCategory = cropCategory;
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

    public CropCategory getCropCategory() {
        return cropCategory;
    }

    public void setCropCategory(CropCategory cropCategory) {
        this.cropCategory = cropCategory;
    }

    public LocalDateTime getSavedAt() {
        return savedAt;
    }

    public void setSavedAt(LocalDateTime savedAt) {
        this.savedAt = savedAt;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
