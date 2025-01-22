package com.backend.AgriLearn.entities.livestock;

import jakarta.persistence.*;

@Entity
@Table(name = "livestocksubcategoryobjectivecontent")
public class LivestockSubCategoryObjectiveContent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long livestockSubCategoryObjectiveContentID;

    @ManyToOne
    @JoinColumn(name = "livestockSubCategoryObjectiveID", nullable = false)
    private LivestockSubCategoryObjective livestockSubCategoryObjective;
    
    @Column(nullable = false)
    private String title;
    
    private String description;
    private String picUrl;
    private String vidUrl;
    
    public LivestockSubCategoryObjectiveContent() {
    }

    public LivestockSubCategoryObjectiveContent(Long livestockSubCategoryObjectiveContentID, LivestockSubCategoryObjective livestockSubCategoryObjective, String title, String description, String picUrl, String vidUrl) {
        this.livestockSubCategoryObjectiveContentID = livestockSubCategoryObjectiveContentID;
        this.livestockSubCategoryObjective = livestockSubCategoryObjective;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.vidUrl = vidUrl;
    }

    public Long getLivestockSubCategoryObjectiveContentID() {
        return livestockSubCategoryObjectiveContentID;
    }

    public void setLivestockSubCategoryObjectiveContentID(Long livestockSubCategoryObjectiveContentID) {
        this.livestockSubCategoryObjectiveContentID = livestockSubCategoryObjectiveContentID;
    }

    public LivestockSubCategoryObjective getLivestockSubCategoryObjective() {
        return livestockSubCategoryObjective;
    }

    public void setLivestockSubCategoryObjective(LivestockSubCategoryObjective livestockSubCategoryObjective) {
        this.livestockSubCategoryObjective = livestockSubCategoryObjective;
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

    public String getVidUrl() {
        return vidUrl;
    }

    public void setVidUrl(String vidUrl) {
        this.vidUrl = vidUrl;
    }
}
