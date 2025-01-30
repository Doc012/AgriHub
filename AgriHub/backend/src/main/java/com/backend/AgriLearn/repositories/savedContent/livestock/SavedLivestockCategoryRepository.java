package com.backend.AgriLearn.repositories.savedContent.livestock;

import com.backend.AgriLearn.entities.savedContent.livestock.SavedLivestockCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavedLivestockCategoryRepository extends JpaRepository<SavedLivestockCategory, Integer> {
    boolean existsByUser_UserIDAndLivestockCategory_LivestockCategoryID(int userID, int livestockCategoryID);
}
