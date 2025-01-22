package com.backend.AgriLearn.controllers;

import com.backend.AgriLearn.entities.crop.CropCategory;
import com.backend.AgriLearn.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Crop Category Endpoints
    @PostMapping("/crop-category")
    public CropCategory createCropCategory(@RequestBody CropCategory cropCategory) {
        return adminService.createCropCategory(cropCategory);
    }

    @GetMapping("/crop-categories")
    public List<CropCategory> getAllCropCategories() {
        return adminService.getAllCropCategories();
    }

    @PutMapping("/crop-category")
    public CropCategory updateCropCategory(@RequestBody CropCategory cropCategory) {
        return adminService.updateCropCategory(cropCategory);
    }

    @DeleteMapping("/crop-category/{id}")
    public void deleteCropCategory(@PathVariable Long id) {
        adminService.deleteCropCategory(id);
    }

    // Similar methods for the other entities...
}

