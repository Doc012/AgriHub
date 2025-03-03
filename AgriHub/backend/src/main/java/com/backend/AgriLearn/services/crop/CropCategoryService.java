package com.backend.AgriLearn.services.crop;

import com.backend.AgriLearn.dtos.crop.CropCategoryDTO;
import com.backend.AgriLearn.entities.District;

import com.backend.AgriLearn.entities.crop.CropCategory;
import com.backend.AgriLearn.repositories.DistrictRepository;
import com.backend.AgriLearn.repositories.crop.CropCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CropCategoryService {

    @Autowired
    private CropCategoryRepository cropCategoryRepository;

    @Autowired
    private DistrictRepository districtRepository;

    // Create a new crop category
    public CropCategory createCropCategory(CropCategoryDTO cropCategoryDTO) {
        Optional<District> district = districtRepository.findById(cropCategoryDTO.getDistrictID());
        if (district.isPresent()) {
            CropCategory cropCategory = new CropCategory();

            cropCategory.setDistrict(district.get());
            cropCategory.setTitle(cropCategoryDTO.getTitle());
            cropCategory.setDescription(cropCategoryDTO.getDescription());
            cropCategory.setPicUrl(cropCategoryDTO.getPicUrl());
            cropCategory.setHasSubCategories(cropCategoryDTO.isHasSubCategories());

            return cropCategoryRepository.save(cropCategory);
        } else {
            throw new RuntimeException("District not found with ID " + cropCategoryDTO.getDistrictID());
        }
    }

    // Retrieve all crop categories
    public List<CropCategory> getAllCropCategories() {
        return cropCategoryRepository.findAll();
    }

    // Retrieve crop category by district
    public List<CropCategory> getCropCategoriesByDistrict(int districtID) {
        return cropCategoryRepository.findByDistrict_DistrictID(districtID);
    }

    // Retrieve a crop category by ID
    public Optional<CropCategory> getCropCategoryByID(int cropCategoryID) {
        return cropCategoryRepository.findById(cropCategoryID);
    }

    // Update an existing crop category
    public CropCategory updateCropCategory(int cropCategoryID, CropCategoryDTO cropCategoryDTO) {
        Optional<CropCategory> existingCropCategory = cropCategoryRepository.findById(cropCategoryID);
        if (existingCropCategory.isPresent()) {
            CropCategory cropCategory = existingCropCategory.get();
            cropCategory.setTitle(cropCategoryDTO.getTitle());
            cropCategory.setDescription(cropCategoryDTO.getDescription());
            cropCategory.setPicUrl(cropCategoryDTO.getPicUrl());
            cropCategory.setHasSubCategories(cropCategoryDTO.isHasSubCategories());
            cropCategory.setDistrict(districtRepository.findById(cropCategoryDTO.getDistrictID()).get());
            return cropCategoryRepository.save(cropCategory);
        } else {
            throw new RuntimeException("Crop category not found with ID " + cropCategoryID);
        }
    }

    // Delete a crop category
    public void deleteCropCategory(int cropCategoryID) {
        if (cropCategoryRepository.existsById(cropCategoryID)) {
            cropCategoryRepository.deleteById(cropCategoryID);
        } else {
            throw new RuntimeException("Crop category not found with ID " + cropCategoryID);
        }
    }



}
