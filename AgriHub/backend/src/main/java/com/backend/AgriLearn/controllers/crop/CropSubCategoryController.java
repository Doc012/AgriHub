package com.backend.AgriLearn.controllers.crop;

import com.backend.AgriLearn.dtos.crop.CropSubCategoryDTO;
import com.backend.AgriLearn.entities.crop.CropSubCategory;
import com.backend.AgriLearn.services.crop.CropSubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/crop-sub-categories")
public class CropSubCategoryController {

    @Autowired
    private CropSubCategoryService cropSubCategoryService;

    // Create a new crop sub-category
    @PostMapping
    public ResponseEntity<CropSubCategory> createCropSubCategory(@RequestBody CropSubCategoryDTO cropSubCategoryDTO) {
        CropSubCategory createdCropSubCategory = cropSubCategoryService.createCropSubCategory(cropSubCategoryDTO);
        return ResponseEntity.ok(createdCropSubCategory);
    }

    // Get all crop sub-categories
    @GetMapping
    public ResponseEntity<List<CropSubCategory>> getAllCropSubCategories() {
        List<CropSubCategory> cropSubCategories = cropSubCategoryService.getAllCropSubCategories();
        return ResponseEntity.ok(cropSubCategories);
    }

    // Get crop sub-categories by crop category ID
    @GetMapping("/crop-category/{cropCategoryID}")
    public ResponseEntity<List<CropSubCategory>> getCropSubCategoriesByCropCategory(@PathVariable("cropCategoryID") int cropCategoryID) {
        List<CropSubCategory> cropSubCategories = cropSubCategoryService.getCropSubCategoriesByCropCategory(cropCategoryID);
        return ResponseEntity.ok(cropSubCategories);
    }

    // **New: Get crop sub-categories by crop group ID**
    @GetMapping("/group/{cropGroupID}")
    public ResponseEntity<List<CropSubCategory>> getCropSubCategoriesByCropGroup(@PathVariable("cropGroupID") int cropGroupID) {
        List<CropSubCategory> cropSubCategories = cropSubCategoryService.getCropSubCategoriesByCropGroup(cropGroupID);
        return ResponseEntity.ok(cropSubCategories);
    }

    // Get a crop sub-category by ID
    @GetMapping("/{id}")
    public ResponseEntity<CropSubCategory> getCropSubCategoryByID(@PathVariable("id") int id) {
        return cropSubCategoryService.getCropSubCategoryByID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a crop sub-category
    @PutMapping("/{id}")
    public ResponseEntity<CropSubCategory> updateCropSubCategory(@PathVariable("id") int id, @RequestBody CropSubCategoryDTO cropSubCategoryDTO) {
        try {
            CropSubCategory updatedCropSubCategory = cropSubCategoryService.updateCropSubCategory(id, cropSubCategoryDTO);
            return ResponseEntity.ok(updatedCropSubCategory);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a crop sub-category
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCropSubCategory(@PathVariable("id") int id) {
        try {
            cropSubCategoryService.deleteCropSubCategory(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
