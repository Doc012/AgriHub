package com.backend.AgriLearn.services.livestock;

import com.backend.AgriLearn.dtos.livestock.LivestockCategoryDTO;
import com.backend.AgriLearn.entities.District;
import com.backend.AgriLearn.entities.livestock.LivestockCategory;
import com.backend.AgriLearn.repositories.DistrictRepository;

import com.backend.AgriLearn.repositories.livestock.LivestockCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivestockCategoryService {

    @Autowired
    private LivestockCategoryRepository livestockCategoryRepository;

    @Autowired
    private DistrictRepository districtRepository;

    // Create a new livestock category
    public LivestockCategory createLivestockCategory(LivestockCategoryDTO livestockCategoryDTO) {
        Optional<District> district = districtRepository.findById(livestockCategoryDTO.getDistrictID());
        if (district.isPresent()) {
            LivestockCategory livestockCategory = new LivestockCategory();

            livestockCategory.setDistrict(district.get());
            livestockCategory.setTitle(livestockCategoryDTO.getTitle());
            livestockCategory.setDescription(livestockCategoryDTO.getDescription());
            livestockCategory.setPicUrl(livestockCategoryDTO.getPicUrl());
            livestockCategory.setHasSubCategories(livestockCategoryDTO.isHasSubCategories());


            return livestockCategoryRepository.save(livestockCategory);
        } else {
            throw new RuntimeException("District not found with ID " + livestockCategoryDTO.getDistrictID());
        }
    }

    // Retrieve all livestock categories
    public List<LivestockCategory> getAllLivestockCategories() {
        return livestockCategoryRepository.findAll();
    }

    // Retrieve livestock category by district
    public List<LivestockCategory> getLivestockCategoriesByDistrict(int districtID) {
        return livestockCategoryRepository.findByDistrict_DistrictID(districtID);
    }

    // Retrieve a livestock category by ID
    public Optional<LivestockCategory> getLivestockCategoryByID(int livestockCategoryID) {
        return livestockCategoryRepository.findById(livestockCategoryID);
    }

    // Update an existing livestock category
    public LivestockCategory updateLivestockCategory(int livestockCategoryID, LivestockCategoryDTO livestockCategoryDTO) {
        Optional<LivestockCategory> existingLivestockCategory = livestockCategoryRepository.findById(livestockCategoryID);
        if (existingLivestockCategory.isPresent()) {
            LivestockCategory livestockCategory = existingLivestockCategory.get();

            livestockCategory.setTitle(livestockCategoryDTO.getTitle());
            livestockCategory.setDescription(livestockCategoryDTO.getDescription());
            livestockCategory.setPicUrl(livestockCategoryDTO.getPicUrl());
            livestockCategory.setHasSubCategories(livestockCategoryDTO.isHasSubCategories());
            livestockCategory.setDistrict(districtRepository.findById(livestockCategoryDTO.getDistrictID()).get());

            return livestockCategoryRepository.save(livestockCategory);
        } else {
            throw new RuntimeException("Livestock category not found with ID " + livestockCategoryID);
        }
    }

    // Delete a livestock category
    public void deleteLivestockCategory(int livestockCategoryID) {
        if (livestockCategoryRepository.existsById(livestockCategoryID)) {
            livestockCategoryRepository.deleteById(livestockCategoryID);
        } else {
            throw new RuntimeException("Livestock category not found with ID " + livestockCategoryID);
        }
    }




}
