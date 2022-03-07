package com.example.task16.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "dogs")
@Entity
@Getter
@Setter
public class DogEntity {
    @Id
    @SequenceGenerator(name = "dogs_seq", sequenceName = "dogs_sequence", allocationSize = 1)
    @GeneratedValue(generator = "dogs_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String breed;
    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UserEntity user;
}
