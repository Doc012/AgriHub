package com.backend.AgriLearn.dtos.livestock;

public class LivestockGroupDTO {
    private int livestockCategoryID;
    private String title;
    private String description;
    private String picUrl;

    public int getLivestockCategoryID() {
        return livestockCategoryID;
    }

    public void setLivestockCategoryID(int livestockCategoryID) {
        this.livestockCategoryID = livestockCategoryID;
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
