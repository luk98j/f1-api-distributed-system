package com.api.distributed.system.apisystem.entity;

import com.api.distributed.system.apisystem.dto.PacketSessionDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Document("session")
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
public class SessionEntity extends BasicEntity{
    @Id
    private String id;
    @NonNull
    private BigInteger sessionUid;
    @NonNull
    private String key;
    @NonNull
    private PacketSessionDto packetSessionDto;
    @NonNull
    private Date date;
}
