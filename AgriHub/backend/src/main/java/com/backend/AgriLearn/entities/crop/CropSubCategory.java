package com.backend.AgriLearn.entities.crop;

import com.backend.AgriLearn.entities.livestock.LivestockGroup;
import jakarta.persistence.*;

@Entity
@Table(name = "cropsubcategories")
public class CropSubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CropSubCategoryID")
    private int cropSubCategoryID;

    @ManyToOne
    @JoinColumn(name = "CropCategoryID", nullable = false)
    private CropCategory cropCategory;

    @ManyToOne
    @JoinColumn(name = "CropGroupID")
    private CropGroup cropGroup;

    @Column(nullable = false, name = "Title")
    private String title;

    @Column(nullable = false, name = "Purpose", columnDefinition = "TEXT")
    private String purpose;

    @Column(nullable = false, name = "CommonVarieties", columnDefinition = "TEXT")
    private String commonVarieties;

    @Column(nullable = false, name = "Market", columnDefinition = "TEXT")
    private String market;

    @Column(name = "Pic_url")
    private String picUrl;

    public CropSubCategory() {
    }

    public CropSubCategory(int cropSubCategoryID, CropCategory cropCategory, CropGroup cropGroup, String title, String purpose, String commonVarieties, String market, String picUrl) {
        this.cropSubCategoryID = cropSubCategoryID;
        this.cropCategory = cropCategory;
        this.cropGroup = cropGroup;
        this.title = title;
        this.purpose = purpose;
        this.commonVarieties = commonVarieties;
        this.market = market;
        this.picUrl = picUrl;
    }

    public int getCropSubCategoryID() {
        return cropSubCategoryID;
    }

    public void setCropSubCategoryID(int cropSubCategoryID) {
        this.cropSubCategoryID = cropSubCategoryID;
    }

    public CropCategory getCropCategory() {
        return cropCategory;
    }

    public void setCropCategory(CropCategory cropCategory) {
        this.cropCategory = cropCategory;
    }

    public CropGroup getCropGroup() {
        return cropGroup;
    }

    public void setCropGroup(CropGroup cropGroup) {
        this.cropGroup = cropGroup;
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
