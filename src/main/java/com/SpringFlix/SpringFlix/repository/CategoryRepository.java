package com.SpringFlix.SpringFlix.repository;

import com.SpringFlix.SpringFlix.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel,Long> {
}
