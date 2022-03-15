package com.example.task21.controller;

import com.example.task21.DTO.Dog;
import com.example.task21.DTO.User;
import com.example.task21.Response.ErrorResponse;
import com.example.task21.Response.SuccessResponse;
import com.example.task21.entity.DogEntity;
import com.example.task21.entity.UserEntity;
import com.example.task21.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.ServerException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dog")
public class DogController {

    @Autowired
    private DogService dogService;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            List<DogEntity> dogs = dogService.getAll().get();
            return ResponseEntity.ok(new SuccessResponse<>(Dog.toDTO(dogs)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }
    @GetMapping("/{dogId}/user")
    public ResponseEntity getDogUser(@PathVariable("dogId") Long dogId){
        try {
            UserEntity user = dogService.getUserByDog(dogId).get();
            return ResponseEntity.ok(new SuccessResponse<>(User.toDTO(user)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }
    @GetMapping("/{dogId}")
    public ResponseEntity getDog(@PathVariable("dogId") Long dogId){
        try {
            DogEntity dog = dogService.getDogById(dogId).get();
            return ResponseEntity.ok(new SuccessResponse<>(Dog.toDTO(dog)));
        } catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getSuppressed());
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }
}
