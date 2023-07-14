package com.learn.student.userdetails.getroleapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<Object> getRoleNameById(@PathVariable("id") int id) {
        String roleName = roleService.getRoleNameById(id);
        if (!roleName.equals("Invalid ID")) {
            // Return the role name
            return ResponseEntity.ok(roleName);
        } else {
            // Invalid ID
            return ResponseEntity.status(HttpStatus.OK).body("Invalid ID");
        }
    }
}


