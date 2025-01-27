package com.backend.AgriLearn.repositories.savedContent;

import com.backend.AgriLearn.entities.savedContent.SavedSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavedSubCategoryRepository extends JpaRepository<SavedSubCategory, Integer> {
}
