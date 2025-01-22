package com.backend.AgriLearn.services;

import com.backend.AgriLearn.entities.crop.CropCategory;
import com.backend.AgriLearn.entities.crop.CropCategoryObjective;
import com.backend.AgriLearn.entities.crop.CropCategoryObjectiveContent;
import com.backend.AgriLearn.entities.crop.CropSubCategory;
import com.backend.AgriLearn.entities.livestock.LivestockCategory;
import com.backend.AgriLearn.entities.livestock.LivestockCategoryObjective;
import com.backend.AgriLearn.entities.livestock.LivestockCategoryObjectiveContent;
import com.backend.AgriLearn.entities.livestock.LivestockSubCategory;

import java.util.List;

public interface AdminService {
    // Crop Category Methods
    CropCategory createCropCategory(CropCategory cropCategory);
    List<CropCategory> getAllCropCategories();
    CropCategory updateCropCategory(CropCategory cropCategory);
    void deleteCropCategory(Long categoryId);

    // Crop SubCategory Methods
    CropSubCategory createCropSubCategory(CropSubCategory cropSubCategory);
    List<CropSubCategory> getAllCropSubCategories();
    CropSubCategory updateCropSubCategory(CropSubCategory cropSubCategory);
    void deleteCropSubCategory(Long subCategoryId);

    // Crop Objective Methods
    CropCategoryObjective createCropCategoryObjective(CropCategoryObjective cropCategoryObjective);
    List<CropCategoryObjective> getAllCropCategoryObjectives();
    CropCategoryObjective updateCropCategoryObjective(CropCategoryObjective cropCategoryObjective);
    void deleteCropCategoryObjective(Long objectiveId);

    // Crop Content Methods
    CropCategoryObjectiveContent createCropCategoryObjectiveContent(CropCategoryObjectiveContent content);
    List<CropCategoryObjectiveContent> getAllCropCategoryObjectiveContents();
    CropCategoryObjectiveContent updateCropCategoryObjectiveContent(CropCategoryObjectiveContent content);
    void deleteCropCategoryObjectiveContent(Long contentId);

    // Livestock Category Methods
    LivestockCategory createLivestockCategory(LivestockCategory livestockCategory);
    List<LivestockCategory> getAllLivestockCategories();
    LivestockCategory updateLivestockCategory(LivestockCategory livestockCategory);
    void deleteLivestockCategory(Long categoryId);

    // Livestock SubCategory Methods
    LivestockSubCategory createLivestockSubCategory(LivestockSubCategory livestockSubCategory);
    List<LivestockSubCategory> getAllLivestockSubCategories();
    LivestockSubCategory updateLivestockSubCategory(LivestockSubCategory livestockSubCategory);
    void deleteLivestockSubCategory(Long subCategoryId);

    // Livestock Objective Methods
    LivestockCategoryObjective createLivestockCategoryObjective(LivestockCategoryObjective livestockCategoryObjective);
    List<LivestockCategoryObjective> getAllLivestockCategoryObjectives();
    LivestockCategoryObjective updateLivestockCategoryObjective(LivestockCategoryObjective livestockCategoryObjective);
    void deleteLivestockCategoryObjective(Long objectiveId);

    // Livestock Content Methods
    LivestockCategoryObjectiveContent createLivestockCategoryObjectiveContent(LivestockCategoryObjectiveContent content);
    List<LivestockCategoryObjectiveContent> getAllLivestockCategoryObjectiveContents();
    LivestockCategoryObjectiveContent updateLivestockCategoryObjectiveContent(LivestockCategoryObjectiveContent content);
    void deleteLivestockCategoryObjectiveContent(Long contentId);
}

