package com.backend.AgriLearn.repositories.crop;

import com.backend.AgriLearn.entities.crop.CropGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CropGroupRepository extends JpaRepository<CropGroup, Integer> {
    List<CropGroup> findByCropCategory_CropCategoryID(int cropCategoryID);
}
