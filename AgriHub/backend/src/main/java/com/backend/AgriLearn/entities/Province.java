package com.backend.AgriLearn.entities;

import com.backend.AgriLearn.enums.ProvinceEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "provinces")

public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProvinceID")
    private int provinceID;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private ProvinceEnum province;

    @Column(name = "description")
    private String description;

    @Column(name = "provincePic_url")
    private String provincePicUrl;

    public Province() {
    }

    public Province(int provinceID, ProvinceEnum province, String description, String provincePicUrl) {
        this.provinceID = provinceID;
        this.province = province;
        this.description = description;
        this.provincePicUrl = provincePicUrl;
    }

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

