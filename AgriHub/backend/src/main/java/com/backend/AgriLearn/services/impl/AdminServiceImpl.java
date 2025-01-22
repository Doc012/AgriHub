package com.backend.AgriLearn.services.impl;

import com.backend.AgriLearn.entities.crop.CropCategory;
import com.backend.AgriLearn.entities.crop.CropCategoryObjective;
import com.backend.AgriLearn.entities.crop.CropCategoryObjectiveContent;
import com.backend.AgriLearn.entities.crop.CropSubCategory;
import com.backend.AgriLearn.entities.livestock.LivestockCategory;
import com.backend.AgriLearn.entities.livestock.LivestockCategoryObjective;
import com.backend.AgriLearn.entities.livestock.LivestockCategoryObjectiveContent;
import com.backend.AgriLearn.entities.livestock.LivestockSubCategory;
import com.backend.AgriLearn.repositories.crop.CropCategoryObjectiveContentRepository;
import com.backend.AgriLearn.repositories.crop.CropCategoryObjectiveRepository;
import com.backend.AgriLearn.repositories.crop.CropCategoryRepository;
import com.backend.AgriLearn.repositories.crop.CropSubCategoryRepository;
import com.backend.AgriLearn.repositories.livestock.LivestockCategoryObjectiveContentRepository;
import com.backend.AgriLearn.repositories.livestock.LivestockCategoryObjectiveRepository;
import com.backend.AgriLearn.repositories.livestock.LivestockCategoryRepository;
import com.backend.AgriLearn.repositories.livestock.LivestockSubCategoryRepository;
import com.backend.AgriLearn.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private CropCategoryRepository cropCategoryRepo;
    @Autowired
    private CropSubCategoryRepository cropSubCategoryRepo;
    @Autowired
    private CropCategoryObjectiveRepository cropCategoryObjectiveRepo;
    @Autowired
    private CropCategoryObjectiveContentRepository cropCategoryObjectiveContentRepo;

    @Autowired
    private LivestockCategoryRepository livestockCategoryRepo;
    @Autowired
    private LivestockSubCategoryRepository livestockSubCategoryRepo;
    @Autowired
    private LivestockCategoryObjectiveRepository livestockCategoryObjectiveRepo;
    @Autowired
    private LivestockCategoryObjectiveContentRepository livestockCategoryObjectiveContentRepo;

    // Crop Category Methods
    @Override
    public CropCategory createCropCategory(CropCategory cropCategory) {
        return cropCategoryRepo.save(cropCategory);
    }

    @Override
    public List<CropCategory> getAllCropCategories() {
        return cropCategoryRepo.findAll();
    }

    @Override
    public CropCategory updateCropCategory(CropCategory cropCategory) {
        return cropCategoryRepo.save(cropCategory);
    }

    @Override
    public void deleteCropCategory(Long categoryId) {
        cropCategoryRepo.deleteById(categoryId);
    }

    // Crop SubCategory Methods
    @Override
    public CropSubCategory createCropSubCategory(CropSubCategory cropSubCategory) {
        return cropSubCategoryRepo.save(cropSubCategory);
    }

    @Override
    public List<CropSubCategory> getAllCropSubCategories() {
        return cropSubCategoryRepo.findAll();
    }

    @Override
    public CropSubCategory updateCropSubCategory(CropSubCategory cropSubCategory) {
        return cropSubCategoryRepo.save(cropSubCategory);
    }

    @Override
    public void deleteCropSubCategory(Long subCategoryId) {
        cropSubCategoryRepo.deleteById(subCategoryId);
    }

    // Crop Objective Methods
    @Override
    public CropCategoryObjective createCropCategoryObjective(CropCategoryObjective cropCategoryObjective) {
        return cropCategoryObjectiveRepo.save(cropCategoryObjective);
    }

    @Override
    public List<CropCategoryObjective> getAllCropCategoryObjectives() {
        return cropCategoryObjectiveRepo.findAll();
    }

    @Override
    public CropCategoryObjective updateCropCategoryObjective(CropCategoryObjective cropCategoryObjective) {
        return cropCategoryObjectiveRepo.save(cropCategoryObjective);
    }

    @Override
    public void deleteCropCategoryObjective(Long objectiveId) {
        cropCategoryObjectiveRepo.deleteById(objectiveId);
    }

    // Crop Content Methods
    @Override
    public CropCategoryObjectiveContent createCropCategoryObjectiveContent(CropCategoryObjectiveContent content) {
        return cropCategoryObjectiveContentRepo.save(content);
    }

    @Override
    public List<CropCategoryObjectiveContent> getAllCropCategoryObjectiveContents() {
        return cropCategoryObjectiveContentRepo.findAll();
    }

    @Override
    public CropCategoryObjectiveContent updateCropCategoryObjectiveContent(CropCategoryObjectiveContent content) {
        return cropCategoryObjectiveContentRepo.save(content);
    }

    @Override
    public void deleteCropCategoryObjectiveContent(Long contentId) {
        cropCategoryObjectiveContentRepo.deleteById(contentId);
    }

    // Livestock Category Methods
    @Override
    public LivestockCategory createLivestockCategory(LivestockCategory livestockCategory) {
        return livestockCategoryRepo.save(livestockCategory);
    }

    @Override
    public List<LivestockCategory> getAllLivestockCategories() {
        return livestockCategoryRepo.findAll();
    }

    @Override
    public LivestockCategory updateLivestockCategory(LivestockCategory livestockCategory) {
        return livestockCategoryRepo.save(livestockCategory);
    }

    @Override
    public void deleteLivestockCategory(Long categoryId) {
        livestockCategoryRepo.deleteById(categoryId);
    }

    // Livestock SubCategory Methods
    @Override
    public LivestockSubCategory createLivestockSubCategory(LivestockSubCategory livestockSubCategory) {
        return livestockSubCategoryRepo.save(livestockSubCategory);
    }

    @Override
    public List<LivestockSubCategory> getAllLivestockSubCategories() {
        return livestockSubCategoryRepo.findAll();
    }

    @Override
    public LivestockSubCategory updateLivestockSubCategory(LivestockSubCategory livestockSubCategory) {
        return livestockSubCategoryRepo.save(livestockSubCategory);
    }

    @Override
    public void deleteLivestockSubCategory(Long subCategoryId) {
        livestockSubCategoryRepo.deleteById(subCategoryId);
    }

    // Livestock Objective Methods
    @Override
    public LivestockCategoryObjective createLivestockCategoryObjective(LivestockCategoryObjective livestockCategoryObjective) {
        return livestockCategoryObjectiveRepo.save(livestockCategoryObjective);
    }

    @Override
    public List<LivestockCategoryObjective> getAllLivestockCategoryObjectives() {
        return livestockCategoryObjectiveRepo.findAll();
    }

    @Override
    public LivestockCategoryObjective updateLivestockCategoryObjective(LivestockCategoryObjective livestockCategoryObjective) {
        return livestockCategoryObjectiveRepo.save(livestockCategoryObjective);
    }

    @Override
    public void deleteLivestockCategoryObjective(Long objectiveId) {
        livestockCategoryObjectiveRepo.deleteById(objectiveId);
    }

    // Livestock Content Methods
    @Override
    public LivestockCategoryObjectiveContent createLivestockCategoryObjectiveContent(LivestockCategoryObjectiveContent content) {
        return livestockCategoryObjectiveContentRepo.save(content);
    }

    @Override
    public List<LivestockCategoryObjectiveContent> getAllLivestockCategoryObjectiveContents() {
        return livestockCategoryObjectiveContentRepo.findAll();
    }

    @Override
    public LivestockCategoryObjectiveContent updateLivestockCategoryObjectiveContent(LivestockCategoryObjectiveContent content) {
        return livestockCategoryObjectiveContentRepo.save(content);
    }

    @Override
    public void deleteLivestockCategoryObjectiveContent(Long contentId) {
        livestockCategoryObjectiveContentRepo.deleteById(contentId);
    }
}

