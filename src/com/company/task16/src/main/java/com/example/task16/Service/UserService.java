package com.example.task16.Service;

import com.example.task16.config.PostgresConfig;
import com.example.task16.entity.DogEntity;
import com.example.task16.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserService {
    private final SessionFactory sessionFactory;
    private Session session;
    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }
    public List<UserEntity> getUsers() {
        System.out.println("start");
        return session.createQuery("select u from UserEntity u", UserEntity.class).getResultList();
    }

    public UserEntity addDogToUser(Long id, DogEntity dogData) throws Exception {
        UserEntity user = null;
        try {
            user = session
                    .createQuery("FROM UserEntity where id = :userId", UserEntity.class)
                    .setParameter("userId", id)
                    .getSingleResult();
        } catch (Exception e) {}
        if(user == null) {
            throw new Exception("Пользователь с таким id не найден");
        }
        DogEntity dog = new DogEntity();
        System.out.println(dog.getId() + ": id of dog");
        dog.setBreed(dogData.getBreed());
        dog.setName(dogData.getName());
        dog.setUser(user);
        List<DogEntity> currentDogs = user.getDogs();
        System.out.println(Arrays.toString(currentDogs.toArray()));
        currentDogs.add(dog);
        user.setDogs(currentDogs);
        var transaction = session.beginTransaction();
        session.saveOrUpdate(dog);
        session.saveOrUpdate(user);
        transaction.commit();
        return user;
    }

    public UserEntity addUser(UserEntity userData) {
        UserEntity user = new UserEntity();
        System.out.println(userData.getId());
        System.out.println(userData.getLastName());
        user.setFirstName(userData.getFirstName());
        user.setLastName(userData.getLastName());
        var transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
        return user;
    }
}

