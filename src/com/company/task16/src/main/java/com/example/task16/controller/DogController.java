package com.example.task16.controller;

import com.example.task16.DTO.Dog;
import com.example.task16.DTO.User;
import com.example.task16.Response.ErrorResponse;
import com.example.task16.Response.SuccessResponse;
import com.example.task16.Service.DogService;
import com.example.task16.entity.DogEntity;
import com.example.task16.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dog")
public class DogController {

    @Autowired
    private DogService dogService;

    @GetMapping("/{dogId}/user")
    public ResponseEntity getDogUser(@PathVariable("dogId") Long dogId){
        try {
            UserEntity user = dogService.getUserByDog(dogId);
            return ResponseEntity.ok(new SuccessResponse<>(User.toDTO(user)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }
    @GetMapping("/{dogId}")
    public ResponseEntity getDog(@PathVariable("dogId") long dogId){
        try {
            DogEntity dog = dogService.getDogById(dogId);
            return ResponseEntity.ok(new SuccessResponse<>(Dog.toDTO(dog)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }
}
