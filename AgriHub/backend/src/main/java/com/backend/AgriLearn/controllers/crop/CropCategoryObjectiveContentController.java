package com.backend.AgriLearn.controllers.crop;

import com.backend.AgriLearn.dtos.crop.CropCategoryObjectiveContentDTO;
import com.backend.AgriLearn.entities.crop.CropCategoryObjectiveContent;
import com.backend.AgriLearn.services.crop.CropCategoryObjectiveContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/crop-category-objective-contents")
public class CropCategoryObjectiveContentController {

    @Autowired
    private CropCategoryObjectiveContentService cropCategoryObjectiveContentService;

    // Create a new content
    @PostMapping
    public ResponseEntity<CropCategoryObjectiveContent> createCropCategoryObjectiveContent(@RequestBody CropCategoryObjectiveContentDTO cropCategoryObjectiveContentDTO) {
        return ResponseEntity.ok(cropCategoryObjectiveContentService.createCropCategoryObjectiveContent(cropCategoryObjectiveContentDTO));
    }

    // Get all contents
    @GetMapping
    public ResponseEntity<List<CropCategoryObjectiveContent>> getAllCropCategoryObjectiveContents() {
        return ResponseEntity.ok(cropCategoryObjectiveContentService.getAllCropCategoryObjectiveContents());
    }

    // Get contents by objective ID
    @GetMapping("/crop-category-objective/{cropCategoryObjectiveID}")
    public ResponseEntity<List<CropCategoryObjectiveContent>> getCropCategoryObjectiveContentsByCropCategoryObjective(@PathVariable int cropCategoryObjectiveID) {
        return ResponseEntity.ok(cropCategoryObjectiveContentService.getCropCategoryObjectiveContentsByCropCategoryObjective(cropCategoryObjectiveID));
    }

    // Get a content by ID
    @GetMapping("/{id}")
    public ResponseEntity<CropCategoryObjectiveContent> getCropCategoryObjectiveContentByID(@PathVariable int id) {
        return cropCategoryObjectiveContentService.getCropCategoryObjectiveContentByID(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a content
    @PutMapping("/{id}")
    public ResponseEntity<CropCategoryObjectiveContent> updateCropCategoryObjectiveContent(@PathVariable int id, @RequestBody CropCategoryObjectiveContentDTO cropCategoryObjectiveContentDTO) {
        return ResponseEntity.ok(cropCategoryObjectiveContentService.updateCropCategoryObjectiveContent(id, cropCategoryObjectiveContentDTO));
    }

    // Delete a content
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCropCategoryObjectiveContent(@PathVariable int id) {
        cropCategoryObjectiveContentService.deleteCropCategoryObjectiveContent(id);
        return ResponseEntity.ok("Content deleted successfully");
    }
}
