package com.backend.AgriLearn.repositories.crop;

import com.backend.AgriLearn.entities.crop.CropSubCategoryObjective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropSubCategoryObjectiveRepository extends JpaRepository<CropSubCategoryObjective, Long> {
}
