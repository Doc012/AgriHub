package com.backend.AgriLearn.repositories.livestock;

import com.backend.AgriLearn.entities.livestock.LivestockSubCategoryObjective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivestockSubCategoryObjectiveRepository extends JpaRepository<LivestockSubCategoryObjective, Integer> {
    List<LivestockSubCategoryObjective> findByLivestockSubCategory_LivestockSubCategoryID(Integer livestockSubCategoryID);
}
