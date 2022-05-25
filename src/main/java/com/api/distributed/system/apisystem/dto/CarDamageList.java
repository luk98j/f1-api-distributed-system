package com.api.distributed.system.apisystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CarDamageList extends MainDto {
    private final BigInteger sessionUid;
    private List<CarDamageDataDto> carDamageDataDtoList;
}
