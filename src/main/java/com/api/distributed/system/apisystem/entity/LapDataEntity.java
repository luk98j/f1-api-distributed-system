package com.api.distributed.system.apisystem.entity;

import com.api.distributed.system.apisystem.dto.CarFinalClasificationDto;
import com.api.distributed.system.apisystem.dto.LapDataDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

@Document("lap.data")
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class LapDataEntity {
    @Id
    private String id;
    @NonNull
    private BigInteger sessionUid;
    @NonNull
    private String key;
    @NonNull
    private List<LapDataDto> lapDataDtoList;
    @NonNull
    private Timestamp timestamp;
}
