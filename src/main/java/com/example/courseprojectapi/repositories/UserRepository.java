package com.example.courseprojectapi.repositories;

import com.example.courseprojectapi.models.RoleModel;
import com.example.courseprojectapi.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserModel,Long> {
    UserModel findByUsername(String username);
    Iterable<UserModel> findAllByRoleRoleName(String role_roleName);

    List<UserModel> findAll();

    UserModel findByRole(RoleModel role);
}
