package com.example.task21.repository;

import com.example.task21.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findAllByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(String firstName, String lastName);
}
