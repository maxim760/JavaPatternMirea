package com.example.task19;

import com.example.task21.entity.DogEntity;
import com.example.task21.entity.RoleEntity;
import com.example.task21.entity.UserEntity;
import com.example.task21.repository.DogRepo;
import com.example.task21.repository.UserRepo;
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
public class UserServiceImplTest {
    @Mock
    private UserRepo userRepo;
    @Mock
    private DogRepo dogRepo;
    @Mock
    private BCryptPasswordEncoder encoder;
    @Mock
    private RoleService roleService;
    @Mock
    private EmailService emailService;
    @Captor
    ArgumentCaptor<UserEntity> captor;
    @Captor
    ArgumentCaptor<DogEntity> dogCaptor = ArgumentCaptor.forClass(DogEntity.class);
    @Test
    void getUsers() throws ExecutionException, InterruptedException {
        UserEntity user1 = new UserEntity();
        user1.setFirstName("Maxim");
        UserEntity user2 = new UserEntity();
        user2.setFirstName("Ivan");
        Mockito
            .when(userRepo.findAllByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase("", ""))
            .thenReturn(List.of(user1, user2));
        Mockito
            .when(userRepo.findAllByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase("xim", ""))
            .thenReturn(List.of(user1));
        UserService userService = new UserService(userRepo);
        Assertions.assertEquals(2, userService.filterByFields("", "").get().size());
        Assertions.assertEquals(1, userService.filterByFields("xim", "").get().size());
    }

    @Test
    void addUser() throws ExecutionException, InterruptedException {
        UserEntity user1 = new UserEntity();
        user1.setFirstName("Maxim");
        user1.setPassword("0000");
        user1.setId(5L);
        UserService userService = new UserService(userRepo);
        userService.setBCryptPasswordEncoder(encoder);
        userService.setEmailService(emailService);
        userService.setRoleService(roleService);
        RoleEntity role = new RoleEntity();
        role.setName("USER");
        Mockito
            .when(roleService.findOrCreateByName("USER"))
            .thenReturn(CompletableFuture.completedFuture(role));
        Mockito.doAnswer(i-> null).when(emailService).sendEmail(anyString(), anyString());
        userService.addUser(user1);
        Mockito.verify(userRepo).saveAndFlush(captor.capture());
        UserEntity captured = captor.getValue();
        Assertions.assertEquals("Maxim", captured.getFirstName());
    }

    @Test
    void addDogUser() throws Exception {
        UserEntity user1 = new UserEntity();
        user1.setFirstName("Maxim");
        Mockito.when(userRepo.findById(anyLong())).thenReturn(Optional.of(user1));
        DogEntity dog = new DogEntity();
        dog.setName("dog");
        UserService userService = new UserService(userRepo);
        userService.setEmailService(emailService);
        userService.setDogRepo(dogRepo);
        Mockito.doAnswer(i-> null).when(emailService).sendEmail(anyString(), anyString());
        userService.addDogToUser(1L, dog);
        Mockito.verify(dogRepo).save(dogCaptor.capture());
        DogEntity captured = dogCaptor.getValue();
        Assertions.assertEquals("dog", captured.getName());
    }
}
