package com.backend.AgriLearn.services.crop;

import com.backend.AgriLearn.dtos.crop.CropSubCategoryDTO;
import com.backend.AgriLearn.entities.crop.CropCategory;
import com.backend.AgriLearn.entities.crop.CropGroup;
import com.backend.AgriLearn.entities.crop.CropSubCategory;
import com.backend.AgriLearn.repositories.crop.CropCategoryRepository;
import com.backend.AgriLearn.repositories.crop.CropGroupRepository;
import com.backend.AgriLearn.repositories.crop.CropSubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CropSubCategoryService {

    @Autowired
    private CropSubCategoryRepository cropSubCategoryRepository;

    @Autowired
    private CropCategoryRepository cropCategoryRepository;

    @Autowired
    private CropGroupRepository cropGroupRepository;

    // Create a new crop sub-category
    public CropSubCategory createCropSubCategory(CropSubCategoryDTO cropSubCategoryDTO) {
        Optional<CropCategory> cropCategory = cropCategoryRepository.findById(cropSubCategoryDTO.getCropCategoryID());
        Optional<CropGroup> cropGroup = Optional.empty();

        if (cropSubCategoryDTO.getCropGroupID() != null) {
            cropGroup = cropGroupRepository.findById(cropSubCategoryDTO.getCropCategoryID());
        }

        if (cropCategory.isPresent()) {
            CropCategory category = cropCategory.get();
            if (!category.getHasSubCategories()) {
                throw new RuntimeException("The crop category '" + category.getTitle() + "' does not have sub-categories");
            }

            CropSubCategory cropSubCategory = new CropSubCategory();
            cropSubCategory.setTitle(cropSubCategoryDTO.getTitle());
            cropSubCategory.setPurpose(cropSubCategoryDTO.getPurpose());
            cropSubCategory.setCommonVarieties(cropSubCategoryDTO.getCommonVarieties());
            cropSubCategory.setMarket(cropSubCategoryDTO.getMarket());
            cropSubCategory.setPicUrl(cropSubCategoryDTO.getPicUrl());
            cropSubCategory.setCropCategory(category);

            cropGroup.ifPresent(cropSubCategory::setCropGroup);

            return cropSubCategoryRepository.save(cropSubCategory);
        } else {
            throw new RuntimeException("Crop category not found with ID " + cropSubCategoryDTO.getCropCategoryID());
        }
    }

    // Retrieve all crop sub-categories
    public List<CropSubCategory> getAllCropSubCategories() {
        return cropSubCategoryRepository.findAll();
    }

    // Retrieve crop sub-categories by crop category ID
    public List<CropSubCategory> getCropSubCategoriesByCropCategory(int cropCategoryID) {
        Optional<CropCategory> cropCategory = cropCategoryRepository.findById(cropCategoryID);
        if (cropCategory.isPresent()) {
            CropCategory category = cropCategory.get();
            if (!category.getHasSubCategories()) {
                throw new RuntimeException("The crop category '" + category.getTitle() + "' does not have sub-categories");
            }

            return cropSubCategoryRepository.findByCropCategory_CropCategoryID(cropCategoryID);
        } else {
            throw new RuntimeException("Crop category not found with ID " + cropCategoryID);
        }
    }

    // **New Method: Retrieve crop sub-categories by crop group ID**
    public List<CropSubCategory> getCropSubCategoriesByCropGroup(int cropGroupID) {
        Optional<CropGroup> cropGroup = cropGroupRepository.findById(cropGroupID);
        if (cropGroup.isPresent()) {
            return cropSubCategoryRepository.findByCropGroup_CropGroupID(cropGroupID);
        } else {
            throw new RuntimeException("Crop group not found with ID " + cropGroupID);
        }
    }

    // Retrieve a crop sub-category by ID
    public Optional<CropSubCategory> getCropSubCategoryByID(int cropSubCategoryID) {
        return cropSubCategoryRepository.findById(cropSubCategoryID);
    }

    // Update an existing crop sub-category
    public CropSubCategory updateCropSubCategory(int cropSubCategoryID, CropSubCategoryDTO cropSubCategoryDTO) {
        Optional<CropSubCategory> existingCropSubCategory = cropSubCategoryRepository.findById(cropSubCategoryID);
        Optional<CropCategory> cropCategory = cropCategoryRepository.findById(cropSubCategoryDTO.getCropCategoryID());
        Optional<CropGroup> cropGroup = Optional.empty();

        if (cropSubCategoryDTO.getCropGroupID() != null) {
            cropGroup = cropGroupRepository.findById(cropSubCategoryDTO.getCropGroupID());
        }

        if (existingCropSubCategory.isPresent() && cropCategory.isPresent()) {
            CropSubCategory cropSubCategory = existingCropSubCategory.get();
            CropCategory category = cropCategory.get();

            if (!category.getHasSubCategories()) {
                throw new RuntimeException("Crop category '" + category.getTitle() + "' does not allow sub-categories.");
            }

            cropSubCategory.setTitle(cropSubCategoryDTO.getTitle());
            cropSubCategory.setPurpose(cropSubCategoryDTO.getPurpose());
            cropSubCategory.setCommonVarieties(cropSubCategoryDTO.getCommonVarieties());
            cropSubCategory.setMarket(cropSubCategoryDTO.getMarket());
            cropSubCategory.setPicUrl(cropSubCategoryDTO.getPicUrl());
            cropSubCategory.setCropCategory(category);

            // Set crop group if provided
            cropGroup.ifPresent(cropSubCategory::setCropGroup);



            return cropSubCategoryRepository.save(cropSubCategory);
        } else {
            throw new RuntimeException("Crop sub-category, category, or group not found with given IDs.");
        }
    }

    // Delete a crop sub-category
    public void deleteCropSubCategory(int cropSubCategoryID) {
        if (cropSubCategoryRepository.existsById(cropSubCategoryID)) {
            cropSubCategoryRepository.deleteById(cropSubCategoryID);
        } else {
            throw new RuntimeException("Crop sub-category not found with ID " + cropSubCategoryID);
        }
    }

}
