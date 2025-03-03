package com.backend.AgriLearn.controllers;

import com.backend.AgriLearn.dtos.ProvinceDTO;
import com.backend.AgriLearn.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/provinces")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    // Create a new province
    @PostMapping
    public ResponseEntity<ProvinceDTO> createProvince(@RequestBody ProvinceDTO provinceDTO) {
        return ResponseEntity.ok(provinceService.createProvince(provinceDTO));
    }

    // Get all provinces
    @GetMapping
    public ResponseEntity<List<ProvinceDTO>> getAllProvinces() {
        return ResponseEntity.ok(provinceService.getAllProvinces());
    }

    // Get a province by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProvinceDTO> getProvinceById(@PathVariable int id) {
        ProvinceDTO provinceDTO = provinceService.getProvinceById(id);
        return provinceDTO != null ? ResponseEntity.ok(provinceDTO) : ResponseEntity.notFound().build();
    }

    // Update a province
    @PutMapping("/{id}")
    public ResponseEntity<ProvinceDTO> updateProvince(@PathVariable int id, @RequestBody ProvinceDTO provinceDTO) {
        ProvinceDTO updatedProvince = provinceService.updateProvince(id, provinceDTO);
        return updatedProvince != null ? ResponseEntity.ok(updatedProvince) : ResponseEntity.notFound().build();
    }

    // Delete a province
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvince(@PathVariable int id) {
        return provinceService.deleteProvince(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
