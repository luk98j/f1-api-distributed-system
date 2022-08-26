package com.api.distributed.system.apisystem.dto;

import lombok.*;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
public class ParticipantListDto extends MainDto {
    private BigInteger sessionUid;
    private List<ParticipantDto> participantDtoList;

}
