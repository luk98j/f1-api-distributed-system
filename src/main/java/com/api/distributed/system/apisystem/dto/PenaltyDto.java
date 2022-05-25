package com.api.distributed.system.apisystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
public class PenaltyDto extends MainDto {
    private final BigInteger sessionUid;
    private final int carId;
    private final String penaltyType;
    private final String time;
}
