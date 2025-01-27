package com.backend.AgriLearn.controllers.livestock;

import com.backend.AgriLearn.dtos.livestock.LivestockCategoryObjectiveContentDTO;
import com.backend.AgriLearn.entities.livestock.LivestockCategoryObjectiveContent;
import com.backend.AgriLearn.services.livestock.LivestockCategoryObjectiveContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/livestock-category-objective-contents")
public class LivestockCategoryObjectiveContentController {

    @Autowired
    private LivestockCategoryObjectiveContentService livestockCategoryObjectiveContentService;

    // Create a new content
    @PostMapping
    public ResponseEntity<LivestockCategoryObjectiveContent> createLivestockCategoryObjectiveContent(@RequestBody LivestockCategoryObjectiveContentDTO livestockCategoryObjectiveContentDTO) {
        return ResponseEntity.ok(livestockCategoryObjectiveContentService.createLivestockCategoryObjectiveContent(livestockCategoryObjectiveContentDTO));
    }

    // Get all contents
    @GetMapping
    public ResponseEntity<List<LivestockCategoryObjectiveContent>> getAllLivestockCategoryObjectiveContents() {
        return ResponseEntity.ok(livestockCategoryObjectiveContentService.getAllLivestockCategoryObjectiveContents());
    }

    // Get contents by objective ID
    @GetMapping("/livestock-category-objective/{livestockCategoryObjectiveID}")
    public ResponseEntity<List<LivestockCategoryObjectiveContent>> getLivestockCategoryObjectiveContentsByLivestockCategoryObjective(@PathVariable int livestockCategoryObjectiveID) {
        return ResponseEntity.ok(livestockCategoryObjectiveContentService.getLivestockCategoryObjectiveContentsByLivestockCategoryObjective(livestockCategoryObjectiveID));
    }

    // Get a content by ID
    @GetMapping("/{id}")
    public ResponseEntity<LivestockCategoryObjectiveContent> getLivestockCategoryObjectiveContentByID(@PathVariable int id) {
        return livestockCategoryObjectiveContentService.getLivestockCategoryObjectiveContentByID(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a content
    @PutMapping("/{id}")
    public ResponseEntity<LivestockCategoryObjectiveContent> updateLivestockCategoryObjectiveContent(@PathVariable int id, @RequestBody LivestockCategoryObjectiveContentDTO livestockCategoryObjectiveContentDTO) {
        return ResponseEntity.ok(livestockCategoryObjectiveContentService.updateLivestockCategoryObjectiveContent(id, livestockCategoryObjectiveContentDTO));
    }

    // Delete a content
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLivestockCategoryObjectiveContent(@PathVariable int id) {
        livestockCategoryObjectiveContentService.deleteLivestockCategoryObjectiveContent(id);
        return ResponseEntity.ok("Content deleted successfully");
    }
}
