package com.api.distributed.system.apisystem.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.sql.Timestamp;

@Document("users.key")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class KeyEntity extends BasicEntity{
    @Id
    private String id;
    @NonNull
    private BigInteger sessionUid;
    @NonNull
    private String key;
    @NonNull
    private Timestamp timestamp;
}
