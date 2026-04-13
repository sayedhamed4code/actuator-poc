package com.example.actuatorpoc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/operations")
public class OperationsController {

    @GetMapping("/summary")
    public Map<String, Object> summary() {
        return Map.of(
                "status", "active",
                "services", List.of("dummy", "greetings", "operations"),
                "timestamp", Instant.now().toString()
        );
    }
}
