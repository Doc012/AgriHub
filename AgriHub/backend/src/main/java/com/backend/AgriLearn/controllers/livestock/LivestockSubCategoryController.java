package com.backend.AgriLearn.controllers.livestock;

import com.backend.AgriLearn.dtos.livestock.LivestockSubCategoryDTO;
import com.backend.AgriLearn.entities.livestock.LivestockSubCategory;
import com.backend.AgriLearn.services.livestock.LivestockSubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/livestock-sub-categories")
public class LivestockSubCategoryController {

    @Autowired
    private LivestockSubCategoryService livestockSubCategoryService;

    // Create a new livestock sub-category
    @PostMapping
    public ResponseEntity<LivestockSubCategory> createLivestockSubCategory(@RequestBody LivestockSubCategoryDTO livestockSubCategoryDTO) {
        LivestockSubCategory createdLivestockSubCategory = livestockSubCategoryService.createLivestockSubCategory(livestockSubCategoryDTO);
        return ResponseEntity.ok(createdLivestockSubCategory);
    }

    // Get all livestock sub-categories
    @GetMapping
    public ResponseEntity<List<LivestockSubCategory>> getAllLivestockSubCategories() {
        List<LivestockSubCategory> livestockSubCategories = livestockSubCategoryService.getAllLivestockSubCategories();
        return ResponseEntity.ok(livestockSubCategories);
    }

    // Get livestock sub-categories by livestock category ID
    @GetMapping("/livestock-category/{livestockCategoryID}")
    public ResponseEntity<List<LivestockSubCategory>> getLivestockSubCategoriesByLivestockCategory(@PathVariable("livestockCategoryID") int livestockCategoryID) {
        List<LivestockSubCategory> livestockSubCategories = livestockSubCategoryService.getLivestockSubCategoriesByLivestockCategory(livestockCategoryID);
        return ResponseEntity.ok(livestockSubCategories);
    }

    // **New: Get livestock sub-categories by livestock group ID**
    @GetMapping("/group/{livestockGroupID}")
    public ResponseEntity<List<LivestockSubCategory>> getLivestockSubCategoriesByLivestockGroup(@PathVariable("livestockGroupID") int livestockGroupID) {
        List<LivestockSubCategory> livestockSubCategories = livestockSubCategoryService.getLivestockSubCategoriesByLivestockGroup(livestockGroupID);
        return ResponseEntity.ok(livestockSubCategories);
    }

    // Get a livestock sub-category by ID
    @GetMapping("/{id}")
    public ResponseEntity<LivestockSubCategory> getLivestockSubCategoryByID(@PathVariable("id") int id) {
        return livestockSubCategoryService.getLivestockSubCategoryByID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a livestock sub-category
    @PutMapping("/{id}")
    public ResponseEntity<LivestockSubCategory> updateLivestockSubCategory(@PathVariable("id") int id, @RequestBody LivestockSubCategoryDTO livestockSubCategoryDTO) {
        try {
            LivestockSubCategory updatedLivestockSubCategory = livestockSubCategoryService.updateLivestockSubCategory(id, livestockSubCategoryDTO);
            return ResponseEntity.ok(updatedLivestockSubCategory);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a livestock sub-category
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivestockSubCategory(@PathVariable("id") int id) {
        try {
            livestockSubCategoryService.deleteLivestockSubCategory(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
