package com.api.distributed.system.apisystem.dto;

import com.api.distributed.system.apisystem.enums.Driver;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ParticipantDto {
    private Driver driverId;
    private short networkId;
    private String name;
    private short yourTelemetry;
}
