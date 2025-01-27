package com.backend.AgriLearn.services.livestock;

import com.backend.AgriLearn.dtos.livestock.LivestockSubCategoryDTO;
import com.backend.AgriLearn.entities.livestock.LivestockCategory;
import com.backend.AgriLearn.entities.livestock.LivestockSubCategory;
import com.backend.AgriLearn.repositories.livestock.LivestockCategoryRepository;
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

    // Create a new livestock sub-category
    public LivestockSubCategory createLivestockSubCategory(LivestockSubCategoryDTO livestockSubCategoryDTO) {
        Optional<LivestockCategory> livestockCategory = livestockCategoryRepository.findById(livestockSubCategoryDTO.getLivestockCategoryID());
        if (livestockCategory.isPresent()) {
            LivestockCategory category = livestockCategory.get();

            if (!category.getHasSubCategories()) {
                throw new RuntimeException("Livestock category with ID '" + category.getTitle() + "' does not have sub-categories");
            }

            LivestockSubCategory livestockSubCategory = new LivestockSubCategory();
            livestockSubCategory.setTitle(livestockSubCategoryDTO.getTitle());
            livestockSubCategory.setDescription(livestockSubCategoryDTO.getDescription());
            livestockSubCategory.setPicUrl(livestockSubCategoryDTO.getPicUrl());
            livestockSubCategory.setLivestockCategory(category);

            return livestockSubCategoryRepository.save(livestockSubCategory);
        } else {
            throw new RuntimeException("Livestock category not found with ID " + livestockSubCategoryDTO.getLivestockCategoryID());
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
                throw new RuntimeException("Livestock category with ID '" + category.getTitle() + "' does not have sub-categories");
            }

            return livestockSubCategoryRepository.findByLivestockCategory_LivestockCategoryID(livestockCategoryID);
        } else {
            throw new RuntimeException("Livestock category not found with ID " + livestockCategoryID);
        }
    }

    // Retrieve a livestock sub-category by ID
    public Optional<LivestockSubCategory> getLivestockSubCategoryByID(int livestockSubCategoryID) {
        return livestockSubCategoryRepository.findById(livestockSubCategoryID);
    }

    // Update an existing livestock sub-category
    public LivestockSubCategory updateLivestockSubCategory(int livestockSubCategoryID, LivestockSubCategoryDTO livestockSubCategoryDTO) {
        Optional<LivestockSubCategory> existingLivestockSubCategory = livestockSubCategoryRepository.findById(livestockSubCategoryID);
        if (existingLivestockSubCategory.isPresent()) {
            LivestockSubCategory livestockSubCategory = existingLivestockSubCategory.get();

            Optional<LivestockCategory> livestockCategory = livestockCategoryRepository.findById(livestockSubCategoryDTO.getLivestockCategoryID());
            if (livestockCategory.isPresent()) {
                LivestockCategory category = livestockCategory.get();

                if (!category.getHasSubCategories()) {
                    throw new RuntimeException("Livestock category with ID '" + category.getTitle() + "' does not have sub-categories");
                }

                livestockSubCategory.setTitle(livestockSubCategoryDTO.getTitle());
                livestockSubCategory.setDescription(livestockSubCategoryDTO.getDescription());
                livestockSubCategory.setPicUrl(livestockSubCategoryDTO.getPicUrl());
                livestockSubCategory.setLivestockCategory(category);

                return livestockSubCategoryRepository.save(livestockSubCategory);
            } else {
                throw new RuntimeException("Livestock category not found with ID " + livestockSubCategoryDTO.getLivestockCategoryID());
            }
        } else {
            throw new RuntimeException("Livestock sub-category not found with ID " + livestockSubCategoryID);
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
