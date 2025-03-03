package com.backend.AgriLearn.services;

import com.backend.AgriLearn.dtos.ProvinceDTO;
import com.backend.AgriLearn.entities.Province;
import com.backend.AgriLearn.repositories.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    // Create a new province
    public ProvinceDTO createProvince(ProvinceDTO provinceDTO) {
        Province province = new Province();
        province.setProvince(provinceDTO.getProvince());
        province.setDescription(provinceDTO.getDescription());
        province.setProvincePicUrl(provinceDTO.getProvincePicUrl());

        Province savedProvince = provinceRepository.save(province);
        return convertToDTO(savedProvince);
    }

    // Get all provinces
    public List<ProvinceDTO> getAllProvinces() {
        return provinceRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get a single province by ID
    public ProvinceDTO getProvinceById(int id) {
        Optional<Province> province = provinceRepository.findById(id);
        return province.map(this::convertToDTO).orElse(null);
    }

    // Update province
    public ProvinceDTO updateProvince(int id, ProvinceDTO provinceDTO) {
        Optional<Province> existingProvince = provinceRepository.findById(id);
        if (existingProvince.isPresent()) {
            Province province = existingProvince.get();
            province.setProvince(provinceDTO.getProvince());
            province.setDescription(provinceDTO.getDescription());
            province.setProvincePicUrl(provinceDTO.getProvincePicUrl());

            Province updatedProvince = provinceRepository.save(province);
            return convertToDTO(updatedProvince);
        }
        return null;
    }

    // Delete a province
    public boolean deleteProvince(int id) {
        if (provinceRepository.existsById(id)) {
            provinceRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Convert Entity to DTO
    private ProvinceDTO convertToDTO(Province province) {
        ProvinceDTO dto = new ProvinceDTO();
        dto.setProvinceID(province.getProvinceID());
        dto.setProvince(province.getProvince());
        dto.setDescription(province.getDescription());
        dto.setProvincePicUrl(province.getProvincePicUrl());
        return dto;
    }
}
