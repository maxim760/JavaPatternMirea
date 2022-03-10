package com.example.task20.service;

import com.example.task20.entity.DogEntity;
import com.example.task20.entity.UserEntity;
import com.example.task20.repository.DogRepo;
import com.example.task20.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private static Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private DogRepo dogRepo;

    public List<UserEntity> getUsers() {
        return userRepo.findAll();
    }

    public UserEntity addDogToUser(Long id, DogEntity dogData) throws Exception {
        log.info("add dog {} to user {}", dogData.toString(), id);
        UserEntity user = userRepo.findById(id).orElseThrow(() -> new Exception("Пользователь не найден"));
        DogEntity dog = new DogEntity();
        dog.setBreed(dogData.getBreed());
        dog.setName(dogData.getName());
        dog.setUser(user);
        List<DogEntity> currentDogs = user.getDogs();
        currentDogs.add(dog);
        user.setDogs(currentDogs);
        userRepo.save(user);
        dogRepo.save(dog);
        return user;
    }

    public UserEntity addUser(UserEntity userData) {
        log.info("add new user {} {}", userData.getFirstName(), userData.getLastName());
        UserEntity user = new UserEntity();
        user.setFirstName(userData.getFirstName());
        user.setLastName(userData.getLastName());
        userRepo.save(user);
        return user;
    }

    public List<UserEntity> filterByFields(String firstName, String lastName) {
        log.info(
                "get all users with filter: fullName contains {}, lastName contains {}",
                firstName.equals("") ? "\"\"" : firstName,
                lastName.equals("") ? "\"\"" : lastName
        );
        return userRepo.findAllByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(firstName, lastName);
    }
}

