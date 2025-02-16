package com.backend.AgriLearn.services.livestock;

import com.backend.AgriLearn.dtos.livestock.LivestockGroupDTO;
import com.backend.AgriLearn.entities.livestock.LivestockCategory;
import com.backend.AgriLearn.entities.livestock.LivestockGroup;
import com.backend.AgriLearn.repositories.livestock.LivestockCategoryRepository;
import com.backend.AgriLearn.repositories.livestock.LivestockGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LivestockGroupService {

    @Autowired
    private LivestockGroupRepository livestockGroupRepository;

    @Autowired
    private LivestockCategoryRepository livestockCategoryRepository;

    // CREATE a new Livestock Group
    public LivestockGroup createLivestockGroup(LivestockGroupDTO dto) {
        LivestockCategory category = livestockCategoryRepository.findById(dto.getLivestockCategoryID())
                .orElseThrow(() -> new RuntimeException("Livestock Category not found"));

        LivestockGroup group = new LivestockGroup();
        group.setTitle(dto.getTitle());
        group.setDescription(dto.getDescription());
        group.setLivestockCategory(category);
        group.setPicUrl(dto.getPicUrl());

        return livestockGroupRepository.save(group);
    }

    // READ all Livestock Groups
    public List<LivestockGroup> getAllLivestockGroups() {
        return livestockGroupRepository.findAll();
    }

    // READ a Livestock Group by ID
    public Optional<LivestockGroup> getLivestockGroupByID(int id) {
        return livestockGroupRepository.findById(id);
    }

    // READ Livestock Groups by Category ID
    public List<LivestockGroup> getLivestockGroupsByCategory(int livestockCategoryID) {
        return livestockGroupRepository.findByLivestockCategory_LivestockCategoryID(livestockCategoryID);
    }

    // UPDATE a Livestock Group
    public LivestockGroup updateLivestockGroup(int id, LivestockGroupDTO dto) {
        LivestockGroup existingGroup = livestockGroupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livestock Group not found"));

        LivestockCategory category = livestockCategoryRepository.findById(dto.getLivestockCategoryID())
                .orElseThrow(() -> new RuntimeException("Livestock Category not found"));

        existingGroup.setTitle(dto.getTitle());
        existingGroup.setDescription(dto.getDescription());
        existingGroup.setPicUrl(dto.getPicUrl());
        existingGroup.setLivestockCategory(category);


        return livestockGroupRepository.save(existingGroup);
    }

    // DELETE a Livestock Group
    public void deleteLivestockGroup(int id) {
        if (!livestockGroupRepository.existsById(id)) {
            throw new RuntimeException("Livestock Group not found");
        }
        livestockGroupRepository.deleteById(id);
    }
}
