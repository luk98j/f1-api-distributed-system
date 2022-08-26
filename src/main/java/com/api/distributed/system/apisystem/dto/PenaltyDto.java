package com.api.distributed.system.apisystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PenaltyDto extends MainDto {
    private BigInteger sessionUid;
    private int carId;
    private String penaltyType;
    private String time;
}
