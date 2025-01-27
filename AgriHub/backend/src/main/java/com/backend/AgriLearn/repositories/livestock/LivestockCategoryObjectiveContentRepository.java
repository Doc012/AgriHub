package com.backend.AgriLearn.repositories.livestock;

import com.backend.AgriLearn.entities.livestock.LivestockCategoryObjectiveContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivestockCategoryObjectiveContentRepository extends JpaRepository<LivestockCategoryObjectiveContent, Integer> {
}
