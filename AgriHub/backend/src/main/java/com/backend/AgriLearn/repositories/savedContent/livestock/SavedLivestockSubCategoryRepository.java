package com.backend.AgriLearn.repositories.savedContent.livestock;

import com.backend.AgriLearn.entities.savedContent.livestock.SavedLivestockSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SavedLivestockSubCategoryRepository extends JpaRepository<SavedLivestockSubCategory, Integer> {
    Optional<SavedLivestockSubCategory> findByUser_UserIDAndLivestockSubCategory_LivestockSubCategoryID(int userDTO, int livestockSubCategoryID);
}
