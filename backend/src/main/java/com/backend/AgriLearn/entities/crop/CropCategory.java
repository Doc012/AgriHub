package com.backend.AgriLearn.entities.crop;

import com.backend.AgriLearn.entities.Location;
import jakarta.persistence.*;

@Entity
@Table(name = "cropcategories")
public class CropCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cropCategoryID;

    @ManyToOne
    @JoinColumn(name = "locationID", nullable = false)
    private Location location;

    @Column(nullable = false)
    private String title;

    private String description;
    private String picUrl;
    private Boolean hasSubCategories;

    public CropCategory() {
    }

    public CropCategory(Long cropCategoryID, Location location, String title, String description, String picUrl, Boolean hasSubCategories) {
        this.cropCategoryID = cropCategoryID;
        this.location = location;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.hasSubCategories = hasSubCategories;
    }

    public Long getCropCategoryID() {
        return cropCategoryID;
    }

    public void setCropCategoryID(Long cropCategoryID) {
        this.cropCategoryID = cropCategoryID;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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
