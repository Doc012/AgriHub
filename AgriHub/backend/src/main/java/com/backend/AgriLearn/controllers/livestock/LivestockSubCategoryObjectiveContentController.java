package com.backend.AgriLearn.controllers.livestock;


import com.backend.AgriLearn.dtos.livestock.LivestockSubCategoryObjectiveContentDTO;
import com.backend.AgriLearn.entities.livestock.LivestockSubCategoryObjectiveContent;
import com.backend.AgriLearn.services.livestock.LivestockSubCategoryObjectiveContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/livestock-sub-category-objective-content")
public class LivestockSubCategoryObjectiveContentController {

    @Autowired
    private LivestockSubCategoryObjectiveContentService livestockSubCategoryObjectiveContentService;

    // Create a new content
    @PostMapping
    public ResponseEntity<LivestockSubCategoryObjectiveContent> createLivestockSubCategoryObjectiveContent(@RequestBody LivestockSubCategoryObjectiveContentDTO livestockSubCategoryObjectiveContentDTO) {
        try {
            LivestockSubCategoryObjectiveContent createdLivestockSubCategoryObjectiveContent = livestockSubCategoryObjectiveContentService.createLivestockSubCategoryObjectiveContent(livestockSubCategoryObjectiveContentDTO);
            return ResponseEntity.ok(createdLivestockSubCategoryObjectiveContent);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Get all contents
    @GetMapping
    public ResponseEntity<List<LivestockSubCategoryObjectiveContent>> getAllLivestockSubCategoryObjectiveContents() {
        List<LivestockSubCategoryObjectiveContent> livestockSubCategoryObjectiveContents = livestockSubCategoryObjectiveContentService.getAllLivestockSubCategoryObjectiveContents();
        return ResponseEntity.ok(livestockSubCategoryObjectiveContents);
    }

    // Get contents by objective ID
    @GetMapping("/livestock-sub-category-objective/{livestockSubCategoryObjectiveID}")
    public ResponseEntity<?> getLivestockSubCategoryObjectiveContentsByLivestockSubCategoryObjective(@PathVariable int livestockSubCategoryObjectiveID) {
        try {
            List<LivestockSubCategoryObjectiveContent> livestockSubCategoryObjectiveContents = livestockSubCategoryObjectiveContentService.getLivestockSubCategoryObjectiveContentsByLivestockSubCategoryObjective(livestockSubCategoryObjectiveID);
            return ResponseEntity.ok(livestockSubCategoryObjectiveContents);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    // Get a content by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getLivestockSubCategoryObjectiveContentByID(@PathVariable int id) {
        Optional<LivestockSubCategoryObjectiveContent> livestockSubCategoryObjectiveContent = livestockSubCategoryObjectiveContentService.getLivestockSubCategoryObjectiveContentByID(id);
        return livestockSubCategoryObjectiveContent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a content
    @PutMapping("/{id}")
    public ResponseEntity<?> updateLivestockSubCategoryObjectiveContent(@PathVariable int id, @RequestBody LivestockSubCategoryObjectiveContentDTO livestockSubCategoryObjectiveContentDTO) {
        try {
            LivestockSubCategoryObjectiveContent updatedLivestockSubCategoryObjectiveContent = livestockSubCategoryObjectiveContentService.updateLivestockSubCategoryObjectiveContent(id, livestockSubCategoryObjectiveContentDTO);
            return ResponseEntity.ok(updatedLivestockSubCategoryObjectiveContent);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a content
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLivestockSubCategoryObjectiveContent(@PathVariable int id) {
        try {
            livestockSubCategoryObjectiveContentService.deleteLivestockSubCategoryObjectiveContent(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
