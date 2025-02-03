package com.backend.AgriLearn.services.savedContent.livestock;

import com.backend.AgriLearn.dtos.saveContent.livestock.SavedLivestockCategoryDTO;
import com.backend.AgriLearn.entities.livestock.LivestockCategory;
import com.backend.AgriLearn.entities.savedContent.livestock.SavedLivestockCategory;
import com.backend.AgriLearn.repositories.livestock.LivestockCategoryRepository;
import com.backend.AgriLearn.repositories.savedContent.livestock.SavedLivestockCategoryRepository;
import com.backend.User.entities.User;
import com.backend.User.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavedLivestockCategoryService {

    @Autowired
    private SavedLivestockCategoryRepository savedLivestockCategoryRepository;

    @Autowired
    private LivestockCategoryRepository livestockCategoryRepository;

    @Autowired
    private UserRepository userRepository;

    // Save livestock category
    public SavedLivestockCategory saveSavedLivestockCategory(SavedLivestockCategoryDTO dto) {
        Optional<User> user = userRepository.findById(dto.getUserID());
        Optional<LivestockCategory> livestockCategory = livestockCategoryRepository.findById(dto.getLivestockCategoryID());

        if (user.isEmpty() && livestockCategory.isEmpty()) {
            throw new IllegalArgumentException("User or livestock Category not found.");
        }

        if (savedLivestockCategoryRepository.existsByUser_UserIDAndLivestockCategory_LivestockCategoryID(dto.getUserID(), dto.getLivestockCategoryID())) {
            throw new IllegalArgumentException("This category is already saved.");
        }

        SavedLivestockCategory savedLivestockCategory = new SavedLivestockCategory(
                user.get(),
                livestockCategory.get(),
                dto.getPicUrl()
        );

        return savedLivestockCategoryRepository.save(savedLivestockCategory);
    }

    // Get all saved livestock categories
    public List<SavedLivestockCategory> getAllSavedLivestockCategories() {
        return savedLivestockCategoryRepository.findAll();
    }

    // Delete saved livestock categories
    public void deleteSavedLivestockCategory(int id){
        if (!savedLivestockCategoryRepository.existsById(id)) {
            throw new IllegalArgumentException("Saved livestock category not found.");
        }

        savedLivestockCategoryRepository.deleteById(id);
    }























}
