package com.api.distributed.system.apisystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CarTelemetryDto {
    private short drs;
    private int brakesTemperature[];
    private short tyresSurfaceTemperature[];
}
