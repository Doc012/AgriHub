package com.backend.AgriLearn.entities.livestock;

import jakarta.persistence.*;

@Entity
@Table(name = "livestocksubcategories")
public class LivestockSubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LivestockSubCategoryID")
    private int livestockSubCategoryID;

    @ManyToOne
    @JoinColumn(name = "LivestockCategoryID", nullable = false)
    private LivestockCategory livestockCategory;

    @Column(nullable = false, name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

    @Column(name = "Pic_url")
    private String picUrl;

    public LivestockSubCategory() {
    }

    public LivestockSubCategory(int livestockSubCategoryID, LivestockCategory livestockCategory, String title, String description, String picUrl) {
        this.livestockSubCategoryID = livestockSubCategoryID;
        this.livestockCategory = livestockCategory;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
    }

    public int getLivestockSubCategoryID() {
        return livestockSubCategoryID;
    }

    public void setLivestockSubCategoryID(int livestockSubCategoryID) {
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
