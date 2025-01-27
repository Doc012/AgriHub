package com.backend.AgriLearn.dtos.livestock;

public class LivestockSubCategoryObjectiveDTO {

    private int livestockSubCategoryID;
    private String title;
    private String description;
    private String picUrl;

    public int getLivestockSubCategoryID() {
        return livestockSubCategoryID;
    }

    public void setLivestockSubCategoryID(int livestockSubCategoryID) {
        this.livestockSubCategoryID = livestockSubCategoryID;
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
