package com.example.task14.controllers;

import com.example.task14.BankEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bank")
public class Bank {
    private ArrayList<BankEntity> bankList = new ArrayList<BankEntity>();

    @GetMapping("/{name}")
    public ResponseEntity getOne(@PathVariable String name) {
        Optional<BankEntity> data = this.bankList.stream().filter((item) -> item.getName().equalsIgnoreCase(name)).findFirst();
        if(data != null) {
            return ResponseEntity.ok(data);
        } else {
            return ResponseEntity.badRequest().body("Не найдено");
        }
    }

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(bankList);
    }

    @PostMapping
    public ResponseEntity addOne(@RequestBody BankEntity bank) {
        bankList.add(bank);
        return ResponseEntity.ok("Добавлено");
    }

    @DeleteMapping
    public ResponseEntity removeByName(@RequestParam String name) {
        int idx = bankList.stream().map(item -> item.getName()).collect(Collectors.toList()).indexOf(name);
        if(idx == -1) {
            return ResponseEntity.badRequest().body("Не найдено");
        } else {
            bankList.remove(idx);
            return ResponseEntity.ok("Удалено");
        }
    }


}
