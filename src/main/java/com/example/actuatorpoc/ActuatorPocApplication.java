package com.example.actuatorpoc;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class ActuatorPocApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActuatorPocApplication.class, args);
    }

}
