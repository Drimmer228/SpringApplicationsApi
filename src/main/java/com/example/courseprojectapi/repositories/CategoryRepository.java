package com.example.courseprojectapi.repositories;

import com.example.courseprojectapi.models.AppCategoryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<AppCategoryModel, Long> {
}
