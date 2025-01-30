package com.backend.AgriLearn.dtos.saveContent.livestock;

public class SavedLivestockCategoryDTO {

     private int userID;
     private int livestockCategoryID;
     private String picUrl;

    public SavedLivestockCategoryDTO() {
    }

    public SavedLivestockCategoryDTO(int userID, int livestockCategoryID, String picUrl) {
        this.userID = userID;
        this.livestockCategoryID = livestockCategoryID;
        this.picUrl = picUrl;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getLivestockCategoryID() {
        return livestockCategoryID;
    }

    public void setLivestockCategoryID(int livestockCategoryID) {
        this.livestockCategoryID = livestockCategoryID;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
