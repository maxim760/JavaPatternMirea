package com.example.task21.service;

import com.example.task21.entity.DogEntity;
import com.example.task21.entity.UserEntity;
import com.example.task21.repository.DogRepo;
import com.example.task21.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class UserService {
    private static Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private DogRepo dogRepo;
    @Autowired
    private EmailService emailService;

    @Transactional
    @Async
    public CompletableFuture<UserEntity> addDogToUser(Long id, DogEntity dogData) throws Exception {
        log.info("add dog {} to user {}", dogData.toString(), id);
        UserEntity user = userRepo.findById(id).orElseThrow(() -> new Exception("Пользователь не найден"));
        DogEntity dog = new DogEntity();
        dog.setBreed(dogData.getBreed());
        dog.setName(dogData.getName());
        dog.setUser(user);
        List<DogEntity> currentDogs = user.getDogs();
        currentDogs.add(dog);
        user.setDogs(currentDogs);
        dogRepo.save(dog);
        userRepo.save(user);
        System.out.println(dog.getUser() == null ? "1" : dog.getUser().getFirstName());
        emailService.sendEmail("Добавлено DOGS", dog.getName() + " " + dog.getBreed() + "\n " + "id:" + dog.getId() + "\nuser:" + user.getId() );
        return CompletableFuture.completedFuture(user);
    }

    @Transactional
    @Async
    public CompletableFuture<UserEntity> addUser(UserEntity userData) {
        log.info("add new user {} {}", userData.getFirstName(), userData.getLastName());
        UserEntity user = new UserEntity();
        user.setFirstName(userData.getFirstName());
        user.setLastName(userData.getLastName());
        userRepo.save(user);
        emailService.sendEmail("Добавлено USERS", user.toString());
        return CompletableFuture.completedFuture(user);
    }

    @Transactional(readOnly = true)
    @Async
    public CompletableFuture<List<UserEntity>> filterByFields(String firstName, String lastName) {
        log.info(
                "get all users with filter: fullName contains {}, lastName contains {}",
                firstName.equals("") ? "\"\"" : firstName,
                lastName.equals("") ? "\"\"" : lastName
        );
        List<UserEntity> items = userRepo.findAllByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(firstName, lastName);
        return CompletableFuture.completedFuture(items);
    }
}