package com.example.courseprojectapi.repositories;

import com.example.courseprojectapi.models.ApplicationStatusModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationStatusRepository extends CrudRepository<ApplicationStatusModel, Long> {
    ApplicationStatusModel findApplicationStatusModelByName(String name);
}
