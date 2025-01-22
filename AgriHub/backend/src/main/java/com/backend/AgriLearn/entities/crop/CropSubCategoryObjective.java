package com.backend.AgriLearn.entities.crop;

import jakarta.persistence.*;

@Entity
@Table(name = "cropsubcategoryobjectives")
public class CropSubCategoryObjective {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cropSubCategoryObjectiveID;

    @ManyToOne
    @JoinColumn(name = "cropSubCategoryID", nullable = false)
    private CropSubCategory cropSubCategory;

    @Column(nullable = false)
    private String title;

    private String description;
    private String picUrl;

    public CropSubCategoryObjective() {
    }

    public CropSubCategoryObjective(Long cropSubCategoryObjectiveID, CropSubCategory cropSubCategory, String title, String description, String picUrl) {
        this.cropSubCategoryObjectiveID = cropSubCategoryObjectiveID;
        this.cropSubCategory = cropSubCategory;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
    }

    public Long getCropSubCategoryObjectiveID() {
        return cropSubCategoryObjectiveID;
    }

    public void setCropSubCategoryObjectiveID(Long cropSubCategoryObjectiveID) {
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
