package com.backend.AgriLearn.entities.crop;

import jakarta.persistence.*;

@Entity
@Table(name = "cropsubcategoryobjectives")
public class CropSubCategoryObjective {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CropSubCategoryObjectiveID")
    private int cropSubCategoryObjectiveID;

    @ManyToOne
    @JoinColumn(name = "CropSubCategoryID", nullable = false)
    private CropSubCategory cropSubCategory;

    @Column(nullable = false, name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

    @Column(name = "Pic_url")
    private String picUrl;

    public CropSubCategoryObjective() {
    }

    public CropSubCategoryObjective(int cropSubCategoryObjectiveID, CropSubCategory cropSubCategory, String title, String description, String picUrl) {
        this.cropSubCategoryObjectiveID = cropSubCategoryObjectiveID;
        this.cropSubCategory = cropSubCategory;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
    }

    public int getCropSubCategoryObjectiveID() {
        return cropSubCategoryObjectiveID;
    }

    public void setCropSubCategoryObjectiveID(int cropSubCategoryObjectiveID) {
        this.cropSubCategoryObjectiveID = cropSubCategoryObjectiveID;
    }

    public CropSubCategory getCropSubCategory() {
        return cropSubCategory;
    }

    public void setCropSubCategory(CropSubCategory cropSubCategory) {
        this.cropSubCategory = cropSubCategory;
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
