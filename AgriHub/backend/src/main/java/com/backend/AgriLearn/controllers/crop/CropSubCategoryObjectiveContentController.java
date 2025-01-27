package com.backend.AgriLearn.controllers.crop;


import com.backend.AgriLearn.dtos.crop.CropSubCategoryObjectiveContentDTO;
import com.backend.AgriLearn.entities.crop.CropSubCategoryObjectiveContent;
import com.backend.AgriLearn.services.crop.CropSubCategoryObjectiveContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/crop-sub-category-objective-contents")
public class CropSubCategoryObjectiveContentController {

    @Autowired
    private CropSubCategoryObjectiveContentService cropSubCategoryObjectiveContentService;

    // Create a new content
    @PostMapping
    public ResponseEntity<CropSubCategoryObjectiveContent> createCropSubCategoryObjectiveContent(@RequestBody CropSubCategoryObjectiveContentDTO cropSubCategoryObjectiveContentDTO) {
        try {
            CropSubCategoryObjectiveContent createdCropSubCategoryObjectiveContent = cropSubCategoryObjectiveContentService.createCropSubCategoryObjectiveContent(cropSubCategoryObjectiveContentDTO);
            return ResponseEntity.ok(createdCropSubCategoryObjectiveContent);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Get all contents
    @GetMapping
    public ResponseEntity<List<CropSubCategoryObjectiveContent>> getAllCropSubCategoryObjectiveContents() {
        List<CropSubCategoryObjectiveContent> cropSubCategoryObjectiveContents = cropSubCategoryObjectiveContentService.getAllCropSubCategoryObjectiveContents();
        return ResponseEntity.ok(cropSubCategoryObjectiveContents);
    }

    // Get contents by objective ID
    @GetMapping("/crop-sub-category-objective/{cropSubCategoryObjectiveID}")
    public ResponseEntity<?> getCropSubCategoryObjectiveContentsByCropSubCategoryObjective(@PathVariable int cropSubCategoryObjectiveID) {
        try {
            List<CropSubCategoryObjectiveContent> cropSubCategoryObjectiveContents = cropSubCategoryObjectiveContentService.getCropSubCategoryObjectiveContentsByCropSubCategoryObjective(cropSubCategoryObjectiveID);
            return ResponseEntity.ok(cropSubCategoryObjectiveContents);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    // Get a content by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCropSubCategoryObjectiveContentByID(@PathVariable int id) {
        Optional<CropSubCategoryObjectiveContent> cropSubCategoryObjectiveContent = cropSubCategoryObjectiveContentService.getCropSubCategoryObjectiveContentByID(id);
        return cropSubCategoryObjectiveContent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a content
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCropSubCategoryObjectiveContent(@PathVariable int id, @RequestBody CropSubCategoryObjectiveContentDTO cropSubCategoryObjectiveContentDTO) {
        try {
            CropSubCategoryObjectiveContent updatedCropSubCategoryObjectiveContent = cropSubCategoryObjectiveContentService.updateCropSubCategoryObjectiveContent(id, cropSubCategoryObjectiveContentDTO);
            return ResponseEntity.ok(updatedCropSubCategoryObjectiveContent);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a content
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCropSubCategoryObjectiveContent(@PathVariable int id) {
        try {
            cropSubCategoryObjectiveContentService.deleteCropSubCategoryObjectiveContent(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

}
