package com.example.task13;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Profiles;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Student {

    @Value("${program.student.name}")
    private String name;

    @Value("${program.student.last_name}")
    private String lastName;

    @Value("${program.student.group}")
    private String group;

    @PostConstruct
    public void init() {
        System.out.println(name);
        System.out.println(lastName);
        System.out.println(group);
    }
}
