package com.example.task21.DTO;

import com.example.task21.entity.DogEntity;
import com.example.task21.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private List<DogEntity> dogs = new ArrayList<>();

    public User() {}

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
