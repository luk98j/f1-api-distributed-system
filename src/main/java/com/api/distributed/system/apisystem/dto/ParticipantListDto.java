package com.api.distributed.system.apisystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class ParticipantListDto extends MainDto {
    private final BigInteger sessionUid;
    private final List<ParticipantDto> participantDtoList;
}
