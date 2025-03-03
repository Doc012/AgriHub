package com.backend.AgriLearn.controllers.livestock;

import com.backend.AgriLearn.dtos.livestock.LivestockCategoryDTO;
import com.backend.AgriLearn.entities.livestock.LivestockCategory;
import com.backend.AgriLearn.services.livestock.LivestockCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/livestock-categories")
public class LivestockCategoryController {

    @Autowired
    private LivestockCategoryService livestockCategoryService;

    // Create a new livestock category
    @PostMapping
    public ResponseEntity<LivestockCategory> createLivestockCategory(@RequestBody LivestockCategoryDTO livestockCategoryDTO) {
        LivestockCategory createdLivestockCategory = livestockCategoryService.createLivestockCategory(livestockCategoryDTO);
        return ResponseEntity.ok(createdLivestockCategory);
    }

    // Get all livestock categories
    @GetMapping
    public ResponseEntity<List<LivestockCategory>> getAllLivestockCategories() {
        List<LivestockCategory> livestockCategories = livestockCategoryService.getAllLivestockCategories();
        return ResponseEntity.ok(livestockCategories);
    }

    // Get livestock categories by district ID
    @GetMapping("/district/{districtID}")
    public ResponseEntity<List<LivestockCategory>> getLivestockCategoriesByDistrict(@PathVariable("districtID") int districtID) {
        List<LivestockCategory> livestockCategories = livestockCategoryService.getLivestockCategoriesByDistrict(districtID);
        return ResponseEntity.ok(livestockCategories);
    }

    // Get a livestock category by ID
    @GetMapping("/{id}")
    public ResponseEntity<LivestockCategory> getLivestockCategoryByID(@PathVariable("id") int id) {
        return livestockCategoryService.getLivestockCategoryByID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a livestock category
    @PutMapping("/{id}")
    public ResponseEntity<LivestockCategory> updateLivestockCategory(@PathVariable("id") int id, @RequestBody LivestockCategoryDTO livestockCategoryDTO) {
        try {
            LivestockCategory updatedLivestockCategory = livestockCategoryService.updateLivestockCategory(id, livestockCategoryDTO);
            return ResponseEntity.ok(updatedLivestockCategory);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a livestock category
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivestockCategory(@PathVariable("id") int id) {
        try {
            livestockCategoryService.deleteLivestockCategory(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

}
