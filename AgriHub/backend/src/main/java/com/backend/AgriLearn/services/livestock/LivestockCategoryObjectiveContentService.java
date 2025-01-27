package com.backend.AgriLearn.services.livestock;

import com.backend.AgriLearn.dtos.livestock.LivestockCategoryObjectiveContentDTO;
import com.backend.AgriLearn.entities.livestock.LivestockCategoryObjective;
import com.backend.AgriLearn.entities.livestock.LivestockCategoryObjectiveContent;
import com.backend.AgriLearn.repositories.livestock.LivestockCategoryObjectiveContentRepository;
import com.backend.AgriLearn.repositories.livestock.LivestockCategoryObjectiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivestockCategoryObjectiveContentService {

    @Autowired
    private LivestockCategoryObjectiveContentRepository livestockCategoryObjectiveContentRepository;

    @Autowired
    private LivestockCategoryObjectiveRepository livestockCategoryObjectiveRepository;

    // Create a new livestock content
    public LivestockCategoryObjectiveContent createLivestockCategoryObjectiveContent(LivestockCategoryObjectiveContentDTO livestockCategoryObjectiveContentDTO) {
        Optional<LivestockCategoryObjective> livestockCategoryObjective = livestockCategoryObjectiveRepository.findById(livestockCategoryObjectiveContentDTO.getLivestockCategoryObjectiveID());
        if (livestockCategoryObjective.isPresent()) {
            LivestockCategoryObjectiveContent livestockCategoryObjectiveContent = new LivestockCategoryObjectiveContent();

            livestockCategoryObjectiveContent.setTitle(livestockCategoryObjectiveContentDTO.getTitle());
            livestockCategoryObjectiveContent.setContent(livestockCategoryObjectiveContentDTO.getContent());
            livestockCategoryObjectiveContent.setPicUrl(livestockCategoryObjectiveContentDTO.getPicUrl());
            livestockCategoryObjectiveContent.setVidUrl(livestockCategoryObjectiveContentDTO.getVidUrl());
            livestockCategoryObjectiveContent.setLivestockCategoryObjective(livestockCategoryObjective.get());

            return livestockCategoryObjectiveContentRepository.save(livestockCategoryObjectiveContent);
        } else {
            throw new RuntimeException("Livestock category objective not found with ID " + livestockCategoryObjectiveContentDTO.getLivestockCategoryObjectiveID());
        }
    }

    // Get all contents
    public List<LivestockCategoryObjectiveContent> getAllLivestockCategoryObjectiveContents() {
        return livestockCategoryObjectiveContentRepository.findAll();
    }

    // Get content by objective ID
    public List<LivestockCategoryObjectiveContent> getLivestockCategoryObjectiveContentsByLivestockCategoryObjective(int livestockCategoryObjectiveID) {
        Optional<LivestockCategoryObjective> livestockCategoryObjective = livestockCategoryObjectiveRepository.findById(livestockCategoryObjectiveID);

        if (livestockCategoryObjective.isPresent()) {
            return livestockCategoryObjectiveContentRepository.findByLivestockCategoryObjective_LivestockCategoryObjectiveID(livestockCategoryObjectiveID);
        } else {
            throw new RuntimeException("Livestock category objective not found with ID " + livestockCategoryObjectiveID);
        }
    }

    // Get content by ID - NOT FROM GPT
    public Optional<LivestockCategoryObjectiveContent> getLivestockCategoryObjectiveContentByID(int livestockCategoryObjectiveContentID) {
        return livestockCategoryObjectiveContentRepository.findById(livestockCategoryObjectiveContentID);
    }

    // Update livestock content by ID
    public LivestockCategoryObjectiveContent updateLivestockCategoryObjectiveContent(int livestockCategoryObjectiveContentID,LivestockCategoryObjectiveContentDTO livestockCategoryObjectiveContentDTO) {
        Optional<LivestockCategoryObjectiveContent> livestockCategoryObjectiveContent = livestockCategoryObjectiveContentRepository.findById(livestockCategoryObjectiveContentDTO.getLivestockCategoryObjectiveID());
        if (livestockCategoryObjectiveContent.isPresent()) {
           LivestockCategoryObjectiveContent livestockCategoryObjectiveContent1 = livestockCategoryObjectiveContent.get();

           Optional<LivestockCategoryObjective> livestockCategoryObjective = livestockCategoryObjectiveRepository.findById(livestockCategoryObjectiveContentDTO.getLivestockCategoryObjectiveID());
           if (livestockCategoryObjective.isPresent()) {
               livestockCategoryObjectiveContent1.setTitle(livestockCategoryObjectiveContentDTO.getTitle());
               livestockCategoryObjectiveContent1.setContent(livestockCategoryObjectiveContentDTO.getContent());
               livestockCategoryObjectiveContent1.setPicUrl(livestockCategoryObjectiveContentDTO.getPicUrl());
               livestockCategoryObjectiveContent1.setVidUrl(livestockCategoryObjectiveContentDTO.getVidUrl());
               livestockCategoryObjectiveContent1.setLivestockCategoryObjective(livestockCategoryObjective.get());
               return livestockCategoryObjectiveContentRepository.save(livestockCategoryObjectiveContent1);
           } else {
               throw new RuntimeException("Livestock category objective not found with ID " + livestockCategoryObjectiveContentDTO.getLivestockCategoryObjectiveID());
           }
        } else {
            throw new RuntimeException("Livestock category objective content not found with ID " + livestockCategoryObjectiveContentDTO.getLivestockCategoryObjectiveID());
        }
    }

    // Delete livestock content by ID
    public void deleteLivestockCategoryObjectiveContent(int livestockCategoryObjectiveContentID) {
        Optional<LivestockCategoryObjectiveContent> livestockCategoryObjectiveContent = livestockCategoryObjectiveContentRepository.findById(livestockCategoryObjectiveContentID);
        if (livestockCategoryObjectiveContent.isPresent()) {
            livestockCategoryObjectiveContentRepository.delete(livestockCategoryObjectiveContent.get());
        } else {
            throw new RuntimeException("Livestock category objective content not found with ID " + livestockCategoryObjectiveContentID);
        }
    }
}