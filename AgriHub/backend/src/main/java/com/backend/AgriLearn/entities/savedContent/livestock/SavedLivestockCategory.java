package com.backend.AgriLearn.entities.savedContent.livestock;

import com.backend.AgriLearn.entities.livestock.LivestockCategory;
import com.backend.User.entities.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "SavedLivestockCategories")
public class SavedLivestockCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SavedCategoryID")
    private int savedCategoryID;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "LivestockCategoryID", nullable = false)
    private LivestockCategory livestockCategory;

    @Column(name = "SavedAt", nullable = false, updatable = false)
    private LocalDateTime savedAt;

    @Column(name = "Pic_url")
    private String picUrl;

    @PrePersist
    protected void onCreate(){
        this.savedAt = LocalDateTime.now();
    }

    public SavedLivestockCategory() {
    }

    public SavedLivestockCategory(User user, LivestockCategory livestockCategory, String picUrl) {
        this.user = user;
        this.picUrl = picUrl;
        this.livestockCategory = livestockCategory;
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

    public LivestockCategory getLivestockCategory() {
        return livestockCategory;
    }

    public void setLivestockCategory(LivestockCategory livestockCategory) {
        this.livestockCategory = livestockCategory;
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
