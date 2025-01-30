package com.backend.AgriLearn.controllers.savedContent.crop;

import com.backend.AgriLearn.dtos.saveContent.crop.SavedCropCategoryDTO;
import com.backend.AgriLearn.entities.savedContent.crop.SavedCropCategory;
import com.backend.AgriLearn.services.savedContent.crop.SavedCropCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/saved-crop-categories")
public class SavedCropCategoryController {

    @Autowired
    private SavedCropCategoryService savedCropCategoryService;


    @PostMapping
    public ResponseEntity<SavedCropCategory> saveSavedCropCategory(@RequestBody SavedCropCategoryDTO dto) {
        SavedCropCategory saved = savedCropCategoryService.saveSavedCropCategory(dto);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<SavedCropCategory>> getAllSavedCropCategories() {
        return ResponseEntity.ok(savedCropCategoryService.getAllSavedCropCategories());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSavedCropCategory(@PathVariable int id) {
        savedCropCategoryService.deleteSavedCropCategory(id);
        return ResponseEntity.noContent().build();
    }
}
