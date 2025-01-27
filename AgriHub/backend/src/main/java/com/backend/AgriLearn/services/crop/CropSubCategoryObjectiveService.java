package com.backend.AgriLearn.services.crop;

import com.backend.AgriLearn.dtos.crop.CropSubCategoryObjectiveDTO;
import com.backend.AgriLearn.entities.crop.CropSubCategory;
import com.backend.AgriLearn.entities.crop.CropSubCategoryObjective;
import com.backend.AgriLearn.repositories.crop.CropSubCategoryObjectiveRepository;
import com.backend.AgriLearn.repositories.crop.CropSubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CropSubCategoryObjectiveService {

    @Autowired
    private CropSubCategoryObjectiveRepository cropSubCategoryObjectiveRepository;

    @Autowired
    private CropSubCategoryRepository cropSubCategoryRepository;

    // Create a new objective for a crop sub-category
    public CropSubCategoryObjective createCropSubCategoryObjective(CropSubCategoryObjectiveDTO cropSubCategoryObjectiveDTO) {
        Optional<CropSubCategory> cropSubCategory = cropSubCategoryRepository.findById(cropSubCategoryObjectiveDTO.getCropSubCategoryID());
        if (cropSubCategory.isPresent()) {
            CropSubCategory category = cropSubCategory.get();

            CropSubCategoryObjective cropSubCategoryObjective = new CropSubCategoryObjective();
            cropSubCategoryObjective.setTitle(cropSubCategoryObjectiveDTO.getTitle());
            cropSubCategoryObjective.setDescription(cropSubCategoryObjectiveDTO.getDescription());
            cropSubCategoryObjective.setPicUrl(cropSubCategoryObjectiveDTO.getPicUrl());
            cropSubCategoryObjective.setCropSubCategory(category);

            return cropSubCategoryObjectiveRepository.save(cropSubCategoryObjective);
        } else {
            throw new RuntimeException("Crop sub-category not found with ID " + cropSubCategoryObjectiveDTO.getCropSubCategoryID());
        }
    }

    // Retrieve all objectives for a crop sub-category
    public List<CropSubCategoryObjective> getAllCropSubCategoryObjectives() {
        return cropSubCategoryObjectiveRepository.findAll();
    }

    // Retrieve objectives by crop sub-category ID
    public List<CropSubCategoryObjective> getCropSubCategoryObjectivesByCropSubCategory(int cropSubCategoryID) {
        Optional<CropSubCategory> cropSubCategory = cropSubCategoryRepository.findById(cropSubCategoryID);

        if (cropSubCategory.isPresent()) {
            return cropSubCategoryObjectiveRepository.findByCropSubCategory_CropSubCategoryID(cropSubCategoryID);
        } else {
            throw new RuntimeException("Crop sub-category not found with ID " + cropSubCategoryID);
        }
    }

    // Retrieve an objective by ID
    public Optional<CropSubCategoryObjective> getCropSubCategoryObjectiveByID(int cropSubCategoryObjectiveID) {
        return cropSubCategoryObjectiveRepository.findById(cropSubCategoryObjectiveID);
    }

    // Update an existing objective for a crop sub-category
    public CropSubCategoryObjective updateCropSubCategoryObjective(int cropSubCategoryObjectiveID, CropSubCategoryObjectiveDTO cropSubCategoryObjectiveDTO) {
        Optional<CropSubCategoryObjective> existingCropSubCategoryObjective = cropSubCategoryObjectiveRepository.findById(cropSubCategoryObjectiveID);
        if (existingCropSubCategoryObjective.isPresent()) {
            CropSubCategoryObjective cropSubCategoryObjective = existingCropSubCategoryObjective.get();

            Optional<CropSubCategory> cropSubCategory = cropSubCategoryRepository.findById(cropSubCategoryObjectiveDTO.getCropSubCategoryID());
            if (cropSubCategory.isPresent()) {
                cropSubCategoryObjective.setTitle(cropSubCategoryObjectiveDTO.getTitle());
                cropSubCategoryObjective.setDescription(cropSubCategoryObjectiveDTO.getDescription());
                cropSubCategoryObjective.setPicUrl(cropSubCategoryObjectiveDTO.getPicUrl());
                cropSubCategoryObjective.setCropSubCategory(cropSubCategory.get());

                return cropSubCategoryObjectiveRepository.save(cropSubCategoryObjective);
            } else {
                throw new RuntimeException("Crop sub-category not found with ID " + cropSubCategoryObjectiveDTO.getCropSubCategoryID());
            }
        } else {
            throw new RuntimeException("Objective not found with ID " + cropSubCategoryObjectiveID);
        }
    }

    // Delete an objective for a crop sub-category
    public void deleteCropSubCategoryObjective(int cropSubCategoryObjectiveID) {
        if (cropSubCategoryObjectiveRepository.existsById(cropSubCategoryObjectiveID)) {
            cropSubCategoryObjectiveRepository.deleteById(cropSubCategoryObjectiveID);
        } else {
            throw new RuntimeException("Objective not found with ID " + cropSubCategoryObjectiveID);
        }
    }
}
