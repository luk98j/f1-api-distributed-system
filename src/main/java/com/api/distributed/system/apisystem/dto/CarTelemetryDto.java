package com.api.distributed.system.apisystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CarTelemetryDto {
    private int carIndex;
    private short drs;
    private int brakesTemperature[];
    private short tyresSurfaceTemperature[];
}
