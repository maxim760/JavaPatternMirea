package com.example.task19.repository;

import com.example.task19.entity.DogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepo extends JpaRepository<DogEntity, Long> {
}
