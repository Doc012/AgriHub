package com.backend.AgriLearn.repositories.crop;

import com.backend.AgriLearn.entities.crop.CropCategoryObjective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CropCategoryObjectiveRepository extends JpaRepository<CropCategoryObjective, Integer> {
    List<CropCategoryObjective> findByCropCategory_CropCategoryID(Integer cropCategoryID);
}
