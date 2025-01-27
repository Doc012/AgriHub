package com.backend.AgriLearn.entities.livestock;

import jakarta.persistence.*;

@Entity
@Table(name = "livestockcategoryobjectivecontents")
public class LivestockCategoryObjectiveContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LivestockCategoryObjectiveContentID")
    private int livestockCategoryObjectiveContentID;

    @ManyToOne
    @JoinColumn(name = "LivestockCategoryObjectiveID", nullable = false)
    private LivestockCategoryObjective livestockCategoryObjective;

    @Column(nullable = false, name = "Title")
    private String title;

    @Column(name = "Content")
    private String content;

    @Column(name = "Pic_url")
    private String picUrl;

    @Column(name = "Vid_url")
    private String vidUrl;

    public LivestockCategoryObjectiveContent() {
    }

    public LivestockCategoryObjectiveContent(int livestockCategoryObjectiveContentID, LivestockCategoryObjective livestockCategoryObjective, String title, String content, String picUrl, String vidUrl) {
        this.livestockCategoryObjectiveContentID = livestockCategoryObjectiveContentID;
        this.livestockCategoryObjective = livestockCategoryObjective;
        this.title = title;
        this.content = content;
        this.picUrl = picUrl;
        this.vidUrl = vidUrl;
    }

    public int getLivestockCategoryObjectiveContentID() {
        return livestockCategoryObjectiveContentID;
    }

    public void setLivestockCategoryObjectiveContentID(int livestockCategoryObjectiveContentID) {
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
