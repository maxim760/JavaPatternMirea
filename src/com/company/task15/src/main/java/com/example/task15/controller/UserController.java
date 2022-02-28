package com.example.task15.controller;

import com.example.task15.entity.UserEntity;
import com.example.task15.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(userService.getUsers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка" + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity addOne(@RequestBody UserEntity user) {
        try {
            System.out.println(user.getFirstName());
            System.out.println(user.getLastName());
            userService.addUser(user);
            return ResponseEntity.ok("Добавлено");
        } catch(Exception e) {
            return ResponseEntity.badRequest().body("Ошибка" + e.getMessage());
        }
    }
}
