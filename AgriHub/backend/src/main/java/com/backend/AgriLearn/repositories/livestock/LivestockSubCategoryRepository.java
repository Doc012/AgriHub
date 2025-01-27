package com.backend.AgriLearn.repositories.livestock;

import com.backend.AgriLearn.entities.livestock.LivestockSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivestockSubCategoryRepository extends JpaRepository<LivestockSubCategory, Integer> {
    List<LivestockSubCategory> findByLivestockCategory_LivestockCategoryID(Integer livestockCategoryID);
}
