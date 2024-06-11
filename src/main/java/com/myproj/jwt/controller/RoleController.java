package com.myproj.jwt.controller;

import com.myproj.jwt.entity.Role;
import com.myproj.jwt.security.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping()
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/createNewRole")
    public Role createNewRole(@RequestBody Role role) {
        return roleService.createNewRole(role);
    }

    @GetMapping("/role")
    public String getRole() {
        return "Role controller Get";
    }
}
