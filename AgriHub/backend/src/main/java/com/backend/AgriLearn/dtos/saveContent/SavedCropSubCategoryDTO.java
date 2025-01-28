package com.backend.AgriLearn.dtos.saveContent;

public class SavedCropSubCategoryDTO {

    private int userID;
    private int cropSubCategoryID;
    private String picUrl;

    public SavedCropSubCategoryDTO() {
    }

    public SavedCropSubCategoryDTO(int userID, int cropSubCategoryID, String picUrl) {
        this.userID = userID;
        this.cropSubCategoryID = cropSubCategoryID;
        this.picUrl = picUrl;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getCropSubCategoryID() {
        return cropSubCategoryID;
    }

    public void setCropSubCategoryID(int cropSubCategoryID) {
        this.cropSubCategoryID = cropSubCategoryID;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
