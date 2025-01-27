package com.backend.AgriLearn.services.crop;

import com.backend.AgriLearn.dtos.crop.CropCategoryDTO;
import com.backend.AgriLearn.entities.Location;
import com.backend.AgriLearn.entities.crop.CropCategory;
import com.backend.AgriLearn.repositories.LocationRepository;
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
    private LocationRepository locationRepository;

    // Create a new crop category
    public CropCategory createCropCategory(CropCategoryDTO cropCategoryDTO) {
        Optional<Location> location = locationRepository.findById(cropCategoryDTO.getLocationID());
        if (location.isPresent()) {
            CropCategory cropCategory = new CropCategory();

            cropCategory.setLocation(location.get());
            cropCategory.setTitle(cropCategoryDTO.getTitle());
            cropCategory.setDescription(cropCategoryDTO.getDescription());
            cropCategory.setPicUrl(cropCategoryDTO.getPicUrl());
            cropCategory.setHasSubCategories(cropCategoryDTO.isHasSubCategories());

            return cropCategoryRepository.save(cropCategory);
        } else {
            throw new RuntimeException("Location not found with ID " + cropCategoryDTO.getLocationID());
        }
    }

    // Retrieve all crop categories
    public List<CropCategory> getAllCropCategories() {
        return cropCategoryRepository.findAll();
    }

    // Retrieve crop category by location
    public List<CropCategory> getCropCategoriesByLocation(int locationID) {
        return cropCategoryRepository.findByLocation_LocationID(locationID);
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
            cropCategory.setLocation(locationRepository.findById(cropCategoryDTO.getLocationID()).get());
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
