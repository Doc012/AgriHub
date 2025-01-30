package com.backend.AgriLearn.entities.savedContent.crop;

import com.backend.AgriLearn.entities.User;
import com.backend.AgriLearn.entities.crop.CropSubCategory;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "SavedCropSubCategories", uniqueConstraints = {@UniqueConstraint(columnNames = {"UserID", "CropSubCategoryID"})})
public class SavedCropSubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SavedCategoryID")
    private int savedCategoryID;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "CropSubCategoryID", nullable = false)
    private CropSubCategory cropSubCategory;

    @Column(name = "SavedAt", nullable = false, updatable = false)
    private LocalDateTime savedAt;

    @Column(name = "Pic_url")
    private String picUrl;

    @PrePersist
    protected void onCreate() {
        this.savedAt = LocalDateTime.now();
    }

    public SavedCropSubCategory() {
    }

    public SavedCropSubCategory(User user, CropSubCategory cropSubCategory, String picUrl) {
        this.user = user;
        this.cropSubCategory = cropSubCategory;
        this.picUrl = picUrl;
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

    public CropSubCategory getCropSubCategory() {
        return cropSubCategory;
    }

    public void setCropSubCategory(CropSubCategory cropSubCategory) {
        this.cropSubCategory = cropSubCategory;
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
