package com.backend.AgriLearn.entities.crop;


import jakarta.persistence.*;

@Entity
@Table(name = "cropsubcategories")
public class CropSubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cropSubCategoryID;

    @ManyToOne
    @JoinColumn(name = "cropCategoryID", nullable = false)
    private CropCategory cropCategory;

    @Column(nullable = false)
    private String title;

    private String description;
    private String picUrl;

    public CropSubCategory() {
    }

    public CropSubCategory(Long cropSubCategoryID, CropCategory cropCategory, String title, String description, String picUrl) {
        this.cropSubCategoryID = cropSubCategoryID;
        this.cropCategory = cropCategory;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
    }

    public Long getCropSubCategoryID() {
        return cropSubCategoryID;
    }

    public void setCropSubCategoryID(Long cropSubCategoryID) {
        this.cropSubCategoryID = cropSubCategoryID;
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
