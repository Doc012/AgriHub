package com.backend.AgriLearn.services.savedContent.crop;

import com.backend.AgriLearn.dtos.saveContent.crop.SavedCropSubCategoryDTO;
import com.backend.AgriLearn.entities.crop.CropSubCategory;
import com.backend.AgriLearn.entities.savedContent.crop.SavedCropSubCategory;
import com.backend.AgriLearn.repositories.crop.CropSubCategoryRepository;
import com.backend.AgriLearn.repositories.savedContent.crop.SavedCropSubCategoryRepository;
import com.backend.User.entities.User;
import com.backend.User.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavedCropSubCategoryService {

    @Autowired
    private SavedCropSubCategoryRepository savedCropSubCategoryRepository;

    @Autowired
    private CropSubCategoryRepository cropSubCategoryRepository;

    @Autowired
    private UserRepository userRepository;

    public SavedCropSubCategory saveSavedCropSubCategory(SavedCropSubCategoryDTO dto) {
        Optional<User> user = userRepository.findById(dto.getUserID());
        Optional<CropSubCategory> cropSubCategory = cropSubCategoryRepository.findById(dto.getCropSubCategoryID());

        if (user.isEmpty() && cropSubCategory.isEmpty()) {
            throw new IllegalArgumentException("User or Crop SubCategory not found.");
        }

        // Check if the sub-category is already saved by the user
        Optional<SavedCropSubCategory> existingSaved = savedCropSubCategoryRepository.findByUser_UserIDAndCropSubCategory_CropSubCategoryID(dto.getUserID(), dto.getCropSubCategoryID());
        if (existingSaved.isPresent()) {
            throw new IllegalArgumentException("This Crop SubCategory is already saved by the user.");
        }

        SavedCropSubCategory savedCropSubCategory = new SavedCropSubCategory(
                user.get(),
                cropSubCategory.get(),
                dto.getPicUrl()
        );

        return savedCropSubCategoryRepository.save(savedCropSubCategory);
    }

    public List<SavedCropSubCategory> getAllSavedCropSubCategories() {
        return savedCropSubCategoryRepository.findAll();
    }

    public void deleteSavedCropSubCategory(int id) {
        if (!savedCropSubCategoryRepository.existsById(id)) {
            throw new IllegalArgumentException("SavedCropSubCategory not found.");
        }
        savedCropSubCategoryRepository.deleteById(id);
    }
}
