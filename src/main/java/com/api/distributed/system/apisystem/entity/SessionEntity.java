package com.api.distributed.system.apisystem.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

@Document("session")
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class SessionEntity {
    @Id
    private String id;
    @NonNull
    private BigInteger sessionUid;
    @NonNull
    private String key;
    @NonNull
    private com.f1distributedsystem.f1clientapp.dto.impl.PacketSessionDto packetSessionDto;
    @NonNull
    private Timestamp timestamp;
}
