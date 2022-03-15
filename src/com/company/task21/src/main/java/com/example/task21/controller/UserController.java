package com.example.task21.controller;

import com.example.task21.DTO.User;
import com.example.task21.Response.ErrorResponse;
import com.example.task21.Response.SuccessResponse;
import com.example.task21.entity.DogEntity;
import com.example.task21.entity.UserEntity;
import com.example.task21.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
            List<UserEntity> users = userService.filterByFields(firstName, lastName).get();

            return ResponseEntity.ok(
                new SuccessResponse<>(User.toDTO(users))
            );
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity addOne(@RequestBody UserEntity user) {
        try {
            UserEntity newUser = userService.addUser(user).get();
            return ResponseEntity.ok(new SuccessResponse<>(User.toDTO(newUser)));
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }
    @PostMapping("/dog/{id}")
    public ResponseEntity addDog(@PathVariable Long id, @RequestBody DogEntity dog) {
        try {
            UserEntity user = userService.addDogToUser(id, dog).get();
            return ResponseEntity.ok(new SuccessResponse<>(User.toDTO(user)));
        } catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }

}
