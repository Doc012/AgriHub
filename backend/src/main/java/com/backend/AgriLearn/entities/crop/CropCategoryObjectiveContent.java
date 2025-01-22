package com.backend.AgriLearn.entities.crop;

import jakarta.persistence.*;

@Entity
@Table(name = "cropcategoryobjectivecontents")
public class CropCategoryObjectiveContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cropCategoryObjectiveContentID;

    @ManyToOne
    @JoinColumn(name = "cropCategoryObjectiveID", nullable = false)
    private CropCategoryObjective cropCategoryObjective;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String picUrl;
    private String vidUrl;

    public CropCategoryObjectiveContent() {
    }

    public CropCategoryObjectiveContent(Long cropCategoryObjectiveContentID, CropCategoryObjective cropCategoryObjective, String title, String content, String picUrl, String vidUrl) {
        this.cropCategoryObjectiveContentID = cropCategoryObjectiveContentID;
        this.cropCategoryObjective = cropCategoryObjective;
        this.title = title;
        this.content = content;
        this.picUrl = picUrl;
        this.vidUrl = vidUrl;
    }

    public Long getCropCategoryObjectiveContentID() {
        return cropCategoryObjectiveContentID;
    }

    public void setCropCategoryObjectiveContentID(Long cropCategoryObjectiveContentID) {
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
