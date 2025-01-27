package com.backend.AgriLearn.repositories.livestock;

import com.backend.AgriLearn.entities.livestock.LivestockCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivestockCategoryRepository extends JpaRepository<LivestockCategory, Integer> {
    List<LivestockCategory> findByLocation_LocationID(int locationID);
}
