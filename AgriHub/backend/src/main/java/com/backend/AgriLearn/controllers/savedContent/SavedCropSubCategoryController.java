package com.backend.AgriLearn.controllers.savedContent;


import com.backend.AgriLearn.dtos.saveContent.SavedCropSubCategoryDTO;
import com.backend.AgriLearn.entities.savedContent.SavedCropSubCategory;
import com.backend.AgriLearn.services.savedContent.SavedCropSubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/saved-crop-sub-categories")
public class SavedCropSubCategoryController {

    @Autowired
    private SavedCropSubCategoryService savedCropSubCategoryService;

    @PostMapping
    public ResponseEntity<SavedCropSubCategory> saveSavedCropSubCategory(@RequestBody SavedCropSubCategoryDTO dto) {
        SavedCropSubCategory saved = savedCropSubCategoryService.saveSavedCropSubCategory(dto);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<SavedCropSubCategory>> getAllSavedCropSubCategories() {
        return ResponseEntity.ok(savedCropSubCategoryService.getAllSavedCropSubCategories());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSavedCropSubCategory(@PathVariable int id) {
        savedCropSubCategoryService.deleteSavedCropSubCategory(id);
        return ResponseEntity.noContent().build();
    }
}

