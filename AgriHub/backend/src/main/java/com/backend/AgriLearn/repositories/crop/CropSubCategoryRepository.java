package com.backend.AgriLearn.repositories.crop;

import com.backend.AgriLearn.entities.crop.CropCategory;
import com.backend.AgriLearn.entities.crop.CropSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CropSubCategoryRepository extends JpaRepository<CropSubCategory, Integer> {
    List<CropSubCategory> findByCropCategory_CropCategoryID(Integer cropCategoryID);
}
