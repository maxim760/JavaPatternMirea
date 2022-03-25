package com.example.task21.service;

import com.example.task21.DTO.User;
import com.example.task21.entity.DogEntity;
import com.example.task21.entity.RoleEntity;
import com.example.task21.entity.UserEntity;
import com.example.task21.repository.DogRepo;
import com.example.task21.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private static Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private DogRepo dogRepo;
    @Autowired
    private EmailService emailService;
    @Autowired
    private RoleService roleService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

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
    public CompletableFuture<UserEntity> addUser(UserEntity userData) throws ExecutionException, InterruptedException {
        log.info("add new user {} {}", userData.getFirstName(), userData.getLastName());
        System.out.println("--");
        UserEntity user = new UserEntity();
        user.setFirstName(userData.getFirstName());
        user.setLastName(userData.getLastName());
        user.setUsername(userData.getUsername());

        RoleEntity role = roleService.findOrCreateByName("USER").get();
        System.out.println(role.getName());
        user.setRoles(Collections.singleton(role));
        System.out.println("1");
        user.setPassword(bCryptPasswordEncoder.encode(userData.getPassword()));
        System.out.println("2");
        userRepo.saveAndFlush(user);
        System.out.println("3");
        emailService.sendEmail("Добавлено USERS", User.toDTO(user).toString());
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username + "!!username");
        UserEntity user =  userRepo.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("Пользователь не найден");
        }
        return user;
    }
}