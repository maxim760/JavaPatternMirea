package com.example.task16.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity {
    @Id
    @SequenceGenerator(name = "users_seq", sequenceName = "users_sequence", allocationSize = 1)
    @GeneratedValue(generator = "users_seq", strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<DogEntity> dogs = new ArrayList<>();
}