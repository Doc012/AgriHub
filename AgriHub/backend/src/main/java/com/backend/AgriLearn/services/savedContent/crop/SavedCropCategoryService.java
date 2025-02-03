package com.backend.AgriLearn.services.savedContent.crop;

import com.backend.AgriLearn.dtos.saveContent.crop.SavedCropCategoryDTO;
import com.backend.AgriLearn.entities.crop.CropCategory;
import com.backend.AgriLearn.entities.savedContent.crop.SavedCropCategory;
import com.backend.AgriLearn.repositories.crop.CropCategoryRepository;
import com.backend.AgriLearn.repositories.savedContent.crop.SavedCropCategoryRepository;
import com.backend.User.entities.User;
import com.backend.User.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavedCropCategoryService {

    @Autowired
    private SavedCropCategoryRepository savedCropCategoryRepository;

    @Autowired
    private CropCategoryRepository cropCategoryRepository;

    @Autowired
    private UserRepository userRepository;

    // Save crop category
    public SavedCropCategory saveSavedCropCategory(SavedCropCategoryDTO dto) {
        Optional<User> user = userRepository.findById(dto.getUserID());
        Optional<CropCategory> cropCategory = cropCategoryRepository.findById(dto.getCropCategoryID());

        if (user.isEmpty() && cropCategory.isEmpty()) { // I removed '||' operator
            throw new IllegalArgumentException("User or crop Category not found.");
        }

        if (savedCropCategoryRepository.existsByUser_UserIDAndCropCategory_CropCategoryID(dto.getUserID(), dto.getCropCategoryID())) {
            throw new IllegalArgumentException("This category is already saved.");
        }

        SavedCropCategory savedCropCategory = new SavedCropCategory(
                user.get(),
                cropCategory.get(),
                dto.getPicUrl()
        );

        return savedCropCategoryRepository.save(savedCropCategory);
    }

    // Get all saved crop categories
    public List<SavedCropCategory> getAllSavedCropCategories() {
        return savedCropCategoryRepository.findAll();
    }

    // Delete saved crop categories
    public void deleteSavedCropCategory(int id) {
        if (!savedCropCategoryRepository.existsById(id)) {
            throw new IllegalArgumentException("Saved crop category not found.");
        }

        savedCropCategoryRepository.deleteById(id);
    }

}
