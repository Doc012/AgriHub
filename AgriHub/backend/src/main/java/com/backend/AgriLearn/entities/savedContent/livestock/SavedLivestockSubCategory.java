package com.backend.AgriLearn.entities.savedContent.livestock;

import com.backend.AgriLearn.entities.User;
import com.backend.AgriLearn.entities.livestock.LivestockCategory;
import com.backend.AgriLearn.entities.livestock.LivestockSubCategory;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "SavedLivestockSubCategories")
public class SavedLivestockSubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SavedCategoryID")
    private int savedCategoryID;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "LivestockSubCategoryID", nullable = false)
    private LivestockSubCategory livestockSubCategory;

    @Column(name = "SavedAt", nullable = false, updatable = false)
    private LocalDateTime savedAt;

    @Column(name = "Pic_url")
    private String picUrl;

    @PrePersist
    protected void onCreate() {
        this.savedAt = LocalDateTime.now();
    }

    public SavedLivestockSubCategory() {
    }

    public SavedLivestockSubCategory(User user, LivestockSubCategory livestockSubCategory, String picUrl) {
        this.user = user;
        this.livestockSubCategory = livestockSubCategory;
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

    public LivestockSubCategory getLivestockSubCategory() {
        return livestockSubCategory;
    }

    public void setLivestockSubCategory(LivestockSubCategory livestockSubCategory) {
        this.livestockSubCategory = livestockSubCategory;
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
