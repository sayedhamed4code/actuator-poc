package com.example.actuatorpoc.actuator.health;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class SampleDependencyHealthIndicator implements HealthIndicator {

    private final boolean sampleDependencyAvailable;

    public SampleDependencyHealthIndicator(
            @Value("${monitoring.sample-dependency.available:true}") boolean sampleDependencyAvailable) {
        this.sampleDependencyAvailable = sampleDependencyAvailable;
    }

    @Override
    public Health health() {
        if (sampleDependencyAvailable) {
            return Health.up()
                    .withDetail("dependency", "Sample Dependency")
                    .withDetail("available", true)
                    .withDetail("message", "Sample dependency is reachable")
                    .build();
        }

        return Health.down()
                .withDetail("dependency", "Sample Dependency")
                .withDetail("available", false)
                .withDetail("message", "Sample dependency is unavailable")
                .build();
    }
}
