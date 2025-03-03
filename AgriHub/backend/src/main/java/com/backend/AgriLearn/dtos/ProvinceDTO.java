package com.backend.AgriLearn.dtos;


import com.backend.AgriLearn.enums.ProvinceEnum;

public class ProvinceDTO {
    private int provinceID;
    private ProvinceEnum province;
    private String description;
    private String provincePicUrl;

    public int getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(int provinceID) {
        this.provinceID = provinceID;
    }

    public ProvinceEnum getProvince() {
        return province;
    }

    public void setProvince(ProvinceEnum province) {
        this.province = province;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProvincePicUrl() {
        return provincePicUrl;
    }

    public void setProvincePicUrl(String provincePicUrl) {
        this.provincePicUrl = provincePicUrl;
    }
}
