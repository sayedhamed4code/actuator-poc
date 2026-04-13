package com.example.actuatorpoc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/greetings")
public class GreetingController {

    @GetMapping
    public Map<String, String> greet(@RequestParam(defaultValue = "Developer") String name) {
        return Map.of(
                "message", "Hello, " + name + "!",
                "source", "GreetingController"
        );
    }

    @GetMapping("/{name}")
    public Map<String, String> greetByPath(@PathVariable String name) {
        return Map.of(
                "message", "Welcome, " + name + "!",
                "source", "GreetingController"
        );
    }
}
