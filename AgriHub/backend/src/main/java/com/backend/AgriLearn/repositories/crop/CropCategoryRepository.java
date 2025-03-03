package com.backend.AgriLearn.repositories.crop;

import com.backend.AgriLearn.entities.crop.CropCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CropCategoryRepository extends JpaRepository<CropCategory, Integer> {
    List<CropCategory> findByDistrict_DistrictID(Integer districtID);
}
