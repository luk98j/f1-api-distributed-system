package com.api.distributed.system.apisystem.dto;

import com.api.distributed.system.apisystem.enums.Driver;
import com.api.distributed.system.apisystem.enums.ResultStatus;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ParticipantDto {
    private int carIndex;
    private Driver driverId;
    private short networkId;
    private String name;
    private short yourTelemetry;
}
