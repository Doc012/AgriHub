package com.backend.AgriLearn.dtos.crop;

public class CropGroupDTO {
    private int cropCategoryID;
    private String title;
    private String description;
    private String picUrl;

    public int getCropCategoryID() {
        return cropCategoryID;
    }

    public void setCropCategoryID(int cropCategoryID) {
        this.cropCategoryID = cropCategoryID;
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
