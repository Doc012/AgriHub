package com.backend.AgriLearn.entities.livestock;

import jakarta.persistence.*;

@Entity
@Table(name = "livestockcategoryobjectives")
public class LivestockCategoryObjectiveContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long livestockCategoryObjectiveContentID;

    @ManyToOne
    @JoinColumn(name = "livestockCategoryObjectiveID", nullable = false)
    private LivestockCategoryObjective livestockCategoryObjective;

    @Column(nullable = false)
    private String title;

    private String description;
    private String picUrl;
    private String vidUrl;

    public LivestockCategoryObjectiveContent() {
    }

    public LivestockCategoryObjectiveContent(Long livestockCategoryObjectiveContentID, LivestockCategoryObjective livestockCategoryObjective, String title, String description, String picUrl, String vidUrl) {
        this.livestockCategoryObjectiveContentID = livestockCategoryObjectiveContentID;
        this.livestockCategoryObjective = livestockCategoryObjective;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.vidUrl = vidUrl;
    }

    public Long getLivestockCategoryObjectiveContentID() {
        return livestockCategoryObjectiveContentID;
    }

    public void setLivestockCategoryObjectiveContentID(Long livestockCategoryObjectiveContentID) {
        this.livestockCategoryObjectiveContentID = livestockCategoryObjectiveContentID;
    }

    public LivestockCategoryObjective getLivestockCategoryObjective() {
        return livestockCategoryObjective;
    }

    public void setLivestockCategoryObjective(LivestockCategoryObjective livestockCategoryObjective) {
        this.livestockCategoryObjective = livestockCategoryObjective;
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
