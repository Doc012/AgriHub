package com.backend.AgriLearn.controllers.savedContent.livestock;

import com.backend.AgriLearn.dtos.saveContent.livestock.SavedLivestockCategoryDTO;
import com.backend.AgriLearn.entities.savedContent.livestock.SavedLivestockCategory;
import com.backend.AgriLearn.repositories.savedContent.livestock.SavedLivestockCategoryRepository;
import com.backend.AgriLearn.services.savedContent.livestock.SavedLivestockCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/saved-livestock-categories")
public class SavedLivestockCategoryController {

    @Autowired
    private SavedLivestockCategoryService savedLivestockCategoryService;

    @PostMapping
    public ResponseEntity<SavedLivestockCategory> saveSavedLivestockCategory(@RequestBody SavedLivestockCategoryDTO dto) {
        SavedLivestockCategory saved = savedLivestockCategoryService.saveSavedLivestockCategory(dto);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<SavedLivestockCategory>> getAllSavedLivestockCategories() {
        return ResponseEntity.ok(savedLivestockCategoryService.getAllSavedLivestockCategories());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSavedLivestockCategory(@PathVariable int id) {
        savedLivestockCategoryService.deleteSavedLivestockCategory(id);
        return ResponseEntity.noContent().build();
    }











}
