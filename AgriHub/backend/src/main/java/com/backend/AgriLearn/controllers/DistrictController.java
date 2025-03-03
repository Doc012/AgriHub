package com.backend.AgriLearn.controllers;

import com.backend.AgriLearn.dtos.DistrictDTO;
import com.backend.AgriLearn.entities.District;
import com.backend.AgriLearn.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/districts")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    // Create a new district
    @PostMapping
    public ResponseEntity<District> createDistrict(@RequestBody DistrictDTO districtDTO) {
        try {
            District createdDistrict = districtService.createDistrict(districtDTO);
            return ResponseEntity.ok(createdDistrict);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Get all districts
    @GetMapping
    public ResponseEntity<List<District>> getAllDistricts() {
        List<District> districts = districtService.getAllDistricts();
        return ResponseEntity.ok(districts);
    }

    // Get districts by province ID
    @GetMapping("/province/{provinceID}")
    public ResponseEntity<List<District>> getDistrictsByProvince(@PathVariable("provinceID") int provinceID) {
        List<District> districts = districtService.getDistrictsByProvince(provinceID);
        return districts.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(districts);
    }

    // Get a district by ID
    @GetMapping("/{id}")
    public ResponseEntity<District> getDistrictById(@PathVariable("id") int id) {
        Optional<District> district = districtService.getDistrictById(id);
        return district.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Update a district
    @PutMapping("/{id}")
    public ResponseEntity<District> updateDistrict(@PathVariable("id") int id, @RequestBody DistrictDTO districtDTO) {
        try {
            District updatedDistrict = districtService.updateDistrict(id, districtDTO);
            return ResponseEntity.ok(updatedDistrict);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a district
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDistrict(@PathVariable("id") int id) {
        try {
            districtService.deleteDistrict(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
