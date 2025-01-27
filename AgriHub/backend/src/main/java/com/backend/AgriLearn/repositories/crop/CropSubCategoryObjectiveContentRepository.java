package com.backend.AgriLearn.repositories.crop;

import com.backend.AgriLearn.entities.crop.CropSubCategoryObjectiveContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CropSubCategoryObjectiveContentRepository extends JpaRepository<CropSubCategoryObjectiveContent, Integer> {

    List<CropSubCategoryObjectiveContent> findByCropSubCategoryObjective_CropSubCategoryObjectiveID(Integer cropSubCategoryObjectiveID);
}
