package com.backend.AgriLearn.controllers.crop;

import com.backend.AgriLearn.dtos.crop.CropCategoryObjectiveDTO;
import com.backend.AgriLearn.entities.crop.CropCategoryObjective;
import com.backend.AgriLearn.services.crop.CropCategoryObjectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/crop-category-objectives")
public class CropCategoryObjectiveController {

    @Autowired
    private CropCategoryObjectiveService cropCategoryObjectiveService;

    // Create a new category objective
    @PostMapping
    public ResponseEntity<CropCategoryObjective> createCropCategoryObjective(@RequestBody CropCategoryObjectiveDTO cropCategoryObjectiveDTO) {
        try {
            CropCategoryObjective createdCropCategoryObjective = cropCategoryObjectiveService.createCropCategoryObjective(cropCategoryObjectiveDTO);
            return ResponseEntity.ok(createdCropCategoryObjective);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Get all objectives
    @GetMapping
    public ResponseEntity<List<CropCategoryObjective>> getAllCropCategoryObjectives() {
        List<CropCategoryObjective> cropCategoryObjectives = cropCategoryObjectiveService.getAllCropCategoryObjectives();
        return ResponseEntity.ok(cropCategoryObjectives);
    }

    // Get objectives by crop category ID
    @GetMapping("/crop-category/{cropCategoryID}")
    public ResponseEntity<?> getCropCategoryObjectivesByCropCategory(@PathVariable int cropCategoryID) {
        try {
            List<CropCategoryObjective> cropCategoryObjectives = cropCategoryObjectiveService.getCropCategoryObjectivesByCropCategory(cropCategoryID);
            return ResponseEntity.ok(cropCategoryObjectives);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    // Get an objective by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCropCategoryObjectiveByID(@PathVariable int id) {
        Optional<CropCategoryObjective> cropCategoryObjective = cropCategoryObjectiveService.getCropCategoryObjectiveByID(id);
        return cropCategoryObjective.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an objective
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCropCategoryObjective(@PathVariable int id, @RequestBody CropCategoryObjectiveDTO cropCategoryObjectiveDTO) {
        try {
            CropCategoryObjective updatedCropCategoryObjective = cropCategoryObjectiveService.updateCropCategoryObjective(id, cropCategoryObjectiveDTO);
            return ResponseEntity.ok(updatedCropCategoryObjective);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an objective
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCropCategoryObjective(@PathVariable int id) {
        try {
            cropCategoryObjectiveService.deleteCropCategoryObjective(id);
            return ResponseEntity.ok("Crop objective deleted successfully");
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
