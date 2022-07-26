package com.api.distributed.system.apisystem.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.sql.Timestamp;

@Document("session")
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class SessionEntity extends BasicEntity{
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
