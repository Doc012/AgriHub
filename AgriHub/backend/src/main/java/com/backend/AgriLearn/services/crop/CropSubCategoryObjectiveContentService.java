package com.backend.AgriLearn.services.crop;

import com.backend.AgriLearn.dtos.crop.CropSubCategoryObjectiveContentDTO;
import com.backend.AgriLearn.entities.crop.CropSubCategoryObjective;
import com.backend.AgriLearn.entities.crop.CropSubCategoryObjectiveContent;
import com.backend.AgriLearn.repositories.crop.CropSubCategoryObjectiveContentRepository;
import com.backend.AgriLearn.repositories.crop.CropSubCategoryObjectiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CropSubCategoryObjectiveContentService {

    @Autowired
    private CropSubCategoryObjectiveContentRepository cropSubCategoryObjectiveContentRepository;

    @Autowired
    private CropSubCategoryObjectiveRepository cropSubCategoryObjectiveRepository;

    // Create a new content
    public CropSubCategoryObjectiveContent createCropSubCategoryObjectiveContent(CropSubCategoryObjectiveContentDTO cropSubCategoryObjectiveContentDTO) {
        Optional<CropSubCategoryObjective> cropSubCategoryObjective = cropSubCategoryObjectiveRepository.findById(cropSubCategoryObjectiveContentDTO.getCropSubCategoryObjectiveID());
        if (cropSubCategoryObjective.isPresent()) {
            CropSubCategoryObjectiveContent cropSubCategoryObjectiveContent = new CropSubCategoryObjectiveContent();

            cropSubCategoryObjectiveContent.setTitle(cropSubCategoryObjectiveContentDTO.getTitle());
            cropSubCategoryObjectiveContent.setContent(cropSubCategoryObjectiveContentDTO.getContent());
            cropSubCategoryObjectiveContent.setPicUrl(cropSubCategoryObjectiveContentDTO.getPicUrl());
            cropSubCategoryObjectiveContent.setVidUrl(cropSubCategoryObjectiveContentDTO.getVidUrl());
            cropSubCategoryObjectiveContent.setCropSubCategoryObjective(cropSubCategoryObjective.get());

            return cropSubCategoryObjectiveContentRepository.save(cropSubCategoryObjectiveContent);
        } else {
            throw new RuntimeException("Crop sub-category objective not found with ID " + cropSubCategoryObjectiveContentDTO.getCropSubCategoryObjectiveID());
        }
    }

    // Get all contents
    public List<CropSubCategoryObjectiveContent> getAllCropSubCategoryObjectiveContents() {
        return cropSubCategoryObjectiveContentRepository.findAll();
    }

    // Get content by objective ID
    public List<CropSubCategoryObjectiveContent> getCropSubCategoryObjectiveContentsByCropSubCategoryObjective(int cropSubCategoryObjectiveID) {
        Optional<CropSubCategoryObjective> cropSubCategoryObjective = cropSubCategoryObjectiveRepository.findById(cropSubCategoryObjectiveID);

        if (cropSubCategoryObjective.isPresent()) {
            return cropSubCategoryObjectiveContentRepository.findByCropSubCategoryObjective_CropSubCategoryObjectiveID(cropSubCategoryObjectiveID);
        } else {
            throw new RuntimeException("Crop sub-category objective not found with ID " + cropSubCategoryObjectiveID);
        }
    }

    // Get content by ID
    public Optional<CropSubCategoryObjectiveContent> getCropSubCategoryObjectiveContentByID(int cropSubCategoryObjectiveContentID) {
        return cropSubCategoryObjectiveContentRepository.findById(cropSubCategoryObjectiveContentID);
    }

    // Update existing content
    public CropSubCategoryObjectiveContent updateCropSubCategoryObjectiveContent(int cropSubCategoryObjectiveContentID, CropSubCategoryObjectiveContentDTO cropSubCategoryObjectiveContentDTO) {
        Optional<CropSubCategoryObjectiveContent> existingCropSubCategoryObjectiveContent = cropSubCategoryObjectiveContentRepository.findById(cropSubCategoryObjectiveContentID);
        if (existingCropSubCategoryObjectiveContent.isPresent()) {
            CropSubCategoryObjectiveContent cropSubCategoryObjectiveContent = existingCropSubCategoryObjectiveContent.get();

            Optional<CropSubCategoryObjective> cropSubCategoryObjective = cropSubCategoryObjectiveRepository.findById(cropSubCategoryObjectiveContentDTO.getCropSubCategoryObjectiveID());
            if (cropSubCategoryObjective.isPresent()) {
                cropSubCategoryObjectiveContent.setTitle(cropSubCategoryObjectiveContentDTO.getTitle());
                cropSubCategoryObjectiveContent.setContent(cropSubCategoryObjectiveContentDTO.getContent());
                cropSubCategoryObjectiveContent.setPicUrl(cropSubCategoryObjectiveContentDTO.getPicUrl());
                cropSubCategoryObjectiveContent.setVidUrl(cropSubCategoryObjectiveContentDTO.getVidUrl());
                cropSubCategoryObjectiveContent.setCropSubCategoryObjective(cropSubCategoryObjective.get());

                return cropSubCategoryObjectiveContentRepository.save(cropSubCategoryObjectiveContent);
            } else {
                throw new RuntimeException("Crop sub-category objective not found with ID " + cropSubCategoryObjectiveContentDTO.getCropSubCategoryObjectiveID());
            }
        } else {
            throw new RuntimeException("Content not found with ID " + cropSubCategoryObjectiveContentID);
        }
    }

    // Delete content
    public void deleteCropSubCategoryObjectiveContent(int cropSubCategoryObjectiveContentID) {
        if (cropSubCategoryObjectiveContentRepository.existsById(cropSubCategoryObjectiveContentID)) {
            cropSubCategoryObjectiveContentRepository.deleteById(cropSubCategoryObjectiveContentID);
        } else {
            throw new RuntimeException("Content not found with ID " + cropSubCategoryObjectiveContentID);
        }
    }
}
