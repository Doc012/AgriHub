package com.backend.AgriLearn.controllers.crop;

import com.backend.AgriLearn.dtos.crop.CropGroupDTO;
import com.backend.AgriLearn.entities.crop.CropGroup;
import com.backend.AgriLearn.services.crop.CropGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/crop-groups")
public class CropGroupController {

    @Autowired
    private CropGroupService cropGroupService;

    // CREATE a new crop group
    @PostMapping
    public ResponseEntity<CropGroup> createCropGroup(@RequestBody CropGroupDTO dto) {
        CropGroup createdGroup = cropGroupService.createCropGroup(dto);
        return ResponseEntity.ok(createdGroup);
    }

    // READ all crop groups
    @GetMapping
    public ResponseEntity<List<CropGroup>> getAllCropGroups() {
        List<CropGroup> groups = cropGroupService.getAllCropGroups();
        return ResponseEntity.ok(groups);
    }

    // READ a crop group by ID
    @GetMapping("/{id}")
    public ResponseEntity<CropGroup> getCropGroupByID(@PathVariable("id") int id) {
        return cropGroupService.getCropGroupByID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // READ crop groups by category ID
    @GetMapping("/crop-category/{id}")
    public ResponseEntity<List<CropGroup>> getCropGroupsByCategory(@PathVariable("cropCategoryID") int cropCategoryID) {
        List<CropGroup> groups = cropGroupService.getCropGroupsByCategory(cropCategoryID);
        return ResponseEntity.ok(groups);
    }

    // UPDATE a crop group
    @PutMapping("/{id}")
    public ResponseEntity<CropGroup> updateCropGroup(@PathVariable("id") int id, @RequestBody CropGroupDTO dto) {
        try {
            CropGroup updatedGroup = cropGroupService.updateCropGroup(id, dto);
            return ResponseEntity.ok(updatedGroup);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE a crop group
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCropGroup(@PathVariable("id") int id) {
        try {
            cropGroupService.deleteCropGroup(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
