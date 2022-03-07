package com.example.task16.DTO;

import com.example.task16.entity.DogEntity;
import com.example.task16.entity.UserEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Dog {
    private Long id;
    private String name;
    private String breed;
    private UserEntity user;

    static public Dog toDTO(DogEntity dogEntity) {
        Dog dog = new Dog();
        dog.setId(dogEntity.getId());
        dog.setBreed(dogEntity.getBreed());
        dog.setName(dogEntity.getName());
        dog.setUser(dogEntity.getUser());
        return dog;
    }
}
