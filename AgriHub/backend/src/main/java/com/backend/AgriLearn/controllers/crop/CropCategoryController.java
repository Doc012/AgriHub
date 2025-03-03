package com.backend.AgriLearn.controllers.crop;

import com.backend.AgriLearn.dtos.crop.CropCategoryDTO;
import com.backend.AgriLearn.entities.crop.CropCategory;
import com.backend.AgriLearn.services.crop.CropCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/crop-categories")
public class CropCategoryController {

    @Autowired
    private CropCategoryService cropCategoryService;

    // Create a new crop category
    @PostMapping
    public ResponseEntity<CropCategory> createCropCategory(@RequestBody CropCategoryDTO cropCategoryDTO) {
        CropCategory createdCropCategory = cropCategoryService.createCropCategory(cropCategoryDTO);
        return ResponseEntity.ok(createdCropCategory);
    }

    // Get all crop categories
    @GetMapping
    public ResponseEntity<List<CropCategory>> getAllCropCategories() {
        List<CropCategory> cropCategories = cropCategoryService.getAllCropCategories();
        return ResponseEntity.ok(cropCategories);
    }

    // Get crop categories by district ID
    @GetMapping("/district/{districtID}")
    public ResponseEntity<List<CropCategory>> getCropCategoriesByDistrict(@PathVariable("districtID") int districtID) {
        List<CropCategory> cropCategories = cropCategoryService.getCropCategoriesByDistrict(districtID);
        return ResponseEntity.ok(cropCategories);
    }

    // Get a crop category by ID
    @GetMapping("/{id}")
    public ResponseEntity<CropCategory> getCropCategoryByID(@PathVariable("id") int id) {
        return cropCategoryService.getCropCategoryByID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a crop category
    @PutMapping("/{id}")
    public ResponseEntity<CropCategory> updateCropCategory(@PathVariable("id") int id, @RequestBody CropCategoryDTO cropCategoryDTO) {
        try {
            CropCategory updatedCropCategory = cropCategoryService.updateCropCategory(id, cropCategoryDTO);
            return ResponseEntity.ok(updatedCropCategory);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a crop category
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCropCategory(@PathVariable("id") int id) {
        try {
            cropCategoryService.deleteCropCategory(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
