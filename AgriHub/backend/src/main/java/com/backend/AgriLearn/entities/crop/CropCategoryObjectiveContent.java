package com.backend.AgriLearn.entities.crop;

import jakarta.persistence.*;

@Entity
@Table(name = "cropcategoryobjectivecontents")
public class CropCategoryObjectiveContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CropCategoryObjectiveContentID")
    private int cropCategoryObjectiveContentID;

    @ManyToOne
    @JoinColumn(name = "CropCategoryObjectiveID", nullable = false)
    private CropCategoryObjective cropCategoryObjective;

    @Column(nullable = false, name = "Title")
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false, name = "Content")
    private String content;

    @Column(name = "Pic_url")
    private String picUrl;

    @Column(name = "Vid_url")
    private String vidUrl;

    public CropCategoryObjectiveContent() {
    }

    public CropCategoryObjectiveContent(int cropCategoryObjectiveContentID, CropCategoryObjective cropCategoryObjective, String title, String content, String picUrl, String vidUrl) {
        this.cropCategoryObjectiveContentID = cropCategoryObjectiveContentID;
        this.cropCategoryObjective = cropCategoryObjective;
        this.title = title;
        this.content = content;
        this.picUrl = picUrl;
        this.vidUrl = vidUrl;
    }

    public int getCropCategoryObjectiveContentID() {
        return cropCategoryObjectiveContentID;
    }

    public void setCropCategoryObjectiveContentID(int cropCategoryObjectiveContentID) {
        this.cropCategoryObjectiveContentID = cropCategoryObjectiveContentID;
    }

    public CropCategoryObjective getCropCategoryObjective() {
        return cropCategoryObjective;
    }

    public void setCropCategoryObjective(CropCategoryObjective cropCategoryObjective) {
        this.cropCategoryObjective = cropCategoryObjective;
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
