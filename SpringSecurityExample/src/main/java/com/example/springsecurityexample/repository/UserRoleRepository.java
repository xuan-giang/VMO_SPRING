package com.example.springsecurityexample.repository;

import com.example.springsecurityexample.model.User_Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<User_Role, Long> {
}
