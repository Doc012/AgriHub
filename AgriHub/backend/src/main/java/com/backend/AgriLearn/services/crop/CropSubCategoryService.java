package com.backend.AgriLearn.services.crop;

import com.backend.AgriLearn.dtos.crop.CropSubCategoryDTO;
import com.backend.AgriLearn.entities.crop.CropCategory;
import com.backend.AgriLearn.entities.crop.CropSubCategory;
import com.backend.AgriLearn.repositories.crop.CropCategoryRepository;
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

    // Create a new crop sub-category
    public CropSubCategory createCropSubCategory(CropSubCategoryDTO cropSubCategoryDTO) {
        Optional<CropCategory> cropCategory = cropCategoryRepository.findById(cropSubCategoryDTO.getCropCategoryID());

        if (cropCategory.isPresent()) {
            CropCategory category = cropCategory.get();
            if (!category.getHasSubCategories()) {
                throw new RuntimeException("The crop category '" + category.getTitle() + "' does not have sub-categories");
            }

            CropSubCategory cropSubCategory = new CropSubCategory();
            cropSubCategory.setTitle(cropSubCategoryDTO.getTitle());
            cropSubCategory.setDescription(cropSubCategoryDTO.getDescription());
            cropSubCategory.setPicUrl(cropSubCategoryDTO.getPicUrl());
            cropSubCategory.setCropCategory(category);

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

    // Retrieve a crop sub-category by ID
    public Optional<CropSubCategory> getCropSubCategoryByID(int cropSubCategoryID) {
        return cropSubCategoryRepository.findById(cropSubCategoryID);
    }

    // Update an existing crop sub-category
    public CropSubCategory updateCropSubCategory(int cropSubCategoryID, CropSubCategoryDTO cropSubCategoryDTO) {
        Optional<CropSubCategory> existingCropSubCategory = cropSubCategoryRepository.findById(cropSubCategoryID);
        if (existingCropSubCategory.isPresent()) {
            CropSubCategory cropSubCategory = existingCropSubCategory.get();

            Optional<CropCategory> cropCategory = cropCategoryRepository.findById(cropSubCategoryDTO.getCropCategoryID());
            if (cropCategory.isPresent()) {
                CropCategory category = cropCategory.get();
                if (!category.getHasSubCategories()) {
                    throw new RuntimeException("The crop category '" + category.getTitle() + "' does not have sub-categories");
                }
            } else {
                throw new RuntimeException("Crop category not found with ID " + cropSubCategoryDTO.getCropCategoryID());
            }

            cropSubCategory.setTitle(cropSubCategoryDTO.getTitle());
            cropSubCategory.setDescription(cropSubCategoryDTO.getDescription());
            cropSubCategory.setPicUrl(cropSubCategoryDTO.getPicUrl());
            cropSubCategory.setCropCategory(cropCategoryRepository.findById(cropSubCategoryDTO.getCropCategoryID()).get());

            return cropSubCategoryRepository.save(cropSubCategory);
        } else {
            throw new RuntimeException("Crop sub-category not found with ID " + cropSubCategoryID);
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
