package com.api.distributed.system.apisystem.entity;

import com.api.distributed.system.apisystem.dto.FastestLapDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.sql.Timestamp;

@Document("lap.fastest")
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class FastestLapEntity {
    @Id
    private String id;
    @NonNull
    private BigInteger sessionUid;
    @NonNull
    private String key;
    @NonNull
    private FastestLapDto fastestLapDto;
    @NonNull
    private Timestamp timestamp;
}
