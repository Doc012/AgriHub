package com.backend.AgriLearn.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "districts")

public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int districtID;

    @ManyToOne
    @JoinColumn(name = "ProvinceID", nullable = false)
    private Province province;

    @Column(nullable = false, length = 100)
    private String district;

    @Column(name = "description")
    private String description;

    @Column(name = "districtPic_url")
    private String districtPicUrl;

    public District() {
    }

    public District(int districtID, Province province, String district, String description, String districtPicUrl) {
        this.districtID = districtID;
        this.province = province;
        this.district = district;
        this.description = description;
        this.districtPicUrl = districtPicUrl;
    }

    public int getDistrictID() {
        return districtID;
    }

    public void setDistrictID(int districtID) {
        this.districtID = districtID;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
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

