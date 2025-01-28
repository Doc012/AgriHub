package com.backend.AgriLearn.repositories.savedContent;

import com.backend.AgriLearn.entities.savedContent.SavedCropCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavedCropCategoryRepository extends JpaRepository<SavedCropCategory, Integer> {
    boolean existsByUser_UserIDAndCropCategory_CropCategoryID(int userID, int cropCategoryID);


}
