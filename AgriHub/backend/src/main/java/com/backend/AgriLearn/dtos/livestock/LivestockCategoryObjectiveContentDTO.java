package com.backend.AgriLearn.dtos.livestock;

public class LivestockCategoryObjectiveContentDTO {

    private int livestockCategoryObjectiveID;
    private String title;
    private String content;
    private String picUrl;
    private String vidUrl;

    public int getLivestockCategoryObjectiveID() {
        return livestockCategoryObjectiveID;
    }

    public void setLivestockCategoryObjectiveID(int livestockCategoryObjectiveID) {
        this.livestockCategoryObjectiveID = livestockCategoryObjectiveID;
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
