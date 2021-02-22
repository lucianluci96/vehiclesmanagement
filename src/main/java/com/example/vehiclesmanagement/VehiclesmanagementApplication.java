package com.example.vehiclesmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAsync
@EnableSwagger2
public class VehiclesmanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehiclesmanagementApplication.class, args);
    }

}
