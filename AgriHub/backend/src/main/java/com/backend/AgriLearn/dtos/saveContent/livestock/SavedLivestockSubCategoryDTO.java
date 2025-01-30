package com.backend.AgriLearn.dtos.saveContent.livestock;

public class SavedLivestockSubCategoryDTO {

    private int userID;
    private int livestockSubCategoryID;
    private String picUrl;

    public SavedLivestockSubCategoryDTO() {
    }

    public SavedLivestockSubCategoryDTO(int userID, int livestockSubCategoryID, String picUrl) {
        this.userID = userID;
        this.livestockSubCategoryID = livestockSubCategoryID;
        this.picUrl = picUrl;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getLivestockSubCategoryID() {
        return livestockSubCategoryID;
    }

    public void setLivestockSubCategoryID(int livestockSubCategoryID) {
        this.livestockSubCategoryID = livestockSubCategoryID;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
