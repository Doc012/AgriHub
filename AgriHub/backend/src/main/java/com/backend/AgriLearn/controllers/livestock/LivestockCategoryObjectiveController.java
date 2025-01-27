package com.backend.AgriLearn.controllers.livestock;


import com.backend.AgriLearn.dtos.livestock.LivestockCategoryObjectiveDTO;
import com.backend.AgriLearn.entities.livestock.LivestockCategoryObjective;
import com.backend.AgriLearn.services.livestock.LivestockCategoryObjectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/livestock-category-objectives")
public class LivestockCategoryObjectiveController {

    @Autowired
    private LivestockCategoryObjectiveService livestockCategoryObjectiveService;

    // Create a new category objective
    @PostMapping
    public ResponseEntity<LivestockCategoryObjective> createLivestockCategoryObjective(@RequestBody LivestockCategoryObjectiveDTO livestockCategoryObjectiveDTO) {
        try {
            LivestockCategoryObjective createdLivestockCategoryObjective = livestockCategoryObjectiveService.createLivestockCategoryObjective(livestockCategoryObjectiveDTO);
            return ResponseEntity.ok(createdLivestockCategoryObjective);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }


    // Get all objectives
    @GetMapping
    public ResponseEntity<List<LivestockCategoryObjective>> getAllLivestockCategoryObjectives() {
        List<LivestockCategoryObjective> livestockCategoryObjectives = livestockCategoryObjectiveService.getAllLivestockCategoryObjectives();
        return ResponseEntity.ok(livestockCategoryObjectives);
    }

    // Get objectives by livestock category ID
    @GetMapping("/livestock-category/{livestockCategoryID}")
    public ResponseEntity<?> getLivestockCategoryObjectivesByLivestockCategory(@PathVariable int livestockCategoryID) {
        try {
            List<LivestockCategoryObjective> livestockCategoryObjectives = livestockCategoryObjectiveService.getLivestockCategoryObjectivesByLivestockCategory(livestockCategoryID);
            return ResponseEntity.ok(livestockCategoryObjectives);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    // Get an objective by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getLivestockCategoryObjectiveByID(@PathVariable int id) {
        Optional<LivestockCategoryObjective> livestockCategoryObjective = livestockCategoryObjectiveService.getLivestockCategoryObjectiveByID(id);
        return livestockCategoryObjective.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an objective
    @PutMapping("/{id}")
    public ResponseEntity<?> updateLivestockCategoryObjective(@PathVariable int id, @RequestBody LivestockCategoryObjectiveDTO livestockCategoryObjectiveDTO) {
        try {
            LivestockCategoryObjective updatedLivestockCategoryObjective = livestockCategoryObjectiveService.updateLivestockCategoryObjective(id, livestockCategoryObjectiveDTO);
            return ResponseEntity.ok(updatedLivestockCategoryObjective);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an objective
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLivestockCategoryObjective(@PathVariable int id) {
        try {
            livestockCategoryObjectiveService.deleteLivestockCategoryObjective(id);
            return ResponseEntity.ok("Livestock category objective deleted successfully");
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

}
