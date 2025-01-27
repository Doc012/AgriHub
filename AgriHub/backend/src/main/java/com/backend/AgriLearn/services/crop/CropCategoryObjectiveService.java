package com.backend.AgriLearn.services.crop;

import com.backend.AgriLearn.dtos.crop.CropCategoryObjectiveDTO;
import com.backend.AgriLearn.entities.crop.CropCategory;
import com.backend.AgriLearn.entities.crop.CropCategoryObjective;
import com.backend.AgriLearn.repositories.crop.CropCategoryObjectiveRepository;
import com.backend.AgriLearn.repositories.crop.CropCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CropCategoryObjectiveService {

    @Autowired
    private CropCategoryObjectiveRepository cropCategoryObjectiveRepository;

    @Autowired
    private CropCategoryRepository cropCategoryRepository;

    // Create a new crop category objective
    public CropCategoryObjective createCropCategoryObjective(CropCategoryObjectiveDTO cropCategoryObjectiveDTO) {
        Optional<CropCategory> cropCategory = cropCategoryRepository.findById(cropCategoryObjectiveDTO.getCropCategoryID());
        if (cropCategory.isPresent()) {
            CropCategory category = cropCategory.get();

            if (category.getHasSubCategories()) {
                throw new RuntimeException("The crop category '" + category.getTitle() + "' has sub-categories, meaning it belongs to sub categories");
            }

            CropCategoryObjective cropCategoryObjective = new CropCategoryObjective();
            cropCategoryObjective.setTitle(cropCategoryObjectiveDTO.getTitle());
            cropCategoryObjective.setDescription(cropCategoryObjectiveDTO.getDescription());
            cropCategoryObjective.setPicUrl(cropCategoryObjectiveDTO.getPicUrl());
            cropCategoryObjective.setCropCategory(category);

            return cropCategoryObjectiveRepository.save(cropCategoryObjective);
        } else {
            throw new RuntimeException("Crop category not found with ID " + cropCategoryObjectiveDTO.getCropCategoryID());
        }
    }

    // Get all crop category objectives
    public List<CropCategoryObjective> getAllCropCategoryObjectives() {
        return cropCategoryObjectiveRepository.findAll();
    }

    // Get objectives by crop category ID
    public List<CropCategoryObjective> getCropCategoryObjectivesByCropCategory(int cropCategoryID) {
        Optional<CropCategory> cropCategory = cropCategoryRepository.findById(cropCategoryID);
        if (cropCategory.isPresent()) {
            CropCategory category = cropCategory.get();

            if (category.getHasSubCategories()) {
                throw new RuntimeException("The crop category '" + category.getTitle() + "' has sub-categories, meaning it belongs to sub categories");
            }
            return cropCategoryObjectiveRepository.findByCropCategory_CropCategoryID(cropCategoryID);

        } else {
            throw new RuntimeException("Crop category not found with ID " + cropCategoryID);
        }
    }

    // Get objective by ID
    public Optional<CropCategoryObjective> getCropCategoryObjectiveByID(int cropCategoryObjectiveID) {
        return cropCategoryObjectiveRepository.findById(cropCategoryObjectiveID);
    }

    // Update an existing crop category objective
    public CropCategoryObjective updateCropCategoryObjective(int cropCategoryObjectiveID, CropCategoryObjectiveDTO cropCategoryObjectiveDTO) {
        Optional<CropCategoryObjective> existingCropCategoryObjective = cropCategoryObjectiveRepository.findById(cropCategoryObjectiveID);
        if (existingCropCategoryObjective.isPresent()) {
            CropCategoryObjective cropCategoryObjective = existingCropCategoryObjective.get();

            Optional<CropCategory> cropCategory = cropCategoryRepository.findById(cropCategoryObjectiveDTO.getCropCategoryID());
            if (cropCategory.isPresent()) {
                CropCategory category = cropCategory.get();

                if (category.getHasSubCategories()) {
                    throw new RuntimeException("The crop category '" + category.getTitle() + "' has sub-categories, meaning it belongs to sub categories");
                }

                cropCategoryObjective.setTitle(cropCategoryObjectiveDTO.getTitle());
                cropCategoryObjective.setDescription(cropCategoryObjectiveDTO.getDescription());
                cropCategoryObjective.setPicUrl(cropCategoryObjectiveDTO.getPicUrl());
                cropCategoryObjective.setCropCategory(category);

                return cropCategoryObjectiveRepository.save(cropCategoryObjective);
            } else {
                throw new RuntimeException("Crop category not found with ID " + cropCategoryObjectiveDTO.getCropCategoryID());
            }
        } else {
            throw new RuntimeException("Crop category objective not found with ID " + cropCategoryObjectiveID);
        }
    }

    // Delete an objective
    public void deleteCropCategoryObjective(int cropCategoryObjectiveID) {
        if (cropCategoryObjectiveRepository.existsById(cropCategoryObjectiveID)) {
            cropCategoryObjectiveRepository.deleteById(cropCategoryObjectiveID);
        } else {
            throw new RuntimeException("Crop category objective not found with ID " + cropCategoryObjectiveID);
        }
    }
}
