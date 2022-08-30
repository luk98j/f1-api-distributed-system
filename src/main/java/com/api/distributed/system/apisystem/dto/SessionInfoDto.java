package com.api.distributed.system.apisystem.dto;

import com.api.distributed.system.apisystem.data.MarshalZone;
import com.api.distributed.system.apisystem.data.WeatherForecastSample;
import com.api.distributed.system.apisystem.enums.SafetyCarStatus;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessionInfoDto extends MainDto{
    private String weather;
    private int trackTemperature;
    private int airTemperature;
    private String trackName;
    private int pitSpeedLimit;
    private List<MarshalZone> marshalZones;
    private List<WeatherForecastSample> weatherForecastSamples;
    private SafetyCarStatus safetyCarStatus;
}
