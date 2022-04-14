package com.example.springsecurityexample.repository;

import com.example.springsecurityexample.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
