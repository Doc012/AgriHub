package com.backend.AgriLearn.entities.crop;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CropGroups")
public class CropGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cropGroupID;

    @ManyToOne
    @JoinColumn(name = "CropCategoryID", nullable = false)
    private CropCategory cropCategory;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "Pic_url")
    private String picUrl;

    public CropGroup() {
    }

    public CropGroup(int cropGroupID, CropCategory cropCategory, String title, String description, String picUrl) {
        this.cropGroupID = cropGroupID;
        this.cropCategory = cropCategory;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
    }

    public int getCropGroupID() {
        return cropGroupID;
    }

    public void setCropGroupID(int cropGroupID) {
        this.cropGroupID = cropGroupID;
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
