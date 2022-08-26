package com.api.distributed.system.apisystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class FastestLapExtendedDto {
    private String nameOfDriver;
    private int carId;
    private String time;
}
