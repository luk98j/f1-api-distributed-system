package com.api.distributed.system.apisystem.dto;

import com.api.distributed.system.apisystem.data.MarshalZone;
import com.api.distributed.system.apisystem.data.WeatherForecastSample;
import com.api.distributed.system.apisystem.enums.SafetyCarStatus;
import com.api.distributed.system.apisystem.enums.SessionType;
import com.api.distributed.system.apisystem.enums.Track;
import com.api.distributed.system.apisystem.enums.Weather;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class PacketSessionDto extends MainDto {
    private BigInteger sessionid;
    private Weather weather;
    private short trackTemperature;
    private short airTemperature;
    private short totalLaps;
    private SessionType sessionType;
    private Track trackId;
    private short pitSpeedLimit;
    private short numMarshalZones;
    private List<MarshalZone> marshalZones;
    private SafetyCarStatus safetyCarStatus;
    private short networkGame;
    private short numWeatherForecastSamples;
    private List<WeatherForecastSample> weatherForecastSamples;
}
