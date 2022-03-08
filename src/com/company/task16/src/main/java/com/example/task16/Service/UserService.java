package com.example.task16.Service;

import com.example.task16.entity.DogEntity;
import com.example.task16.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserService {
    private final SessionFactory sessionFactory;
    private Session session;
    CriteriaBuilder builder;
    CriteriaQuery<UserEntity> criteriaQuery;
    Root<UserEntity> root;
    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
        builder = session.getCriteriaBuilder();
        criteriaQuery = builder.createQuery(UserEntity.class);
        root = criteriaQuery.from(UserEntity.class);
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

//    task 17
    public List<UserEntity> filterByFields(String firstName, String lastName) {
        System.out.println(firstName +"!23" + lastName);
        Predicate firstNamePredicate = builder.like(builder.lower(root.get("firstName")), "%" + firstName.toLowerCase() + "%");
        Predicate lastNamePredicate = builder.like(builder.lower(root.get("lastName")), "%" + lastName.toLowerCase() + "%");
        criteriaQuery
                .select(root)
                .where(builder.and(firstNamePredicate, lastNamePredicate));
        TypedQuery<UserEntity> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }
}

