package com.backend.AgriLearn.repositories.livestock;

import com.backend.AgriLearn.entities.livestock.LivestockCategoryObjectiveContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivestockCategoryObjectiveContentRepository extends JpaRepository<LivestockCategoryObjectiveContent, Integer> {
    List<LivestockCategoryObjectiveContent> findByLivestockCategoryObjective_LivestockCategoryObjectiveID(Integer livestockCategoryObjectiveID);
}
