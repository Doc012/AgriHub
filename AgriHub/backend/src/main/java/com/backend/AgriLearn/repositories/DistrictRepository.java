package com.backend.AgriLearn.repositories;

import com.backend.AgriLearn.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {
    List<District> findByProvince_ProvinceID(int province);
}
