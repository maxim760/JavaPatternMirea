package com.example.task21.repository;

import com.example.task21.entity.DogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepo extends JpaRepository<DogEntity, Long> {
}
