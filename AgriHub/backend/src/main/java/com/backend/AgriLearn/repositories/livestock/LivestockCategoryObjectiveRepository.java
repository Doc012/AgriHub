package com.backend.AgriLearn.repositories.livestock;

import com.backend.AgriLearn.entities.livestock.LivestockCategoryObjective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivestockCategoryObjectiveRepository extends JpaRepository<LivestockCategoryObjective, Integer> {
    List<LivestockCategoryObjective> findByLivestockCategory_LivestockCategoryID(Integer livestockCategoryID);
}
