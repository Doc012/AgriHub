package com.backend.AgriLearn.dtos.livestock;

public class LivestockSubCategoryObjectiveContentDTO {

    private int livestockSubCategoryObjectiveID;
    private String title;
    private String content;
    private String picUrl;
    private String vidUrl;

    public int getLivestockSubCategoryObjectiveID() {
        return livestockSubCategoryObjectiveID;
    }

    public void setLivestockSubCategoryObjectiveID(int livestockSubCategoryObjectiveID) {
        this.livestockSubCategoryObjectiveID = livestockSubCategoryObjectiveID;
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
