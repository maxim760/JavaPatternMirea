package com.example.task18.repository;

import com.example.task18.entity.DogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepo extends JpaRepository<DogEntity, Long> {
}
