package com.api.distributed.system.apisystem.entity;

import com.api.distributed.system.apisystem.dto.CarStatusDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Document("car.status")
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
public class CarStatusEntity extends BasicEntity{
    @Id
    private String id;
    @NonNull
    private BigInteger sessionUid;
    @NonNull
    private String key;
    @NonNull
    private List<CarStatusDto> carStatusDtoList;
    @NonNull
    private Date date;
}
