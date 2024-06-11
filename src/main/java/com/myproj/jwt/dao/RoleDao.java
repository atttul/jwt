package com.myproj.jwt.dao;

import com.myproj.jwt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, String> {

}
