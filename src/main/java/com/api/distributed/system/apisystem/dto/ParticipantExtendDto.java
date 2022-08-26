package com.api.distributed.system.apisystem.dto;

import com.api.distributed.system.apisystem.enums.Driver;
import com.api.distributed.system.apisystem.enums.PenaltyType;
import com.api.distributed.system.apisystem.enums.PitStatus;
import com.api.distributed.system.apisystem.enums.ResultStatus;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ParticipantExtendDto {
    private int carIndex;
    private Driver driverId;
    private short networkId;
    private String name;
    private short yourTelemetry;
    private ResultStatus resultStatus;
    private PitStatus pitStatus;
    private boolean fastestLap;
    private List<PenaltyType> penaltyTypesList;
    private int sumOfPenalty;

    public void addPenalty(PenaltyType penaltyType, int sumOfPenalty){
        penaltyTypesList.add(penaltyType);
        this.sumOfPenalty += sumOfPenalty;
    }
}
