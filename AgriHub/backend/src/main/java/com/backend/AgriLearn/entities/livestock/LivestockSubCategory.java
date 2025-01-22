package com.backend.AgriLearn.entities.livestock;

import jakarta.persistence.*;

@Entity
@Table(name = "livestocksubcategories")
public class LivestockSubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long livestockSubCategoryID;

    @ManyToOne
    @JoinColumn(name = "livestockCategoryID", nullable = false)
    private LivestockCategory livestockCategory;

    @Column(nullable = false)
    private String title;

    private String description;
    private String picUrl;

    public LivestockSubCategory() {
    }

    public LivestockSubCategory(Long livestockSubCategoryID, LivestockCategory livestockCategory, String title, String description, String picUrl) {
        this.livestockSubCategoryID = livestockSubCategoryID;
        this.livestockCategory = livestockCategory;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
    }

    public Long getLivestockSubCategoryID() {
        return livestockSubCategoryID;
    }

    public void setLivestockSubCategoryID(Long livestockSubCategoryID) {
        this.livestockSubCategoryID = livestockSubCategoryID;
    }

    public LivestockCategory getLivestockCategory() {
        return livestockCategory;
    }

    public void setLivestockCategory(LivestockCategory livestockCategory) {
        this.livestockCategory = livestockCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
