package com.api.distributed.system.apisystem.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.sql.Timestamp;

@Document("healthcheck")
@AllArgsConstructor
@NoArgsConstructor
public class Healthcheck {
    @Id
    private String id;
    private String name;
    private Timestamp timestamp;

    public Healthcheck(String name, Timestamp timestamp) {
        this.name = name;
        this.timestamp = timestamp;
    }
}
