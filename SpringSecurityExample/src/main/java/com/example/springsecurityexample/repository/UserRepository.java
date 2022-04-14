package com.example.springsecurityexample.repository;

import com.example.springsecurityexample.model.Role_Projection;
import com.example.springsecurityexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Query(value = "select r.role_code roleCode from user u\r\n"
            + "join user_role ul on u.user_id = ul.user_id\r\n"
            + "join role r on ul.role_id = r.role_id\r\n"
            + "where u.user_id= :userId",nativeQuery = true)
    List<Role_Projection> getRoleOfUser(@Param("userId") Long userId);

}
