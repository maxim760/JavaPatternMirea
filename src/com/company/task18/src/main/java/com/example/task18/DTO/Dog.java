package com.example.task18.DTO;

import com.example.task18.entity.DogEntity;
import com.example.task18.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dog {
    private Long id;
    private String name;
    private String breed;
    private UserEntity user;

    public Dog() {}

    static public Dog toDTO(DogEntity dogEntity) {
        Dog dog = new Dog();
        dog.setId(dogEntity.getId());
        dog.setBreed(dogEntity.getBreed());
        dog.setName(dogEntity.getName());
        dog.setUser(dogEntity.getUser());
        return dog;
    }
}
