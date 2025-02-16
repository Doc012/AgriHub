package com.backend.AgriLearn.services.livestock;

import com.backend.AgriLearn.dtos.livestock.LivestockSubCategoryDTO;
import com.backend.AgriLearn.entities.livestock.LivestockCategory;
import com.backend.AgriLearn.entities.livestock.LivestockGroup;
import com.backend.AgriLearn.entities.livestock.LivestockSubCategory;
import com.backend.AgriLearn.repositories.livestock.LivestockCategoryRepository;
import com.backend.AgriLearn.repositories.livestock.LivestockGroupRepository;
import com.backend.AgriLearn.repositories.livestock.LivestockSubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivestockSubCategoryService {

    @Autowired
    private LivestockSubCategoryRepository livestockSubCategoryRepository;

    @Autowired
    private LivestockCategoryRepository livestockCategoryRepository;

    @Autowired
    private LivestockGroupRepository livestockGroupRepository; // New repository for LivestockGroup

    // Create a new livestock sub-category
    public LivestockSubCategory createLivestockSubCategory(LivestockSubCategoryDTO livestockSubCategoryDTO) {
        Optional<LivestockCategory> livestockCategory = livestockCategoryRepository.findById(livestockSubCategoryDTO.getLivestockCategoryID());
        Optional<LivestockGroup> livestockGroup = Optional.empty();

        if (livestockSubCategoryDTO.getLivestockGroupID() != null) {
            livestockGroup = livestockGroupRepository.findById(livestockSubCategoryDTO.getLivestockGroupID());
        }

        if (livestockCategory.isPresent()) {
            LivestockCategory category = livestockCategory.get();

            if (!category.getHasSubCategories()) {
                throw new RuntimeException("Livestock category '" + category.getTitle() + "' does not allow sub-categories.");
            }

            LivestockSubCategory livestockSubCategory = new LivestockSubCategory();
            livestockSubCategory.setTitle(livestockSubCategoryDTO.getTitle());
            livestockSubCategory.setPurpose(livestockSubCategoryDTO.getPurpose());
            livestockSubCategory.setCommonVarieties(livestockSubCategoryDTO.getCommonVarieties());
            livestockSubCategory.setMarket(livestockSubCategoryDTO.getMarket());
            livestockSubCategory.setPicUrl(livestockSubCategoryDTO.getPicUrl());
            livestockSubCategory.setLivestockCategory(category);

            // Set livestock group if provided
            livestockGroup.ifPresent(livestockSubCategory::setLivestockGroup);

            return livestockSubCategoryRepository.save(livestockSubCategory);
        } else {
            throw new RuntimeException("Livestock category not found with ID: " + livestockSubCategoryDTO.getLivestockCategoryID());
        }
    }

    // Retrieve all livestock sub-categories
    public List<LivestockSubCategory> getAllLivestockSubCategories() {
        return livestockSubCategoryRepository.findAll();
    }

    // Retrieve livestock sub-categories by livestock category ID
    public List<LivestockSubCategory> getLivestockSubCategoriesByLivestockCategory(int livestockCategoryID) {
        Optional<LivestockCategory> livestockCategory = livestockCategoryRepository.findById(livestockCategoryID);
        if (livestockCategory.isPresent()) {
            LivestockCategory category = livestockCategory.get();

            if (!category.getHasSubCategories()) {
                throw new RuntimeException("Livestock category '" + category.getTitle() + "' does not allow sub-categories.");
            }

            return livestockSubCategoryRepository.findByLivestockCategory_LivestockCategoryID(livestockCategoryID);
        } else {
            throw new RuntimeException("Livestock category not found with ID " + livestockCategoryID);
        }
    }

    // **New Method: Retrieve livestock sub-categories by livestock group ID**
    public List<LivestockSubCategory> getLivestockSubCategoriesByLivestockGroup(int livestockGroupID) {
        Optional<LivestockGroup> livestockGroup = livestockGroupRepository.findById(livestockGroupID);
        if (livestockGroup.isPresent()) {
            return livestockSubCategoryRepository.findByLivestockGroup_LivestockGroupID(livestockGroupID);
        } else {
            throw new RuntimeException("Livestock group not found with ID " + livestockGroupID);
        }
    }

    // Retrieve a livestock sub-category by ID
    public Optional<LivestockSubCategory> getLivestockSubCategoryByID(int livestockSubCategoryID) {
        return livestockSubCategoryRepository.findById(livestockSubCategoryID);
    }

    // Update an existing livestock sub-category
    public LivestockSubCategory updateLivestockSubCategory(int livestockSubCategoryID, LivestockSubCategoryDTO livestockSubCategoryDTO) {
        Optional<LivestockSubCategory> existingLivestockSubCategory = livestockSubCategoryRepository.findById(livestockSubCategoryID);
        Optional<LivestockCategory> livestockCategory = livestockCategoryRepository.findById(livestockSubCategoryDTO.getLivestockCategoryID());
        Optional<LivestockGroup> livestockGroup = Optional.empty();

        if (livestockSubCategoryDTO.getLivestockGroupID() != null) {
            livestockGroup = livestockGroupRepository.findById(livestockSubCategoryDTO.getLivestockGroupID());
        }

        if (existingLivestockSubCategory.isPresent() && livestockCategory.isPresent()) {
            LivestockSubCategory livestockSubCategory = existingLivestockSubCategory.get();
            LivestockCategory category = livestockCategory.get();

            if (!category.getHasSubCategories()) {
                throw new RuntimeException("Livestock category '" + category.getTitle() + "' does not allow sub-categories.");
            }

            livestockSubCategory.setTitle(livestockSubCategoryDTO.getTitle());
            livestockSubCategory.setPurpose(livestockSubCategoryDTO.getPurpose());
            livestockSubCategory.setCommonVarieties(livestockSubCategoryDTO.getCommonVarieties());
            livestockSubCategory.setMarket(livestockSubCategoryDTO.getMarket());
            livestockSubCategory.setPicUrl(livestockSubCategoryDTO.getPicUrl());
            livestockSubCategory.setLivestockCategory(category);

            // Set livestock group if provided
            livestockGroup.ifPresent(livestockSubCategory::setLivestockGroup);



            return livestockSubCategoryRepository.save(livestockSubCategory);
        } else {
            throw new RuntimeException("Livestock sub-category, category, or group not found with given IDs.");
        }
    }

    // Delete a livestock sub-category
    public void deleteLivestockSubCategory(int livestockSubCategoryID) {
        if (livestockSubCategoryRepository.existsById(livestockSubCategoryID)) {
            livestockSubCategoryRepository.deleteById(livestockSubCategoryID);
        } else {
            throw new RuntimeException("Livestock sub-category not found with ID " + livestockSubCategoryID);
        }
    }
}
