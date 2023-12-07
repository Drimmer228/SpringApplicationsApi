package com.example.courseprojectapi.repositories;

import com.example.courseprojectapi.models.ApplicationModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends CrudRepository<ApplicationModel,Long>{
    ApplicationModel findByPublisherId(Long publisher_id);
    ApplicationModel findApplicationModelById(Long id);
    List<ApplicationModel> findAllByPublisherId(Long publisher_id);
    List<ApplicationModel> findAllByPublisherRoleRoleName(String publisher_role_roleName);
    @Query("SELECT DISTINCT u.username FROM ApplicationModel a inner join UserModel u on a.publisher.id = u.id")
    List<String> findDistinctPublisherIds();
}
