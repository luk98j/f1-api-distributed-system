package com.api.distributed.system.apisystem.dto;

import com.api.distributed.system.apisystem.enums.DriverStatus;
import com.api.distributed.system.apisystem.enums.ResultStatus;
import com.api.distributed.system.apisystem.utilities.Const;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class LapParticipantCarDataDTO extends MainDto{
    private short carPosition;
    private String nameOfDriver;
    private int carIndex;
    private String lastLapTime;
    private String currentLapTime;
    private String sector1TimeInMS;
    private String sector2TimeInMS;
    private short currentLapNum;
    private short penalties;
    private short warnings;
    private short numUnservedDriveThroughPens;
    private short numUnservedStopGoPens;
    private String driverStatus;
    private String resultStatus;
    private boolean fastestLap;
    private float tyresWear[] = new float[Const.TYRES];
    private short tyresDamage[] = new short[Const.TYRES];
    private short brakesDamage[] = new short[Const.TYRES];
    private short frontLeftWingDamage;
    private short frontRightWingDamage;
    private short rearWingDamage;
    private short floorDamage;
    private short diffuserDamage;
    private short sidepodDamage;
    private String actualTyreCompound;
    private short tyresAgeLaps;
    private float ersStoreEnergy;
    private float fuelInTank;
    private String vehicleFlag;
}
