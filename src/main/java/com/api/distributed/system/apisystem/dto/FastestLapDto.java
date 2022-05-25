package com.api.distributed.system.apisystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@AllArgsConstructor
@Getter
@Setter
public class FastestLapDto extends MainDto {
    private final BigInteger sessionUid;
    private final int carId;
    private final String time;
}
