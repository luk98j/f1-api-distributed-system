package com.api.distributed.system.apisystem.dto;

import com.api.distributed.system.apisystem.enums.Driver;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ParticipantDto {
    private int carIndex;
    private Driver driverId;
    private short networkId;
    private String name;
    private short yourTelemetry;
}
