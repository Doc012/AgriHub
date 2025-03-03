package com.backend.AgriLearn.entities.crop;

import com.backend.AgriLearn.entities.District;
import jakarta.persistence.*;

@Entity
@Table(name = "cropcategories")
public class CropCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CropCategoryID")
    private int cropCategoryID;

    @ManyToOne
    @JoinColumn(name = "DistrictID", nullable = false)
    private District district;

    @Column(nullable = false, name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

    @Column(name = "Pic_url")
    private String picUrl;

    @Column(name = "HasSubCategories", columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean hasSubCategories;

    public CropCategory() {
    }

    public CropCategory(int cropCategoryID, District district, String title, String description, String picUrl, Boolean hasSubCategories) {
        this.cropCategoryID = cropCategoryID;
        this.district = district;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.hasSubCategories = hasSubCategories;
    }

    public int getCropCategoryID() {
        return cropCategoryID;
    }

    public void setCropCategoryID(int cropCategoryID) {
        this.cropCategoryID = cropCategoryID;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
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

    public Boolean getHasSubCategories() {
        return hasSubCategories;
    }

    public void setHasSubCategories(Boolean hasSubCategories) {
        this.hasSubCategories = hasSubCategories;
    }
}
