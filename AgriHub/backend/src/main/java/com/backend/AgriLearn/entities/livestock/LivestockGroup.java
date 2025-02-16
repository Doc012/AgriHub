package com.backend.AgriLearn.entities.livestock;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "LivestockGroups")
public class LivestockGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int livestockGroupID;

    @ManyToOne
    @JoinColumn(name = "LivestockCategoryID", nullable = false)
    private LivestockCategory livestockCategory;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "Pic_url", length = 255)
    private String picUrl;

    public LivestockGroup() {
    }

    public LivestockGroup(int livestockGroupID, LivestockCategory livestockCategory, String title, String description, String picUrl) {
        this.livestockGroupID = livestockGroupID;
        this.livestockCategory = livestockCategory;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
    }

    public int getLivestockGroupID() {
        return livestockGroupID;
    }

    public void setLivestockGroupID(int livestockGroupID) {
        this.livestockGroupID = livestockGroupID;
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
