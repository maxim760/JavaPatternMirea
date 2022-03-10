package com.example.task19.controller;

import com.example.task19.DTO.User;
import com.example.task19.Response.ErrorResponse;
import com.example.task19.Response.SuccessResponse;
import com.example.task19.entity.DogEntity;
import com.example.task19.entity.UserEntity;
import com.example.task19.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity getAll(
        @RequestParam(name = "firstName", defaultValue = "", required = false) String firstName,
        @RequestParam(name = "lastName", defaultValue = "", required = false) String lastName
    ) {
        try {
            return ResponseEntity.ok(
                new SuccessResponse<>(User.toDTO(userService.filterByFields(firstName, lastName)))
            );
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity addOne(@RequestBody UserEntity user) {
        try {
            UserEntity newUser = userService.addUser(user);
            return ResponseEntity.ok(new SuccessResponse<>(User.toDTO(newUser)));
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }
    @PostMapping("/dog/{id}")
    public ResponseEntity addDog(@PathVariable Long id, @RequestBody DogEntity dog) {
        try {
            UserEntity user = userService.addDogToUser(id, dog);
            return ResponseEntity.ok(new SuccessResponse<>(User.toDTO(user)));
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }

}
