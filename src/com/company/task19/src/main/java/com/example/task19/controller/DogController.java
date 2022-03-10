package com.example.task19.controller;

import com.example.task19.DTO.Dog;
import com.example.task19.DTO.User;
import com.example.task19.Response.ErrorResponse;
import com.example.task19.Response.SuccessResponse;
import com.example.task19.entity.DogEntity;
import com.example.task19.entity.UserEntity;
import com.example.task19.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity getDog(@PathVariable("dogId") Long dogId){
        try {
            DogEntity dog = dogService.getDogById(dogId);
            return ResponseEntity.ok(new SuccessResponse<>(Dog.toDTO(dog)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }
}
