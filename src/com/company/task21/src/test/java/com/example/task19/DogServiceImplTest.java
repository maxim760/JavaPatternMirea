package com.example.task19;

import com.example.task21.entity.DogEntity;
import com.example.task21.entity.RoleEntity;
import com.example.task21.entity.UserEntity;
import com.example.task21.repository.DogRepo;
import com.example.task21.repository.UserRepo;
import com.example.task21.service.DogService;
import com.example.task21.service.EmailService;
import com.example.task21.service.RoleService;
import com.example.task21.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class DogServiceImplTest {
    @Mock
    private DogRepo dogRepo;
    @Test
    void getDogs() throws ExecutionException, InterruptedException {
        DogEntity dog1 = new DogEntity();
        dog1.setName("dog1");
        DogEntity dog2 = new DogEntity();
        dog2.setName("dog2");
        DogService dogService = new DogService();
        dogService.setDogRepo(dogRepo);
        Mockito
            .when(dogRepo.findAll())
            .thenReturn(List.of(dog1, dog2));
        Assertions.assertEquals(2, dogService.getAll().get().size());
        Assertions.assertEquals("dog2", dogService.getAll().get().get(1).getName());
    }

    @Test
    void getUserByDog() throws Exception {
        UserEntity user1 = new UserEntity();
        user1.setFirstName("Maxim");
        DogEntity dog1 = new DogEntity();
        dog1.setUser(user1);
        DogService dogService = new DogService();
        dogService.setDogRepo(dogRepo);
        Mockito
            .when(dogRepo.findById(anyLong()))
            .thenReturn(Optional.of(dog1));
       UserEntity user = dogService.getUserByDog(1L).get();
       Assertions.assertEquals("Maxim", user.getFirstName());
    }
    @Test
    void throwErrorIfUserNotFinded() throws Exception {
        UserEntity user1 = new UserEntity();
        user1.setFirstName("Maxim");
        DogEntity dog1 = new DogEntity();
        dog1.setUser(user1);
        DogService dogService = new DogService();
        dogService.setDogRepo(dogRepo);
        Mockito
            .when(dogRepo.findById(anyLong()))
            .thenReturn(null);
        Assertions.assertThrows(
            Exception.class,
            () -> dogService.getUserByDog(1L).get()
        );
    }

    @Test
    void getDog() throws Exception {
        DogEntity dog1 = new DogEntity();
        dog1.setName("dog");
        DogService dogService = new DogService();
        dogService.setDogRepo(dogRepo);
        Mockito
                .when(dogRepo.findById(anyLong()))
                .thenReturn(Optional.of(dog1));
        DogEntity dog = dogService.getDogById(1L).get();
        Assertions.assertEquals("dog", dog.getName());
    }
}
