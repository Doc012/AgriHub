package com.backend.AgriLearn.repositories.livestock;

import com.backend.AgriLearn.entities.livestock.LivestockSubCategoryObjectiveContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivestockSubCategoryObjectiveContentRepository extends JpaRepository<LivestockSubCategoryObjectiveContent, Integer> {
    List<LivestockSubCategoryObjectiveContent> findByLivestockSubCategoryObjective_LivestockSubCategoryObjectiveID(Integer livestockSubCategoryObjectiveID);
}
