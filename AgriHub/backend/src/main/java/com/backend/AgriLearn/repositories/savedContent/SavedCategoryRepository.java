package com.backend.AgriLearn.repositories.savedContent;

import com.backend.AgriLearn.entities.savedContent.SavedCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavedCategoryRepository extends JpaRepository<SavedCategory, Integer> {
}
