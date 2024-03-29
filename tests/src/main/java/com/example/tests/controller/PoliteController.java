package com.example.tests.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PoliteController {
    @Autowired

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/buy")
    public String buy(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Buy %s!", name);
    }

    
}
