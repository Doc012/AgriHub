package com.backend.AgriLearn.dtos.crop;

public class CropSubCategoryDTO {

    private int cropCategoryID;
    private Integer cropGroupID;
    private String title;
    private String purpose;
    private String commonVarieties;
    private String market;
    private String picUrl;

    public int getCropCategoryID() {
        return cropCategoryID;
    }

    public void setCropCategoryID(int cropCategoryID) {
        this.cropCategoryID = cropCategoryID;
    }

    public Integer getCropGroupID() {
        return cropGroupID;
    }

    public void setCropGroupID(Integer cropGroupID) {
        this.cropGroupID = cropGroupID;
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
