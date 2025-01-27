package com.backend.AgriLearn.entities.livestock;


import jakarta.persistence.*;

@Entity
@Table(name = "livestocksubcategoryobjectives")
public class LivestockSubCategoryObjective {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LivestockSubCategoryObjectiveID")
    private int livestockSubCategoryObjectiveID;

    @ManyToOne
    @JoinColumn(name = "LivestockSubCategoryID", nullable = false)
    private LivestockSubCategory livestockSubCategory;

    @Column(nullable = false, name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

    @Column(name = "Pic_url")
    private String picUrl;

    public LivestockSubCategoryObjective() {
    }

    public LivestockSubCategoryObjective(int livestockSubCategoryObjectiveID, LivestockSubCategory livestockSubCategory, String title, String description, String picUrl) {
        this.livestockSubCategoryObjectiveID = livestockSubCategoryObjectiveID;
        this.livestockSubCategory = livestockSubCategory;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
    }

    public int getLivestockSubCategoryObjectiveID() {
        return livestockSubCategoryObjectiveID;
    }

    public void setLivestockSubCategoryObjectiveID(int livestockSubCategoryObjectiveID) {
        this.livestockSubCategoryObjectiveID = livestockSubCategoryObjectiveID;
    }

    public LivestockSubCategory getLivestockSubCategory() {
        return livestockSubCategory;
    }

    public void setLivestockSubCategory(LivestockSubCategory livestockSubCategory) {
        this.livestockSubCategory = livestockSubCategory;
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
