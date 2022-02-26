package com.example.task14.controllers;

import com.example.task14.CardEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/card")
public class Card {
    private ArrayList<CardEntity> bankList = new ArrayList<CardEntity>();

    @GetMapping("/{code}")
    public ResponseEntity getOne(@PathVariable int code) {
        Optional<CardEntity> data = this.bankList.stream().filter((item) -> item.getCode() == code).findFirst();
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
    public ResponseEntity addOne(@RequestBody CardEntity bank) {
        bankList.add(bank);
        return ResponseEntity.ok("Добавлено");
    }

    @DeleteMapping
    public ResponseEntity removeByCode(@RequestParam int code) {
        int idx = bankList.stream().map(item -> item.getCode()).collect(Collectors.toList()).indexOf(code);
        if(idx == -1) {
            return ResponseEntity.badRequest().body("Не найдено");
        } else {
            bankList.remove(idx);
            return ResponseEntity.ok("Удалено");
        }
    }
}
