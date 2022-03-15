package com.example.task21.service;

import com.example.task21.entity.DogEntity;
import com.example.task21.entity.UserEntity;
import com.example.task21.repository.DogRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;


@Service
@RequiredArgsConstructor
public class DogService {

    @Autowired
    private DogRepo dogRepo;

    @Transactional(readOnly = true)
    @Async
    public CompletableFuture<List<DogEntity>> getAll() {
        List<DogEntity> dogs = dogRepo.findAll();
        return CompletableFuture.completedFuture(dogs);
    }

    @Transactional(readOnly = true)
    @Async
    public CompletableFuture<UserEntity> getUserByDog(Long dogId) throws Exception {
        UserEntity user = dogRepo
                .findById(dogId)
                .orElseThrow(() -> new Exception("Собака по id не найдена"))
                .getUser();
        return CompletableFuture.completedFuture(user);
    }

    @Transactional(readOnly = true)
    @Async
    public CompletableFuture<DogEntity> getDogById(Long dogId) throws Exception {
        DogEntity dog = dogRepo
                .findById(dogId)
                .orElseThrow(() -> new Exception("Собака по id не найдена"));
        return CompletableFuture.completedFuture(dog);
    }
}
