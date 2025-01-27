package com.backend.AgriLearn.services.livestock;

import com.backend.AgriLearn.dtos.livestock.LivestockCategoryObjectiveDTO;
import com.backend.AgriLearn.entities.livestock.LivestockCategory;
import com.backend.AgriLearn.entities.livestock.LivestockCategoryObjective;
import com.backend.AgriLearn.repositories.livestock.LivestockCategoryObjectiveRepository;
import com.backend.AgriLearn.repositories.livestock.LivestockCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivestockCategoryObjectiveService {

    @Autowired
    private LivestockCategoryObjectiveRepository livestockCategoryObjectiveRepository;

    @Autowired
    private LivestockCategoryRepository livestockCategoryRepository;

    // Create a new livestock category objective
    public LivestockCategoryObjective createLivestockCategoryObjective(LivestockCategoryObjectiveDTO livestockCategoryObjectiveDTO) {
        Optional<LivestockCategory> livestockCategory = livestockCategoryRepository.findById(livestockCategoryObjectiveDTO.getLivestockCategoryID());
        if (livestockCategory.isPresent()) {
            LivestockCategory category = livestockCategory.get();

            if (category.getHasSubCategories()) {
                throw new RuntimeException("The livestock category '" + category.getTitle() + "' has sub-categories, meaning it belongs to sub categories");
            }

            LivestockCategoryObjective livestockCategoryObjective = new LivestockCategoryObjective();
            livestockCategoryObjective.setTitle(livestockCategoryObjectiveDTO.getTitle());
            livestockCategoryObjective.setDescription(livestockCategoryObjectiveDTO.getDescription());
            livestockCategoryObjective.setPicUrl(livestockCategoryObjectiveDTO.getPicUrl());
            livestockCategoryObjective.setLivestockCategory(category);

            return livestockCategoryObjectiveRepository.save(livestockCategoryObjective);
        } else {
            throw new RuntimeException("Livestock category not found with ID " + livestockCategoryObjectiveDTO.getLivestockCategoryID());
        }
    }

    // Get all livestock category objectives
    public List<LivestockCategoryObjective> getAllLivestockCategoryObjectives() {
        return livestockCategoryObjectiveRepository.findAll();
    }

    // Get objectives by livestock category ID
    public List<LivestockCategoryObjective> getLivestockCategoryObjectivesByLivestockCategory(int livestockCategoryID) {
        Optional<LivestockCategory> livestockCategory = livestockCategoryRepository.findById(livestockCategoryID);
        if (livestockCategory.isPresent()) {
            LivestockCategory category = livestockCategory.get();

            if (category.getHasSubCategories()) {
                throw new RuntimeException("The livestock category '" + category.getTitle() + "' has sub-categories, meaning it belongs to sub categories");
            }
            return livestockCategoryObjectiveRepository.findByLivestockCategory_LivestockCategoryID(livestockCategoryID);
        } else {
            throw new RuntimeException("Livestock category not found with ID " + livestockCategoryID);
        }
    }

    // Get objective by ID
    public Optional<LivestockCategoryObjective> getLivestockCategoryObjectiveByID(int livestockCategoryObjectiveID) {
        return livestockCategoryObjectiveRepository.findById(livestockCategoryObjectiveID);
    }

    // Update livestock category objective
    public LivestockCategoryObjective updateLivestockCategoryObjective(int livestockCategoryObjectiveID, LivestockCategoryObjectiveDTO livestockCategoryObjectiveDTO) {
        Optional<LivestockCategoryObjective> existingLivestockCategoryObjective = livestockCategoryObjectiveRepository.findById(livestockCategoryObjectiveID);
        if (existingLivestockCategoryObjective.isPresent()) {
            LivestockCategoryObjective livestockCategoryObjective = existingLivestockCategoryObjective.get();

            Optional<LivestockCategory> livestockCategory = livestockCategoryRepository.findById(livestockCategoryObjectiveDTO.getLivestockCategoryID());
            if (livestockCategory.isPresent()) {
                LivestockCategory category = livestockCategory.get();

                if (category.getHasSubCategories()) {
                    throw new RuntimeException("The livestock category '" + category.getTitle() + "' has sub-categories, meaning it belongs to sub categories");
                }

                livestockCategoryObjective.setTitle(livestockCategoryObjectiveDTO.getTitle());
                livestockCategoryObjective.setDescription(livestockCategoryObjectiveDTO.getDescription());
                livestockCategoryObjective.setPicUrl(livestockCategoryObjectiveDTO.getPicUrl());
                livestockCategoryObjective.setLivestockCategory(category);

                return livestockCategoryObjectiveRepository.save(livestockCategoryObjective);
            } else {
                throw new RuntimeException("Livestock category not found with ID " + livestockCategoryObjectiveDTO.getLivestockCategoryID());
            }
        } else {
            throw new RuntimeException("Livestock category objective not found with ID " + livestockCategoryObjectiveID);
        }
    }

    // Delete livestock category objective
    public void deleteLivestockCategoryObjective(int livestockCategoryObjectiveID) {
        if (livestockCategoryObjectiveRepository.existsById(livestockCategoryObjectiveID)) {
            livestockCategoryObjectiveRepository.deleteById(livestockCategoryObjectiveID);
        } else {
            throw new RuntimeException("Livestock category objective not found with ID " + livestockCategoryObjectiveID);
        }
    }








}
