package com.backend.AgriLearn.services;

import com.backend.AgriLearn.dtos.DistrictDTO;
import com.backend.AgriLearn.entities.District;
import com.backend.AgriLearn.entities.Province;
import com.backend.AgriLearn.repositories.DistrictRepository;
import com.backend.AgriLearn.repositories.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    // Create a new district
    public District createDistrict(DistrictDTO districtDTO) {
        Optional<Province> province = provinceRepository.findById(districtDTO.getProvinceID());
        if (province.isPresent()) {
            District district = new District();
            district.setProvince(province.get());
            district.setDistrict(districtDTO.getDistrict());
            district.setDescription(districtDTO.getDescription());
            district.setDistrictPicUrl(districtDTO.getDistrictPicUrl());
            return districtRepository.save(district);
        } else {
            throw new RuntimeException("Province not found with ID " + districtDTO.getProvinceID());
        }
    }

    // Retrieve all districts
    public List<District> getAllDistricts() {
        return districtRepository.findAll();
    }

    // Retrieve districts by province
    public List<District> getDistrictsByProvince(int provinceID) {
        return districtRepository.findByProvince_ProvinceID(provinceID);
    }

    // Retrieve a district by ID
    public Optional<District> getDistrictById(int id) {
        return districtRepository.findById(id);
    }

    // Update an existing district
    public District updateDistrict(int id, DistrictDTO districtDTO) {
        Optional<District> existingDistrict = districtRepository.findById(id);
        Optional<Province> province = provinceRepository.findById(districtDTO.getProvinceID());
        if (existingDistrict.isPresent() && province.isPresent()) {
            District district = existingDistrict.get();
            district.setProvince(province.get());
            district.setDistrict(districtDTO.getDistrict());
            district.setDescription(districtDTO.getDescription());
            district.setDistrictPicUrl(districtDTO.getDistrictPicUrl());
            return districtRepository.save(district);
        } else {
            throw new RuntimeException("District or Province not found with given IDs");
        }
    }

    // Delete a district
    public void deleteDistrict(int id) {
        if (districtRepository.existsById(id)) {
            districtRepository.deleteById(id);
        } else {
            throw new RuntimeException("District not found with ID " + id);
        }
    }
}
