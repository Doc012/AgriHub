package com.backend.AgriLearn.services.crop;

import com.backend.AgriLearn.dtos.crop.CropGroupDTO;
import com.backend.AgriLearn.entities.crop.CropCategory;
import com.backend.AgriLearn.entities.crop.CropGroup;
import com.backend.AgriLearn.repositories.crop.CropCategoryRepository;
import com.backend.AgriLearn.repositories.crop.CropGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CropGroupService {

    @Autowired
    private CropGroupRepository cropGroupRepository;

    @Autowired
    private CropCategoryRepository cropCategoryRepository;

    // CREATE a new Crop Group
    public CropGroup createCropGroup(CropGroupDTO dto) {
        CropCategory category = cropCategoryRepository.findById(dto.getCropCategoryID())
                .orElseThrow(() -> new RuntimeException("Crop Category not found"));

        CropGroup group = new CropGroup();
        group.setTitle(dto.getTitle());
        group.setDescription(dto.getDescription());
        group.setCropCategory(category);
        group.setPicUrl(dto.getPicUrl());

        return cropGroupRepository.save(group);
    }

    // READ all Crop Groups
    public List<CropGroup> getAllCropGroups() {
        return cropGroupRepository.findAll();
    }

    // READ a Crop Group by ID
    public Optional<CropGroup> getCropGroupByID(int id) {
        return cropGroupRepository.findById(id);
    }

    // READ Crop Groups by Category ID
    public List<CropGroup> getCropGroupsByCategory(int cropCategoryID) {
        return cropGroupRepository.findByCropCategory_CropCategoryID(cropCategoryID);
    }

    // UPDATE a Crop Group
    public CropGroup updateCropGroup(int id, CropGroupDTO dto) {
        CropGroup existingGroup = cropGroupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Crop Group not found"));

        CropCategory category = cropCategoryRepository.findById(dto.getCropCategoryID())
                .orElseThrow(() -> new RuntimeException("Crop Category not found"));

        existingGroup.setTitle(dto.getTitle());
        existingGroup.setDescription(dto.getDescription());
        existingGroup.setCropCategory(category);
        existingGroup.setPicUrl(dto.getPicUrl());

        return cropGroupRepository.save(existingGroup);
    }

    // DELETE a Crop Group
    public void deleteCropGroup(int id) {
        if (!cropGroupRepository.existsById(id)) {
            throw new RuntimeException("Crop Group not found");
        }
        cropGroupRepository.deleteById(id);
    }
}
