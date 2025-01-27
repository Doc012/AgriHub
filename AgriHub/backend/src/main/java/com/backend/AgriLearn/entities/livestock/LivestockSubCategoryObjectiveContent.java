package com.backend.AgriLearn.entities.livestock;

import jakarta.persistence.*;

@Entity
@Table(name = "livestocksubcategoryobjectivecontents")
public class LivestockSubCategoryObjectiveContent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LivestockSubCategoryObjectiveContentID")
    private int livestockSubCategoryObjectiveContentID;

    @ManyToOne
    @JoinColumn(name = "LivestockSubCategoryObjectiveID", nullable = false)
    private LivestockSubCategoryObjective livestockSubCategoryObjective;
    
    @Column(nullable = false, name = "Title")
    private String title;

    @Column(name = "Content")
    private String content;

    @Column(name = "Pic_url")
    private String picUrl;

    @Column(name = "Vid_url")
    private String vidUrl;
    
    public LivestockSubCategoryObjectiveContent() {
    }

    public LivestockSubCategoryObjectiveContent(int livestockSubCategoryObjectiveContentID, LivestockSubCategoryObjective livestockSubCategoryObjective, String title, String content, String picUrl, String vidUrl) {
        this.livestockSubCategoryObjectiveContentID = livestockSubCategoryObjectiveContentID;
        this.livestockSubCategoryObjective = livestockSubCategoryObjective;
        this.title = title;
        this.content = content;
        this.picUrl = picUrl;
        this.vidUrl = vidUrl;
    }

    public int getLivestockSubCategoryObjectiveContentID() {
        return livestockSubCategoryObjectiveContentID;
    }

    public void setLivestockSubCategoryObjectiveContentID(int livestockSubCategoryObjectiveContentID) {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
