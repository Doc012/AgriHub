package com.backend.AgriLearn.dtos.livestock;

public class LivestockSubCategoryDTO {

    private int livestockCategoryID;
    private Integer livestockGroupID; // New field added (nullable)
    private String title;
    private String purpose;
    private String commonVarieties;
    private String market;
    private String picUrl;

    public int getLivestockCategoryID() {
        return livestockCategoryID;
    }

    public void setLivestockCategoryID(int livestockCategoryID) {
        this.livestockCategoryID = livestockCategoryID;
    }

    public Integer getLivestockGroupID() {
        return livestockGroupID;
    }

    public void setLivestockGroupID(Integer livestockGroupID) {
        this.livestockGroupID = livestockGroupID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getCommonVarieties() {
        return commonVarieties;
    }

    public void setCommonVarieties(String commonVarieties) {
        this.commonVarieties = commonVarieties;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
