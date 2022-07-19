package com.api.distributed.system.apisystem.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document("race.event")
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class RaceEventEntity {
    @Id
    private String id;
    @NonNull
    private BigInteger sessionUid;
    @NonNull
    private String key;
    @NonNull
    private String eventKey;
    @NonNull
    private String value;
}
