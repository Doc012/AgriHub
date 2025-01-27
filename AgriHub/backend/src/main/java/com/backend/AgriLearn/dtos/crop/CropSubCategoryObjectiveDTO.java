package com.backend.AgriLearn.dtos.crop;

public class CropSubCategoryObjectiveDTO {

        private int cropSubCategoryID;
        private String title;
        private String description;
        private String picUrl;

    public int getCropSubCategoryID() {
        return cropSubCategoryID;
    }

    public void setCropSubCategoryID(int cropSubCategoryID) {
        this.cropSubCategoryID = cropSubCategoryID;
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
