package com.backend.AgriLearn.entities.livestock;

import jakarta.persistence.*;

@Entity
@Table(name = "livestocksubcategories")
public class LivestockSubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LivestockSubCategoryID")
    private int livestockSubCategoryID;

    @ManyToOne
    @JoinColumn(name = "LivestockCategoryID", nullable = false)
    private LivestockCategory livestockCategory;

    @ManyToOne
    @JoinColumn(name = "LivestockGroupID")
    private LivestockGroup livestockGroup;

    @Column(nullable = false, name = "Title", length = 100)
    private String title;

    @Column(nullable = false, name = "Purpose", columnDefinition = "TEXT")
    private String purpose;

    @Column(nullable = false, name = "CommonVarieties", columnDefinition = "TEXT")
    private String commonVarieties;

    @Column(nullable = false, name = "Market", columnDefinition = "TEXT")
    private String market;

    @Column(name = "Pic_url", length = 255)
    private String picUrl;

    public LivestockSubCategory() {
    }

    public LivestockSubCategory(int livestockSubCategoryID, LivestockCategory livestockCategory, LivestockGroup livestockGroup, String title, String purpose, String commonVarieties, String market, String picUrl) {
        this.livestockSubCategoryID = livestockSubCategoryID;
        this.livestockCategory = livestockCategory;
        this.livestockGroup = livestockGroup; // New field
        this.title = title;
        this.purpose = purpose;
        this.commonVarieties = commonVarieties;
        this.market = market;
        this.picUrl = picUrl;
    }

    public int getLivestockSubCategoryID() {
        return livestockSubCategoryID;
    }

    public void setLivestockSubCategoryID(int livestockSubCategoryID) {
        this.livestockSubCategoryID = livestockSubCategoryID;
    }

    public LivestockCategory getLivestockCategory() {
        return livestockCategory;
    }

    public void setLivestockCategory(LivestockCategory livestockCategory) {
        this.livestockCategory = livestockCategory;
    }

    public LivestockGroup getLivestockGroup() {
        return livestockGroup;
    }

    public void setLivestockGroup(LivestockGroup livestockGroup) {
        this.livestockGroup = livestockGroup;
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
