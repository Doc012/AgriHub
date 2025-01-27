package com.backend.AgriLearn.dtos.crop;

public class CropCategoryObjectiveContentDTO {

    private int cropCategoryObjectiveID;
    private String title;
    private String content;
    private String picUrl;
    private String vidUrl;

    public int getCropCategoryObjectiveID() {
        return cropCategoryObjectiveID;
    }

    public void setCropCategoryObjectiveID(int cropCategoryObjectiveID) {
        this.cropCategoryObjectiveID = cropCategoryObjectiveID;
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
