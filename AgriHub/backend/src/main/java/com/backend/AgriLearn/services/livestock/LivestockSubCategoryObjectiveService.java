package com.backend.AgriLearn.services.livestock;


import com.backend.AgriLearn.dtos.livestock.LivestockSubCategoryObjectiveDTO;
import com.backend.AgriLearn.entities.livestock.LivestockSubCategory;
import com.backend.AgriLearn.entities.livestock.LivestockSubCategoryObjective;
import com.backend.AgriLearn.repositories.livestock.LivestockSubCategoryObjectiveRepository;
import com.backend.AgriLearn.repositories.livestock.LivestockSubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivestockSubCategoryObjectiveService {

    @Autowired
    private LivestockSubCategoryObjectiveRepository livestockSubCategoryObjectiveRepository;

    @Autowired
    private LivestockSubCategoryRepository livestockSubCategoryRepository;

    // Create a new objective for a livestock sub-category
    public LivestockSubCategoryObjective createLivestockSubCategoryObjective(LivestockSubCategoryObjectiveDTO livestockSubCategoryObjectiveDTO) {
        Optional<LivestockSubCategory> livestockSubCategory = livestockSubCategoryRepository.findById(livestockSubCategoryObjectiveDTO.getLivestockSubCategoryID());
        if (livestockSubCategory.isPresent()) {
            LivestockSubCategory category = livestockSubCategory.get();

            LivestockSubCategoryObjective livestockSubCategoryObjective = new LivestockSubCategoryObjective();
            livestockSubCategoryObjective.setTitle(livestockSubCategoryObjectiveDTO.getTitle());
            livestockSubCategoryObjective.setDescription(livestockSubCategoryObjectiveDTO.getDescription());
            livestockSubCategoryObjective.setPicUrl(livestockSubCategoryObjectiveDTO.getPicUrl());
            livestockSubCategoryObjective.setLivestockSubCategory(category);

            return livestockSubCategoryObjectiveRepository.save(livestockSubCategoryObjective);
        } else {
            throw new RuntimeException("Livestock sub-category not found with ID " + livestockSubCategoryObjectiveDTO.getLivestockSubCategoryID());
        }
    }

    // Retrieve all objectives for a livestock sub-category
    public List<LivestockSubCategoryObjective> getAllLivestockSubCategoryObjectives() {
        return livestockSubCategoryObjectiveRepository.findAll();
    }

    // Retrieve objectives by livestock sub-category ID
    public List<LivestockSubCategoryObjective> getLivestockSubCategoryObjectivesByLivestockSubCategory(int livestockSubCategoryID) {
        Optional<LivestockSubCategory> livestockSubCategory = livestockSubCategoryRepository.findById(livestockSubCategoryID);

        if (livestockSubCategory.isPresent()) {
            return livestockSubCategoryObjectiveRepository.findByLivestockSubCategory_LivestockSubCategoryID(livestockSubCategoryID);
        } else {
            throw new RuntimeException("Livestock sub-category not found with ID " + livestockSubCategoryID);
        }
    }

    // Retrieve an objective by ID
    public Optional<LivestockSubCategoryObjective> getLivestockSubCategoryObjectiveByID(int livestockSubCategoryObjectiveID) {
        return livestockSubCategoryObjectiveRepository.findById(livestockSubCategoryObjectiveID);
    }

    // Update an existing objective for a livestock sub-category
    public LivestockSubCategoryObjective updateLivestockSubCategoryObjective(int livestockSubCategoryObjectiveID, LivestockSubCategoryObjectiveDTO livestockSubCategoryObjectiveDTO) {
        Optional<LivestockSubCategoryObjective> existingLivestockSubCategoryObjective = livestockSubCategoryObjectiveRepository.findById(livestockSubCategoryObjectiveID);
        if (existingLivestockSubCategoryObjective.isPresent()) {
            LivestockSubCategoryObjective livestockSubCategoryObjective = existingLivestockSubCategoryObjective.get();

            Optional<LivestockSubCategory> livestockSubCategory = livestockSubCategoryRepository.findById(livestockSubCategoryObjectiveDTO.getLivestockSubCategoryID());
            if (livestockSubCategory.isPresent()) {
                livestockSubCategoryObjective.setTitle(livestockSubCategoryObjectiveDTO.getTitle());
                livestockSubCategoryObjective.setDescription(livestockSubCategoryObjectiveDTO.getDescription());
                livestockSubCategoryObjective.setPicUrl(livestockSubCategoryObjectiveDTO.getPicUrl());
                livestockSubCategoryObjective.setLivestockSubCategory(livestockSubCategory.get());

                return livestockSubCategoryObjectiveRepository.save(livestockSubCategoryObjective);
            } else {
                throw new RuntimeException("Livestock sub-category not found with ID " + livestockSubCategoryObjectiveDTO.getLivestockSubCategoryID());
            }
        } else {
            throw new RuntimeException("Livestock sub-category objective not found with ID " + livestockSubCategoryObjectiveID);
        }
    }

    // Delete an objective for a livestock sub-category
    public void deleteLivestockSubCategoryObjective(int livestockSubCategoryObjectiveID) {
        if (livestockSubCategoryObjectiveRepository.existsById(livestockSubCategoryObjectiveID)) {
            livestockSubCategoryObjectiveRepository.deleteById(livestockSubCategoryObjectiveID);
        } else {
            throw new RuntimeException("Livestock sub-category objective not found with ID " + livestockSubCategoryObjectiveID);
        }
    }
}
