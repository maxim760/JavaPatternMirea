package com.example.task14.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class Home {

    @GetMapping
    public String getHomePage() {
        return "forward:/index.html";
    }
}
