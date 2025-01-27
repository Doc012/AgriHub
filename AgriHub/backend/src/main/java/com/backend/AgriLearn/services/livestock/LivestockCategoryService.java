package com.backend.AgriLearn.services.livestock;

import com.backend.AgriLearn.dtos.livestock.LivestockCategoryDTO;
import com.backend.AgriLearn.entities.Location;
import com.backend.AgriLearn.entities.livestock.LivestockCategory;
import com.backend.AgriLearn.repositories.LocationRepository;
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
    private LocationRepository locationRepository;

    // Create a new livestock category
    public LivestockCategory createLivestockCategory(LivestockCategoryDTO livestockCategoryDTO) {
        Optional<Location> location = locationRepository.findById(livestockCategoryDTO.getLocationID());
        if (location.isPresent()) {
            LivestockCategory livestockCategory = new LivestockCategory();

            livestockCategory.setLocation(location.get());
            livestockCategory.setTitle(livestockCategoryDTO.getTitle());
            livestockCategory.setDescription(livestockCategoryDTO.getDescription());
            livestockCategory.setPicUrl(livestockCategoryDTO.getPicUrl());
            livestockCategory.setHasSubCategories(livestockCategoryDTO.isHasSubCategories());


            return livestockCategoryRepository.save(livestockCategory);
        } else {
            throw new RuntimeException("Location not found with ID " + livestockCategoryDTO.getLocationID());
        }
    }

    // Retrieve all livestock categories
    public List<LivestockCategory> getAllLivestockCategories() {
        return livestockCategoryRepository.findAll();
    }

    // Retrieve livestock category by location
    public List<LivestockCategory> getLivestockCategoriesByLocation(int locationID) {
        return livestockCategoryRepository.findByLocation_LocationID(locationID);
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
            livestockCategory.setLocation(locationRepository.findById(livestockCategoryDTO.getLocationID()).get());

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
