package com.backend.AgriLearn.services.crop;

import com.backend.AgriLearn.dtos.crop.CropCategoryObjectiveContentDTO;
import com.backend.AgriLearn.entities.crop.CropCategoryObjective;
import com.backend.AgriLearn.entities.crop.CropCategoryObjectiveContent;
import com.backend.AgriLearn.repositories.crop.CropCategoryObjectiveContentRepository;
import com.backend.AgriLearn.repositories.crop.CropCategoryObjectiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CropCategoryObjectiveContentService {

    @Autowired
    private CropCategoryObjectiveContentRepository cropCategoryObjectiveContentRepository;

    @Autowired
    private CropCategoryObjectiveRepository cropCategoryObjectiveRepository;

    // Create a new crop content
    public CropCategoryObjectiveContent createCropCategoryObjectiveContent(CropCategoryObjectiveContentDTO cropCategoryObjectiveContentDTO) {
        Optional<CropCategoryObjective> cropCategoryObjective = cropCategoryObjectiveRepository.findById(cropCategoryObjectiveContentDTO.getCropCategoryObjectiveID());
        if (cropCategoryObjective.isPresent()) {
            CropCategoryObjectiveContent cropCategoryObjectiveContent = new CropCategoryObjectiveContent();

            cropCategoryObjectiveContent.setTitle(cropCategoryObjectiveContentDTO.getTitle());
            cropCategoryObjectiveContent.setContent(cropCategoryObjectiveContentDTO.getContent());
            cropCategoryObjectiveContent.setPicUrl(cropCategoryObjectiveContentDTO.getPicUrl());
            cropCategoryObjectiveContent.setVidUrl(cropCategoryObjectiveContentDTO.getVidUrl());
            cropCategoryObjectiveContent.setCropCategoryObjective(cropCategoryObjective.get());

            return cropCategoryObjectiveContentRepository.save(cropCategoryObjectiveContent);
        } else {
            throw new RuntimeException("Crop category objective not found with ID " + cropCategoryObjectiveContentDTO.getCropCategoryObjectiveID());
        }
    }

    // Get all contents
    public List<CropCategoryObjectiveContent> getAllCropCategoryObjectiveContents() {
        return cropCategoryObjectiveContentRepository.findAll();
    }

    // Get content by objective ID
    public List<CropCategoryObjectiveContent> getCropCategoryObjectiveContentsByCropCategoryObjective(int cropCategoryObjectiveID) {
        Optional<CropCategoryObjective> cropCategoryObjective = cropCategoryObjectiveRepository.findById(cropCategoryObjectiveID);

        if (cropCategoryObjective.isPresent()) {
            return cropCategoryObjectiveContentRepository.findByCropCategoryObjective_CropCategoryObjectiveID(cropCategoryObjectiveID);
        } else {
            throw new RuntimeException("Crop category objective not found with ID " + cropCategoryObjectiveID);
        }
    }

    // Get content by ID - NOT FROM GPT
    public Optional<CropCategoryObjectiveContent> getCropCategoryObjectiveContentByID(int cropCategoryObjectiveContentID) {
        return cropCategoryObjectiveContentRepository.findById(cropCategoryObjectiveContentID);
    }

    // Update content by ID
    public CropCategoryObjectiveContent updateCropCategoryObjectiveContent(int cropCategoryObjectiveContentID, CropCategoryObjectiveContentDTO cropCategoryObjectiveContentDTO) {
        Optional<CropCategoryObjectiveContent> existingCropCategoryObjectiveContent = cropCategoryObjectiveContentRepository.findById(cropCategoryObjectiveContentID);
        if (existingCropCategoryObjectiveContent.isPresent()) {
            CropCategoryObjectiveContent cropCategoryObjectiveContent = existingCropCategoryObjectiveContent.get();

            Optional<CropCategoryObjective> cropCategoryObjective = cropCategoryObjectiveRepository.findById(cropCategoryObjectiveContentDTO.getCropCategoryObjectiveID());
            if (cropCategoryObjective.isPresent()) {
                cropCategoryObjectiveContent.setTitle(cropCategoryObjectiveContentDTO.getTitle());
                cropCategoryObjectiveContent.setContent(cropCategoryObjectiveContentDTO.getContent());
                cropCategoryObjectiveContent.setPicUrl(cropCategoryObjectiveContentDTO.getPicUrl());
                cropCategoryObjectiveContent.setVidUrl(cropCategoryObjectiveContentDTO.getVidUrl());
                cropCategoryObjectiveContent.setCropCategoryObjective(cropCategoryObjective.get());

                return cropCategoryObjectiveContentRepository.save(cropCategoryObjectiveContent);
            } else {
                throw new RuntimeException("Crop category objective not found with ID " + cropCategoryObjectiveContentDTO.getCropCategoryObjectiveID());
            }
        } else {
            throw new RuntimeException("Crop content not found with ID " + cropCategoryObjectiveContentID);
        }
    }

    // Delete content by ID
    public void deleteCropCategoryObjectiveContent(int cropCategoryObjectiveContentID) {
        if (cropCategoryObjectiveContentRepository.existsById(cropCategoryObjectiveContentID)) {
            cropCategoryObjectiveContentRepository.deleteById(cropCategoryObjectiveContentID);
        } else {
            throw new RuntimeException("Crop content not found with ID " + cropCategoryObjectiveContentID);
        }
    }

}
