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
//    public UserEntity addDogToUser(Long id, DogEntity dogData) throws Exception {
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
//        return user;
    }

    @Transactional
    @Async
    public CompletableFuture<UserEntity> addUser(UserEntity userData) {
//    public UserEntity addUser(UserEntity userData) {
        log.info("add new user {} {}", userData.getFirstName(), userData.getLastName());
        UserEntity user = new UserEntity();
        user.setFirstName(userData.getFirstName());
        user.setLastName(userData.getLastName());
        userRepo.save(user);
        emailService.sendEmail("Добавлено USERS", user.toString());
        return CompletableFuture.completedFuture(user);
//        return user;
    }

    @Transactional(readOnly = true)
//    @Transactional
    @Async
    public CompletableFuture<List<UserEntity>> filterByFields(String firstName, String lastName) {
//    public List<UserEntity> filterByFields(String firstName, String lastName) {
        log.info(
                "get all users with filter: fullName contains {}, lastName contains {}",
                firstName.equals("") ? "\"\"" : firstName,
                lastName.equals("") ? "\"\"" : lastName
        );
        List<UserEntity> items = userRepo.findAllByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(firstName, lastName);
//        .findAll();
//        Hibernate.initialize(items);
        return CompletableFuture.completedFuture(items);
//        return items;
    }
}


/*
* package com.example.task20.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
    @Value("${mail.to}")
    private String mailTo;

    @Value("${mail.from}")
    private String mailFrom;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String title, String text) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mailTo);
        msg.setFrom(mailFrom);
        System.out.println(mailTo);
        msg.setSubject(title);
        msg.setText(text);
        System.out.println(title + " " + text);
        javaMailSender.send(msg);
        log.info("Сообщение на email отправлено: " + title);

    }
}

*  */
