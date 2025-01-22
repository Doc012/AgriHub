package com.backend.AgriLearn.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationID;

    @Column(nullable = false)
    private String province;

    @Column(nullable = false)
    private String district;

    private String picUrl;

    public Location() {
    }

    public Location(Long locationID, String province, String district, String picUrl) {
        this.locationID = locationID;
        this.province = province;
        this.district = district;
        this.picUrl = picUrl;
    }

    public Long getLocationID() {
        return locationID;
    }

    public void setLocationID(Long locationID) {
        this.locationID = locationID;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
