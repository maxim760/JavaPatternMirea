package com.example.task21.controller;

import com.example.task21.DTO.User;
import com.example.task21.Response.ErrorResponse;
import com.example.task21.Response.SuccessResponse;
import com.example.task21.entity.UserEntity;
import com.example.task21.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registerUser(@RequestBody UserEntity user) {
        try {
            System.out.println(user.getPassword());
            System.out.println(user.getFirstName());
            System.out.println(user.getFirstName());
            System.out.println(user.getLastName());
            System.out.println(user.getUsername());
            UserEntity newUser = userService.addUser(user).get();
            return ResponseEntity.ok(new SuccessResponse<>(User.toDTO(newUser)));
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }
}
