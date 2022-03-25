package com.example.task21.DTO;

import com.example.task21.entity.DogEntity;
import com.example.task21.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Dog {
    private Long id;
    private String name;
    private String breed;

    public Dog() {}

    static public Dog toDTO(DogEntity dogEntity) {
        Dog dog = new Dog();
        dog.setId(dogEntity.getId());
        dog.setBreed(dogEntity.getBreed());
        dog.setName(dogEntity.getName());
        return dog;
    }

    static public List<Dog> toDTO(List<DogEntity> dogEntities) {
        List<Dog> dogs = new ArrayList<>();
        for (int i = 0; i < dogEntities.size(); i++) {
            DogEntity dog = dogEntities.get(i);
            dogs.add(toDTO(dog));
        }
        return dogs;
    }
}
