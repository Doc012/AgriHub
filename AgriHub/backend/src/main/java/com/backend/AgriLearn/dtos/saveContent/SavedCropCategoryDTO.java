package com.backend.AgriLearn.dtos.saveContent;

public class SavedCropCategoryDTO {

    private int userID;
    private int cropCategoryID;
    private String picUrl;

    public SavedCropCategoryDTO() {
    }

    public SavedCropCategoryDTO(int userID, int cropCategoryID, String picUrl) {
        this.userID = userID;
        this.cropCategoryID = cropCategoryID;
        this.picUrl = picUrl;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getCropCategoryID() {
        return cropCategoryID;
    }

    public void setCropCategoryID(int cropCategoryID) {
        this.cropCategoryID = cropCategoryID;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
