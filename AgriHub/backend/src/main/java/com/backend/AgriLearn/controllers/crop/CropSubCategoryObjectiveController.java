package com.backend.AgriLearn.controllers.crop;

import com.backend.AgriLearn.dtos.crop.CropSubCategoryObjectiveDTO;
import com.backend.AgriLearn.entities.crop.CropSubCategoryObjective;
import com.backend.AgriLearn.services.crop.CropSubCategoryObjectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/crop-sub-category-objectives")
public class CropSubCategoryObjectiveController {

    @Autowired
    private CropSubCategoryObjectiveService cropSubCategoryObjectiveService;

    // Create a new sub-category objective
    @PostMapping
    public ResponseEntity<CropSubCategoryObjective> createCropSubCategoryObjective(@RequestBody CropSubCategoryObjectiveDTO cropSubCategoryObjectiveDTO) {
        try {
            CropSubCategoryObjective createdCropSubCategoryObjective = cropSubCategoryObjectiveService.createCropSubCategoryObjective(cropSubCategoryObjectiveDTO);
            return ResponseEntity.ok(createdCropSubCategoryObjective);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Get all objectives
    @GetMapping
    public ResponseEntity<?> getAllCropSubCategoryObjectives() {
        List<CropSubCategoryObjective> cropSubCategoryObjectives = cropSubCategoryObjectiveService.getAllCropSubCategoryObjectives();
        return ResponseEntity.ok(cropSubCategoryObjectives);
    }

    // Get objectives by crop sub-category ID
    @GetMapping("/crop-sub-category/{cropSubCategoryID}")
    public ResponseEntity<?> getCropSubCategoryObjectivesByCropSubCategory(@PathVariable int cropSubCategoryID) {
        try {
            List<CropSubCategoryObjective> cropSubCategoryObjectives = cropSubCategoryObjectiveService.getCropSubCategoryObjectivesByCropSubCategory(cropSubCategoryID);
            return ResponseEntity.ok(cropSubCategoryObjectives);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    // Get an objective by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCropSubCategoryObjectiveByID(@PathVariable int id) {
        Optional<CropSubCategoryObjective> cropSubCategoryObjective = cropSubCategoryObjectiveService.getCropSubCategoryObjectiveByID(id);
        return cropSubCategoryObjective.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an objective
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCropSubCategoryObjective(@PathVariable int id, @RequestBody CropSubCategoryObjectiveDTO cropSubCategoryObjectiveDTO) {
        try {
            CropSubCategoryObjective updatedCropSubCategoryObjective = cropSubCategoryObjectiveService.updateCropSubCategoryObjective(id, cropSubCategoryObjectiveDTO);
            return ResponseEntity.ok(updatedCropSubCategoryObjective);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an objective
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCropSubCategoryObjective(@PathVariable int id) {
        try {
            cropSubCategoryObjectiveService.deleteCropSubCategoryObjective(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
