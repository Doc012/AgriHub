package com.backend.AgriLearn.dtos;

public class DistrictDTO {
    private int districtID;
    private int provinceID;
    private String district;
    private String description;
    private String districtPicUrl;

    public int getDistrictID() {
        return districtID;
    }

    public void setDistrictID(int districtID) {
        this.districtID = districtID;
    }

    public int getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(int provinceID) {
        this.provinceID = provinceID;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDistrictPicUrl() {
        return districtPicUrl;
    }

    public void setDistrictPicUrl(String districtPicUrl) {
        this.districtPicUrl = districtPicUrl;
    }
}
