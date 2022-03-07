package com.example.task16.DTO;

import com.example.task16.entity.DogEntity;
import com.example.task16.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private List<DogEntity> dogs = new ArrayList<>();
    public static User toDTO(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setDogs(userEntity.getDogs());
        return user;
    }
    public static List<User> toDTO(List<UserEntity> userEntities) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < userEntities.size(); i++) {
            UserEntity user = userEntities.get(i);
            users.add(toDTO(user));
        }
        return users;
    }
}
