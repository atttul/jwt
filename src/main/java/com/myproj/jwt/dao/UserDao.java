package com.myproj.jwt.dao;

import com.myproj.jwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, String> {

    @Query(value = "Select role_id from user_role where user_id=?1", nativeQuery = true)
    String getRoles(String userId);
}

//private methods in an interface, must have a method body.