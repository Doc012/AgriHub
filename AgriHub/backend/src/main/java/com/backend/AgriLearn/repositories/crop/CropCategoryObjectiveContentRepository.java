package com.backend.AgriLearn.repositories.crop;

import com.backend.AgriLearn.entities.crop.CropCategoryObjectiveContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CropCategoryObjectiveContentRepository extends JpaRepository<CropCategoryObjectiveContent, Integer> {
    List<CropCategoryObjectiveContent> findByCropCategoryObjective_CropCategoryObjectiveID(Integer cropCategoryObjectiveID);
}
