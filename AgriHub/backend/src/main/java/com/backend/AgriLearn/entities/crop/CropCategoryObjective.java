package com.backend.AgriLearn.entities.crop;

import jakarta.persistence.*;

@Entity
@Table(name = "cropcategoryobjectives")
public class CropCategoryObjective {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CropCategoryObjectiveID")
    private int cropCategoryObjectiveID;

    @ManyToOne
    @JoinColumn(name = "CropCategoryID", nullable = false)
    private CropCategory cropCategory;

    @Column(nullable = false, name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

    @Column(name = "Pic_url")
    private String picUrl;

    public CropCategoryObjective() {
    }

    public CropCategoryObjective(int cropCategoryObjectiveID, CropCategory cropCategory, String title, String description, String picUrl) {
        this.cropCategoryObjectiveID = cropCategoryObjectiveID;
        this.cropCategory = cropCategory;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
    }

    public int getCropCategoryObjectiveID() {
        return cropCategoryObjectiveID;
    }

    public void setCropCategoryObjectiveID(int cropCategoryObjectiveID) {
        this.cropCategoryObjectiveID = cropCategoryObjectiveID;
    }

    public CropCategory getCropCategory() {
        return cropCategory;
    }

    public void setCropCategory(CropCategory cropCategory) {
        this.cropCategory = cropCategory;
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
