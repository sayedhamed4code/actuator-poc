package com.example.actuatorpoc.actuator.info;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Map;

@Component
public class CustomInfoContributor implements InfoContributor {

    @Value("${info.app.version}")
    private String version;

    @Value("${info.app.owner}")
    private String owner;

    @Value("${info.app.service}")
    private String service;

    @Value("${info.app.environment}")
    private String environment;

    @Value("${info.app.api-style}")
    private String apiStyle;

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("project",
                Map.of(
                        "name", "Actuator POC",
                        "service", service,
                        "version", version,
                        "owner", owner,
                        "environment", environment,
                        "apiStyle", apiStyle,
                        "generatedAt", Instant.now().toString()
                )
        );
    }
}
