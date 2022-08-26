package com.api.distributed.system.apisystem.entity;

import com.api.distributed.system.apisystem.dto.FastestLapDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Document("lap.fastest")
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
public class FastestLapEntity extends BasicEntity{
    @Id
    private String id;
    @NonNull
    private BigInteger sessionUid;
    @NonNull
    private String key;
    @NonNull
    private FastestLapDto fastestLapDto;
    @NonNull
    private Date date;
}
