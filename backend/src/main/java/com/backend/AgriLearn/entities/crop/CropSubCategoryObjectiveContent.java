package com.backend.AgriLearn.entities.crop;

import jakarta.persistence.*;

@Entity
@Table(name = "cropsubcategoryobjectivecontents")
public class CropSubCategoryObjectiveContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cropSubCategoryObjectiveContentID;

    @ManyToOne
    @JoinColumn(name = "cropSubCategoryObjectiveID", nullable = false)
    private CropSubCategoryObjective cropSubCategoryObjective;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String picUrl;
    private String vidUrl;

    public CropSubCategoryObjectiveContent() {
    }

    public CropSubCategoryObjectiveContent(Long cropSubCategoryObjectiveContentID, CropSubCategoryObjective cropSubCategoryObjective, String title, String content, String picUrl, String vidUrl) {
        this.cropSubCategoryObjectiveContentID = cropSubCategoryObjectiveContentID;
        this.cropSubCategoryObjective = cropSubCategoryObjective;
        this.title = title;
        this.content = content;
        this.picUrl = picUrl;
        this.vidUrl = vidUrl;
    }

    public Long getCropSubCategoryObjectiveContentID() {
        return cropSubCategoryObjectiveContentID;
    }

    public void setCropSubCategoryObjectiveContentID(Long cropSubCategoryObjectiveContentID) {
        this.cropSubCategoryObjectiveContentID = cropSubCategoryObjectiveContentID;
    }

    public CropSubCategoryObjective getCropSubCategoryObjective() {
        return cropSubCategoryObjective;
    }

    public void setCropSubCategoryObjective(CropSubCategoryObjective cropSubCategoryObjective) {
        this.cropSubCategoryObjective = cropSubCategoryObjective;
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
