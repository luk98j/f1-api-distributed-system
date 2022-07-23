package com.api.distributed.system.apisystem.entity;

import com.api.distributed.system.apisystem.dto.LapDataDto;
import com.api.distributed.system.apisystem.dto.ParticipantDto;
import com.api.distributed.system.apisystem.dto.ParticipantListDto;
import com.api.distributed.system.apisystem.enums.ResultStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

@Document("participant")
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParticipantEntity {
    @Id
    private String id;
    @NonNull
    private BigInteger sessionUid;
    @NonNull
    private String key;
    @NonNull
    private List<ParticipantDto> participantListDtoList;
    @NonNull
    private Timestamp timestamp;

}
