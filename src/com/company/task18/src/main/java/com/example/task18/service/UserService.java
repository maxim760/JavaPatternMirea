package com.example.task18.service;

import com.example.task18.entity.DogEntity;
import com.example.task18.entity.UserEntity;
import com.example.task18.repository.DogRepo;
import com.example.task18.repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private DogRepo dogRepo;

    public List<UserEntity> getUsers() {
        System.out.println("start");
        return userRepo.findAll();
    }

    public UserEntity addDogToUser(Long id, DogEntity dogData) throws Exception {
        UserEntity user = userRepo.findById(id).orElseThrow(() -> new Exception("Пользователь не найден"));
        DogEntity dog = new DogEntity();
        System.out.println(dog.getId() + ": id of dog");
        dog.setBreed(dogData.getBreed());
        dog.setName(dogData.getName());
        dog.setUser(user);
        List<DogEntity> currentDogs = user.getDogs();
        System.out.println(Arrays.toString(currentDogs.toArray()));
        currentDogs.add(dog);
        user.setDogs(currentDogs);
        userRepo.save(user);
        dogRepo.save(dog);
        return user;
    }

    public UserEntity addUser(UserEntity userData) {
        UserEntity user = new UserEntity();
        user.setFirstName(userData.getFirstName());
        user.setLastName(userData.getLastName());
        userRepo.save(user);
        return user;
    }

//    task 18
    public List<UserEntity> filterByFields(String firstName, String lastName) {
        return userRepo.findAllByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(firstName, lastName);
    }
}

