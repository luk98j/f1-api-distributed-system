package com.api.distributed.system.apisystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class FinalClasificationList extends MainDto {
    private BigInteger sessionUid;
    private List<CarFinalClasificationDto> list;
}
