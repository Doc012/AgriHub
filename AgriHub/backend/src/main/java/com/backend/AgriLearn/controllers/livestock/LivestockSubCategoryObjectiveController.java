package com.backend.AgriLearn.controllers.livestock;

import com.backend.AgriLearn.dtos.livestock.LivestockSubCategoryObjectiveDTO;
import com.backend.AgriLearn.entities.livestock.LivestockSubCategoryObjective;
import com.backend.AgriLearn.services.livestock.LivestockSubCategoryObjectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/livestock-sub-category-objectives")
public class LivestockSubCategoryObjectiveController {

    @Autowired
    private LivestockSubCategoryObjectiveService livestockSubCategoryObjectiveService;

    // Create a new sub-category objective
    @PostMapping
    public ResponseEntity<LivestockSubCategoryObjective> createLivestockSubCategoryObjective(@RequestBody LivestockSubCategoryObjectiveDTO livestockSubCategoryObjectiveDTO) {
        try {
            LivestockSubCategoryObjective createdLivestockSubCategoryObjective = livestockSubCategoryObjectiveService.createLivestockSubCategoryObjective(livestockSubCategoryObjectiveDTO);
            return ResponseEntity.ok(createdLivestockSubCategoryObjective);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Get all objectives
    @GetMapping
    public ResponseEntity<?> getAllLivestockSubCategoryObjectives() {
        List<LivestockSubCategoryObjective> livestockSubCategoryObjectives = livestockSubCategoryObjectiveService.getAllLivestockSubCategoryObjectives();
        return ResponseEntity.ok(livestockSubCategoryObjectives);
    }

    // Get objectives by livestock sub-category ID
    @GetMapping("/livestock-sub-category/{livestockSubCategoryID}")
    public ResponseEntity<?> getLivestockSubCategoryObjectivesByLivestockSubCategory(@PathVariable int livestockSubCategoryID) {
        try {
            List<LivestockSubCategoryObjective> livestockSubCategoryObjectives = livestockSubCategoryObjectiveService.getLivestockSubCategoryObjectivesByLivestockSubCategory(livestockSubCategoryID);
            return ResponseEntity.ok(livestockSubCategoryObjectives);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    // Get an objective by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getLivestockSubCategoryObjectiveByID(@PathVariable int id) {
        Optional<LivestockSubCategoryObjective> livestockSubCategoryObjective = livestockSubCategoryObjectiveService.getLivestockSubCategoryObjectiveByID(id);
        return livestockSubCategoryObjective.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an objective
    @PutMapping("/{id}")
    public ResponseEntity<?> updateLivestockSubCategoryObjective(@PathVariable int id, @RequestBody LivestockSubCategoryObjectiveDTO livestockSubCategoryObjectiveDTO) {
        try {
            LivestockSubCategoryObjective updatedLivestockSubCategoryObjective = livestockSubCategoryObjectiveService.updateLivestockSubCategoryObjective(id, livestockSubCategoryObjectiveDTO);
            return ResponseEntity.ok(updatedLivestockSubCategoryObjective);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an objective
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLivestockSubCategoryObjective(@PathVariable int id) {
        try {
            livestockSubCategoryObjectiveService.deleteLivestockSubCategoryObjective(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

}
