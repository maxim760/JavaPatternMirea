package com.example.task15.service;

import com.example.task15.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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

    public void addUser(UserEntity userData) {
        UserEntity user = new UserEntity();
        System.out.println(userData.getFirstName());
        System.out.println(userData.getLastName());
        user.setFirstName(userData.getFirstName());
        user.setLastName(userData.getLastName());
        var transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
    }
}

