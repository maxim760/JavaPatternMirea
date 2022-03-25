package com.example.task21.service;

import com.example.task21.entity.RoleEntity;
import com.example.task21.entity.UserEntity;
import com.example.task21.repository.RoleRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class RoleService {
    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private EmailService emailService;

    @Transactional
    @Async
    public CompletableFuture<RoleEntity> addRole(RoleEntity roleData) {
        log.info("add new role {}", roleData.getName());
        RoleEntity role = new RoleEntity();
        role.setName(roleData.getName());
        roleRepo.save(role);
        emailService.sendEmail("Добавлено ROLES", role.getName());
        return CompletableFuture.completedFuture(role);

    }

    @Transactional(readOnly = true)
    @Async
    public CompletableFuture<List<RoleEntity>> getRoles() {
        log.info("get all roles");
        List<RoleEntity> roles = roleRepo.findAll();
        return CompletableFuture.completedFuture(roles);

    }

    @Transactional
    @Async
    public CompletableFuture<RoleEntity> findOrCreateByName(String name) {
        RoleEntity role = roleRepo.findByName(name);
        if(role == null) {
            RoleEntity newRole = new RoleEntity();
            newRole.setName(name);
            roleRepo.save(newRole);
            return CompletableFuture.completedFuture(newRole);
        }
        return CompletableFuture.completedFuture(role);

    }
}
