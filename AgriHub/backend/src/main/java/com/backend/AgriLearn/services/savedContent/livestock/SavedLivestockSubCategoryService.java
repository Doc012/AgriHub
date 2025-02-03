package com.backend.AgriLearn.services.savedContent.livestock;

import com.backend.AgriLearn.dtos.saveContent.livestock.SavedLivestockSubCategoryDTO;
import com.backend.AgriLearn.entities.livestock.LivestockSubCategory;
import com.backend.AgriLearn.entities.savedContent.livestock.SavedLivestockSubCategory;
import com.backend.AgriLearn.repositories.livestock.LivestockSubCategoryRepository;
import com.backend.AgriLearn.repositories.savedContent.livestock.SavedLivestockSubCategoryRepository;
import com.backend.User.entities.User;
import com.backend.User.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class SavedLivestockSubCategoryService {

    @Autowired
    private SavedLivestockSubCategoryRepository savedLivestockSubCategoryRepository;

    @Autowired
    private LivestockSubCategoryRepository livestockSubCategoryRepository;

    @Autowired
    private UserRepository userRepository;

    public SavedLivestockSubCategory saveSavedLivestockSubCategory(SavedLivestockSubCategoryDTO dto) {
        Optional<User> user = userRepository.findById(dto.getUserID());
        Optional<LivestockSubCategory> livestockSubCategory = livestockSubCategoryRepository.findById(dto.getLivestockSubCategoryID());

        if (user.isEmpty() && livestockSubCategory.isEmpty()) {
            throw new IllegalArgumentException("User or livestock SubCategory not found.");
        }

        Optional<SavedLivestockSubCategory> existingSaved = savedLivestockSubCategoryRepository.findByUser_UserIDAndLivestockSubCategory_LivestockSubCategoryID(dto.getUserID(), dto.getLivestockSubCategoryID());
        if (existingSaved.isPresent()) {
            throw new IllegalArgumentException("This Crop SubCategory is already saved by the user.");
        }

        SavedLivestockSubCategory savedLivestockSubCategory = new SavedLivestockSubCategory(
                user.get(),
                livestockSubCategory.get(),
                dto.getPicUrl()
        );

        return savedLivestockSubCategoryRepository.save(savedLivestockSubCategory);
    }

    public List<SavedLivestockSubCategory> getAllSavedLivestockSubCategories() {
        return savedLivestockSubCategoryRepository.findAll();
    }

    public void deleteSavedLivestockSubCategory(int id) {
        if (!savedLivestockSubCategoryRepository.existsById(id)) {
            throw new IllegalArgumentException("SavedCropSubCategory not found.");
        }
        savedLivestockSubCategoryRepository.deleteById(id);
    }












}
