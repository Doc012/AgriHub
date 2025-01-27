package com.backend.AgriLearn.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LocationID")
    private int locationID;

    @Column(nullable = false, name = "Province")
    private String province;

    @Column(nullable = false, name = "District")
    private String district;

    @Column(name = "Pic_url")
    private String picUrl;

    public Location() {
    }

    public Location(int locationID, String province, String district, String picUrl) {
        this.locationID = locationID;
        this.province = province;
        this.district = district;
        this.picUrl = picUrl;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
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
