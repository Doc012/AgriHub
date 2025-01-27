package com.backend.AgriLearn.entities.livestock;

import jakarta.persistence.*;

@Entity
@Table(name = "livestockcategoryobjectives")
public class LivestockCategoryObjective {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LivestockCategoryObjectiveID")
    private int livestockCategoryObjectiveID;

    @ManyToOne
    @JoinColumn(name = "LivestockCategoryID", nullable = false)
    private LivestockCategory livestockCategory;

    @Column(nullable = false, name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

    @Column(name = "Pic_url")
    private String picUrl;

    public LivestockCategoryObjective() {
    }

    public LivestockCategoryObjective(int livestockCategoryObjectiveID, LivestockCategory livestockCategory, String title, String description, String picUrl) {
        this.livestockCategoryObjectiveID = livestockCategoryObjectiveID;
        this.livestockCategory = livestockCategory;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
    }

    public int getLivestockCategoryObjectiveID() {
        return livestockCategoryObjectiveID;
    }

    public void setLivestockCategoryObjectiveID(int livestockCategoryObjectiveID) {
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
