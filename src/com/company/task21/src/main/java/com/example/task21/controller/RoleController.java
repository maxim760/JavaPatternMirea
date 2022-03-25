package com.example.task21.controller;

import com.example.task21.DTO.User;
import com.example.task21.Response.ErrorResponse;
import com.example.task21.Response.SuccessResponse;
import com.example.task21.entity.RoleEntity;
import com.example.task21.entity.UserEntity;
import com.example.task21.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity addRole(@RequestBody RoleEntity role) {
        try {
            RoleEntity newRole = roleService.addRole(role).get();
            return ResponseEntity.ok(new SuccessResponse<>(newRole));
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity getRoles() {
        try {
            List<RoleEntity> roles = roleService.getRoles().get();
            return ResponseEntity.ok(new SuccessResponse<>(roles));
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }
}
