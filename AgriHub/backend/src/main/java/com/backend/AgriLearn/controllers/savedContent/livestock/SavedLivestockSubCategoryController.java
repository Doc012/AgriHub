package com.backend.AgriLearn.controllers.savedContent.livestock;

import com.backend.AgriLearn.dtos.saveContent.livestock.SavedLivestockSubCategoryDTO;
import com.backend.AgriLearn.entities.savedContent.livestock.SavedLivestockCategory;
import com.backend.AgriLearn.entities.savedContent.livestock.SavedLivestockSubCategory;
import com.backend.AgriLearn.services.savedContent.livestock.SavedLivestockSubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/saved-livestock-sub-categories")
public class SavedLivestockSubCategoryController {

    @Autowired
    private SavedLivestockSubCategoryService savedLivestockSubCategoryService;

    @PostMapping
    public ResponseEntity<SavedLivestockSubCategory> saveSavedLivestockSubCategory(@RequestBody SavedLivestockSubCategoryDTO dto) {
        SavedLivestockSubCategory saved = savedLivestockSubCategoryService.saveSavedLivestockSubCategory(dto);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<SavedLivestockSubCategory>> getAllSavedLivestockSubCategories() {
        return ResponseEntity.ok(savedLivestockSubCategoryService.getAllSavedLivestockSubCategories());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSavedLivestockSubCategory(@PathVariable int id) {
        savedLivestockSubCategoryService.deleteSavedLivestockSubCategory(id);
        return ResponseEntity.noContent().build();
    }








}
