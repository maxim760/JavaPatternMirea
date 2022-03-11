package com.example.task20.service;

import com.example.task20.entity.DogEntity;
import com.example.task20.entity.UserEntity;
import com.example.task20.repository.DogRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DogService {

    @Autowired
    private DogRepo dogRepo;


    public UserEntity getUserByDog(Long dogId) throws Exception {
        return dogRepo
                .findById(dogId)
                .orElseThrow(() -> new Exception("Собака по id не найдена"))
                .getUser();
    }
    public DogEntity getDogById(Long dogId) throws Exception {
        return dogRepo
                .findById(dogId)
                .orElseThrow(() -> new Exception("Собака по id не найдена"));
    }
}
