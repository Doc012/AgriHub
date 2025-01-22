package com.backend.AgriLearn.entities.livestock;

import jakarta.persistence.*;

@Entity
@Table(name = "livestockcategoryobjectives")
public class LivestockCategoryObjective {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long livestockCategoryObjectiveID;

    @ManyToOne
    @JoinColumn(name = "livestockCategoryID", nullable = false)
    private LivestockCategory livestockCategory;

    @Column(nullable = false)
    private String title;

    private String description;
    private String picUrl;

    public LivestockCategoryObjective() {
    }

    public LivestockCategoryObjective(Long livestockCategoryObjectiveID, LivestockCategory livestockCategory, String title, String description, String picUrl) {
        this.livestockCategoryObjectiveID = livestockCategoryObjectiveID;
        this.livestockCategory = livestockCategory;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
    }

    public Long getLivestockCategoryObjectiveID() {
        return livestockCategoryObjectiveID;
    }

    public void setLivestockCategoryObjectiveID(Long livestockCategoryObjectiveID) {
        this.livestockCategoryObjectiveID = livestockCategoryObjectiveID;
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
