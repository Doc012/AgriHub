package com.backend.AgriLearn.entities.livestock;

import com.backend.AgriLearn.entities.Location;
import jakarta.persistence.*;

@Entity
@Table(name = "livestockcategories")
public class LivestockCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LivestockCategoryID")
    private int livestockCategoryID;

    @ManyToOne
    @JoinColumn(name = "LocationID", nullable = false)
    private Location location;

    @Column(nullable = false, name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

    @Column(name = "Pic_url")
    private String picUrl;

    @Column(name = "HasSubCategories", columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean hasSubCategories;

    public LivestockCategory() {
    }

    public LivestockCategory(int livestockCategoryID, Location location, String title, String description, String picUrl, Boolean hasSubCategories) {
        this.livestockCategoryID = livestockCategoryID;
        this.location = location;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.hasSubCategories = hasSubCategories;
    }

    public int getLivestockCategoryID() {
        return livestockCategoryID;
    }

    public void setLivestockCategoryID(int livestockCategoryID) {
        this.livestockCategoryID = livestockCategoryID;
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
