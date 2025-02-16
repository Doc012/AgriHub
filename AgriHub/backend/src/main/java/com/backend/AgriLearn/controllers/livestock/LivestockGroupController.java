package com.backend.AgriLearn.controllers.livestock;

import com.backend.AgriLearn.dtos.livestock.LivestockGroupDTO;
import com.backend.AgriLearn.entities.livestock.LivestockGroup;
import com.backend.AgriLearn.services.livestock.LivestockGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/livestock-groups")
public class LivestockGroupController {

    @Autowired
    private LivestockGroupService livestockGroupService;

    // CREATE a new livestock group
    @PostMapping
    public ResponseEntity<LivestockGroup> createLivestockGroup(@RequestBody LivestockGroupDTO dto) {
        LivestockGroup createdGroup = livestockGroupService.createLivestockGroup(dto);
        return ResponseEntity.ok(createdGroup);
    }

    // READ all livestock groups
    @GetMapping
    public ResponseEntity<List<LivestockGroup>> getAllLivestockGroups() {
        List<LivestockGroup> groups = livestockGroupService.getAllLivestockGroups();
        return ResponseEntity.ok(groups);
    }

    // READ a livestock group by ID
    @GetMapping("/{id}")
    public ResponseEntity<LivestockGroup> getLivestockGroupByID(@PathVariable("id") int id) {
        return livestockGroupService.getLivestockGroupByID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // READ livestock groups by category ID
    @GetMapping("/livestock-category/{livestockCategoryID}")
    public ResponseEntity<List<LivestockGroup>> getLivestockGroupsByCategory(@PathVariable("livestockCategoryID") int livestockCategoryID) {
        List<LivestockGroup> groups = livestockGroupService.getLivestockGroupsByCategory(livestockCategoryID);
        return ResponseEntity.ok(groups);
    }

    // UPDATE a livestock group
    @PutMapping("/{id}")
    public ResponseEntity<LivestockGroup> updateLivestockGroup(@PathVariable("id") int id, @RequestBody LivestockGroupDTO dto) {
        try {
            LivestockGroup updatedGroup = livestockGroupService.updateLivestockGroup(id, dto);
            return ResponseEntity.ok(updatedGroup);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE a livestock group
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivestockGroup(@PathVariable("id") int id) {
        try {
            livestockGroupService.deleteLivestockGroup(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
