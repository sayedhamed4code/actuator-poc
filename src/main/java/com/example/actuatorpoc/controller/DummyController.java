package com.example.actuatorpoc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/api/dummy")
public class DummyController {

    private final String applicationName;
    private final boolean sampleDependencyAvailable;

    public DummyController(
            @Value("${spring.application.name}") String applicationName,
            @Value("${monitoring.sample-dependency.available}") boolean sampleDependencyAvailable) {
        this.applicationName = applicationName;
        this.sampleDependencyAvailable = sampleDependencyAvailable;
    }

    @GetMapping
    public Map<String, Object> test(@RequestParam(defaultValue = "Developer") String name) {
        return Map.of(
                "message", "Hello, " + name + "!",
                "applicationName", applicationName,
                "sampleDependencyAvailable", sampleDependencyAvailable,
                "timestamp", Instant.now().toString()
        );
    }
}
