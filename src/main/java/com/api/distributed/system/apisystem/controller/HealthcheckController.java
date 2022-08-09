package com.api.distributed.system.apisystem.controller;

import com.api.distributed.system.apisystem.entity.Healthcheck;
import com.api.distributed.system.apisystem.repository.HealthcheckRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;


@RestController
@CrossOrigin
@RequestMapping("/healthcheck")
public class HealthcheckController {
    private HealthcheckRepository healthcheckRepository;

    @Autowired
    public HealthcheckController(HealthcheckRepository healthcheckRepository) {
        this.healthcheckRepository = healthcheckRepository;
    }

    @GetMapping
    public ResponseEntity<String> getHealthCheck(){
        healthcheckRepository.save(new Healthcheck("healthcheck", new Timestamp(System.currentTimeMillis())));
        return ResponseEntity.ok("Service is working");
    }
}
