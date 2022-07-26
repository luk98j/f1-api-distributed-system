package com.api.distributed.system.apisystem.entity;

import com.api.distributed.system.apisystem.dto.ParticipantExtendDto;
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
public class ParticipantEntity extends BasicEntity{
    @Id
    private String id;
    @NonNull
    private BigInteger sessionUid;
    @NonNull
    private String key;
    @NonNull
    private List<ParticipantExtendDto> participantListDtoList;
    @NonNull
    private Timestamp timestamp;

}
