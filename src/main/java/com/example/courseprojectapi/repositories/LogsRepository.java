package com.example.courseprojectapi.repositories;

import com.example.courseprojectapi.models.LogModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsRepository extends CrudRepository<LogModel,Long> {
}
