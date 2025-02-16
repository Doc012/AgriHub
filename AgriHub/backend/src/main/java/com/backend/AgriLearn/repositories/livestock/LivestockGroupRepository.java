package com.backend.AgriLearn.repositories.livestock;

import com.backend.AgriLearn.entities.livestock.LivestockGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivestockGroupRepository extends JpaRepository<LivestockGroup, Integer> {
    List<LivestockGroup> findByLivestockCategory_LivestockCategoryID(int livestockCategoryID);
}
