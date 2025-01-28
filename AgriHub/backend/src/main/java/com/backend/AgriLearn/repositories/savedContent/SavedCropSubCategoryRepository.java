package com.backend.AgriLearn.repositories.savedContent;

import com.backend.AgriLearn.entities.savedContent.SavedCropSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SavedCropSubCategoryRepository extends JpaRepository<SavedCropSubCategory, Integer> {
    Optional<SavedCropSubCategory> findByUser_UserIDAndCropSubCategory_CropSubCategoryID(int userDTO, int cropSubCategoryID);
}
