package com.backend.AgriLearn.repositories.crop;

import com.backend.AgriLearn.entities.crop.CropSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropSubCategoryRepository extends JpaRepository<CropSubCategory, Long> {
}
