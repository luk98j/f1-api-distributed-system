package com.api.distributed.system.apisystem.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class CarTelemetryDto {
    private int carIndex;
    private short drs;
    private int brakesTemperature[];
    private short tyresSurfaceTemperature[];
}
