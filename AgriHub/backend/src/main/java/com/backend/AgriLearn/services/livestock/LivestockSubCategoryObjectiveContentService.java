package com.backend.AgriLearn.services.livestock;

import com.backend.AgriLearn.dtos.livestock.LivestockSubCategoryObjectiveContentDTO;
import com.backend.AgriLearn.entities.livestock.LivestockSubCategoryObjective;
import com.backend.AgriLearn.entities.livestock.LivestockSubCategoryObjectiveContent;
import com.backend.AgriLearn.repositories.livestock.LivestockSubCategoryObjectiveContentRepository;
import com.backend.AgriLearn.repositories.livestock.LivestockSubCategoryObjectiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivestockSubCategoryObjectiveContentService {

    @Autowired
    private LivestockSubCategoryObjectiveContentRepository livestockSubCategoryObjectiveContentRepository;

    @Autowired
    private LivestockSubCategoryObjectiveRepository livestockSubCategoryObjectiveRepository;

    // Create a new livestock sub category objective content
    public LivestockSubCategoryObjectiveContent createLivestockSubCategoryObjectiveContent(LivestockSubCategoryObjectiveContentDTO livestockSubCategoryObjectiveContentDTO) {
        Optional<LivestockSubCategoryObjective> livestockSubCategoryObjective = livestockSubCategoryObjectiveRepository.findById(livestockSubCategoryObjectiveContentDTO.getLivestockSubCategoryObjectiveID());
        if (livestockSubCategoryObjective.isPresent()) {
            LivestockSubCategoryObjectiveContent livestockSubCategoryObjectiveContent = new LivestockSubCategoryObjectiveContent();

            livestockSubCategoryObjectiveContent.setTitle(livestockSubCategoryObjectiveContentDTO.getTitle());
            livestockSubCategoryObjectiveContent.setContent(livestockSubCategoryObjectiveContentDTO.getContent());
            livestockSubCategoryObjectiveContent.setPicUrl(livestockSubCategoryObjectiveContentDTO.getPicUrl());
            livestockSubCategoryObjectiveContent.setVidUrl(livestockSubCategoryObjectiveContentDTO.getVidUrl());
            livestockSubCategoryObjectiveContent.setLivestockSubCategoryObjective(livestockSubCategoryObjective.get());

            return livestockSubCategoryObjectiveContentRepository.save(livestockSubCategoryObjectiveContent);
        } else {
            throw new RuntimeException("Livestock sub-category objective not found with ID " + livestockSubCategoryObjectiveContentDTO.getLivestockSubCategoryObjectiveID());
        }
    }

    // Get all contents
    public List<LivestockSubCategoryObjectiveContent> getAllLivestockSubCategoryObjectiveContents() {
        return livestockSubCategoryObjectiveContentRepository.findAll();
    }

    // Get content by objective ID
    public List<LivestockSubCategoryObjectiveContent> getLivestockSubCategoryObjectiveContentsByLivestockSubCategoryObjective(int livestockSubCategoryObjectiveID) {
        Optional<LivestockSubCategoryObjective> livestockSubCategoryObjective = livestockSubCategoryObjectiveRepository.findById(livestockSubCategoryObjectiveID);

        if (livestockSubCategoryObjective.isPresent()) {
            return livestockSubCategoryObjectiveContentRepository.findByLivestockSubCategoryObjective_LivestockSubCategoryObjectiveID(livestockSubCategoryObjectiveID);
        } else {
            throw new RuntimeException("Livestock sub-category objective not found with ID " + livestockSubCategoryObjectiveID);
        }
    }

    // Get content by ID
    public Optional<LivestockSubCategoryObjectiveContent> getLivestockSubCategoryObjectiveContentByID(int livestockSubCategoryObjectiveContentID) {
        return livestockSubCategoryObjectiveContentRepository.findById(livestockSubCategoryObjectiveContentID);
    }

    // Update an existing livestock sub category objective content
    public LivestockSubCategoryObjectiveContent updateLivestockSubCategoryObjectiveContent(int livestockSubCategoryObjectiveContentID, LivestockSubCategoryObjectiveContentDTO livestockSubCategoryObjectiveContentDTO) {
        Optional<LivestockSubCategoryObjectiveContent> existingLivestockSubCategoryObjectiveContent = livestockSubCategoryObjectiveContentRepository.findById(livestockSubCategoryObjectiveContentID);
        if (existingLivestockSubCategoryObjectiveContent.isPresent()) {
            LivestockSubCategoryObjectiveContent livestockSubCategoryObjectiveContent = existingLivestockSubCategoryObjectiveContent.get();

            Optional<LivestockSubCategoryObjective> livestockSubCategoryObjective = livestockSubCategoryObjectiveRepository.findById(livestockSubCategoryObjectiveContentDTO.getLivestockSubCategoryObjectiveID());
            if (livestockSubCategoryObjective.isPresent()) {
                livestockSubCategoryObjectiveContent.setTitle(livestockSubCategoryObjectiveContentDTO.getTitle());
                livestockSubCategoryObjectiveContent.setContent(livestockSubCategoryObjectiveContentDTO.getContent());
                livestockSubCategoryObjectiveContent.setPicUrl(livestockSubCategoryObjectiveContentDTO.getPicUrl());
                livestockSubCategoryObjectiveContent.setVidUrl(livestockSubCategoryObjectiveContentDTO.getVidUrl());
                livestockSubCategoryObjectiveContent.setLivestockSubCategoryObjective(livestockSubCategoryObjective.get());

                return livestockSubCategoryObjectiveContentRepository.save(livestockSubCategoryObjectiveContent);
            } else {
                throw new RuntimeException("Livestock sub-category objective not found with ID " + livestockSubCategoryObjectiveContentDTO.getLivestockSubCategoryObjectiveID());
            }
        } else {
            throw new RuntimeException("Livestock sub-category objective content not found with ID " + livestockSubCategoryObjectiveContentID);
        }
    }

    // Delete a livestock sub category objective content
    public void deleteLivestockSubCategoryObjectiveContent(int livestockSubCategoryObjectiveContentID) {
        if (livestockSubCategoryObjectiveContentRepository.existsById(livestockSubCategoryObjectiveContentID)) {
            livestockSubCategoryObjectiveContentRepository.deleteById(livestockSubCategoryObjectiveContentID);
        } else {
            throw new RuntimeException("Livestock sub-category objective content not found with ID " + livestockSubCategoryObjectiveContentID);
        }
    }

}
