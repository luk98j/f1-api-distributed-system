package com.api.distributed.system.apisystem.entity;

import com.api.distributed.system.apisystem.dto.CarFinalClasificationDto;
import com.api.distributed.system.apisystem.dto.FinalClasificationList;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

@Document("final-classification")
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class FinalClassificationEntity {
    @Id
    private String id;
    @NonNull
    private BigInteger sessionUid;
    @NonNull
    private String key;
    @NonNull
    private List<CarFinalClasificationDto> list;
    @NonNull
    private Timestamp timestamp;
}
