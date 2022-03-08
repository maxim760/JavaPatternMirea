package com.example.task16.Service;

import com.example.task16.entity.DogEntity;
import com.example.task16.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class DogService {
    private final SessionFactory sessionFactory;
    private Session session;
    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }
    public UserEntity getUserByDog(Long dogId) throws Exception {
        DogEntity dog = null;
        try {
            dog = session
                    .createQuery("FROM DogEntity where id = :id", DogEntity.class)
                    .setParameter("id", dogId)
                    .getSingleResult();
        } catch(Exception e) {}
        if(dog == null) {
            throw new Exception("Собака по id не найдена");
        }
        System.out.println(dog + " " + dog.getName() + " " + dogId);
        return dog.getUser();
    }
    public DogEntity getDogById(long dogId) throws Exception {
        try {
            return session
                .createQuery("FROM DogEntity ent JOIN FETCH ent.user where ent.id = :id", DogEntity.class)
                .setParameter("id", dogId)
                .getSingleResult();
        } catch (Exception e) {
            throw new Exception("Собака по id не найдена");
        }
    }
}
