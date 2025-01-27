package com.backend.AgriLearn.repositories.crop;

import com.backend.AgriLearn.entities.crop.CropCategory;
import com.backend.AgriLearn.entities.crop.CropSubCategory;
import com.backend.AgriLearn.entities.crop.CropSubCategoryObjective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CropSubCategoryObjectiveRepository extends JpaRepository<CropSubCategoryObjective, Integer> {
    List<CropSubCategoryObjective> findByCropSubCategory_CropSubCategoryID(Integer cropSubCategoryID);


}
