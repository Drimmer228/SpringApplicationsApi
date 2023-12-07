package com.example.courseprojectapi.repositories;

import com.example.courseprojectapi.models.AppCategoryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppCategoryRepository extends CrudRepository<AppCategoryModel, Long> {
}
