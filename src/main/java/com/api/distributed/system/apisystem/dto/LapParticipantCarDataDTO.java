package com.api.distributed.system.apisystem.dto;

import com.api.distributed.system.apisystem.enums.DriverStatus;
import com.api.distributed.system.apisystem.enums.ResultStatus;
import com.api.distributed.system.apisystem.utilities.Const;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
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

    public LapParticipantCarDataDTO(short carPosition, String nameOfDriver, int carIndex, String lastLapTime, String currentLapTime, String sector1TimeInMS, String sector2TimeInMS, short currentLapNum, short penalties, short warnings, short numUnservedDriveThroughPens, short numUnservedStopGoPens, String driverStatus, String resultStatus, boolean fastestLap, String actualTyreCompound, short tyresAgeLaps, float ersStoreEnergy, float fuelInTank, String vehicleFlag) {
        this.carPosition = carPosition;
        this.nameOfDriver = nameOfDriver;
        this.carIndex = carIndex;
        this.lastLapTime = lastLapTime;
        this.currentLapTime = currentLapTime;
        this.sector1TimeInMS = sector1TimeInMS;
        this.sector2TimeInMS = sector2TimeInMS;
        this.currentLapNum = currentLapNum;
        this.penalties = penalties;
        this.warnings = warnings;
        this.numUnservedDriveThroughPens = numUnservedDriveThroughPens;
        this.numUnservedStopGoPens = numUnservedStopGoPens;
        this.driverStatus = driverStatus;
        this.resultStatus = resultStatus;
        this.fastestLap = fastestLap;
        this.actualTyreCompound = actualTyreCompound;
        this.tyresAgeLaps = tyresAgeLaps;
        this.ersStoreEnergy = ersStoreEnergy;
        this.fuelInTank = fuelInTank;
        this.vehicleFlag = vehicleFlag;
    }

    public LapParticipantCarDataDTO(short carPosition, String nameOfDriver, int carIndex, String lastLapTime,
                                    String currentLapTime, String sector1TimeInMS, String sector2TimeInMS,
                                    short currentLapNum, short penalties, short warnings, short numUnservedDriveThroughPens,
                                    short numUnservedStopGoPens, String driverStatus, String resultStatus, boolean fastestLap,
                                    float[] tyresWear, short[] tyresDamage, short[] brakesDamage, short frontLeftWingDamage,
                                    short frontRightWingDamage, short rearWingDamage, short floorDamage, short diffuserDamage,
                                    short sidepodDamage) {
        this.carPosition = carPosition;
        this.nameOfDriver = nameOfDriver;
        this.carIndex = carIndex;
        this.lastLapTime = lastLapTime;
        this.currentLapTime = currentLapTime;
        this.sector1TimeInMS = sector1TimeInMS;
        this.sector2TimeInMS = sector2TimeInMS;
        this.currentLapNum = currentLapNum;
        this.penalties = penalties;
        this.warnings = warnings;
        this.numUnservedDriveThroughPens = numUnservedDriveThroughPens;
        this.numUnservedStopGoPens = numUnservedStopGoPens;
        this.driverStatus = driverStatus;
        this.resultStatus = resultStatus;
        this.fastestLap = fastestLap;
        this.tyresWear = tyresWear;
        this.tyresDamage = tyresDamage;
        this.brakesDamage = brakesDamage;
        this.frontLeftWingDamage = frontLeftWingDamage;
        this.frontRightWingDamage = frontRightWingDamage;
        this.rearWingDamage = rearWingDamage;
        this.floorDamage = floorDamage;
        this.diffuserDamage = diffuserDamage;
        this.sidepodDamage = sidepodDamage;
    }

    public LapParticipantCarDataDTO(short carPosition, String nameOfDriver, int carIndex, String lastLapTime, String currentLapTime, String sector1TimeInMS, String sector2TimeInMS, short currentLapNum, short penalties, short warnings, short numUnservedDriveThroughPens, short numUnservedStopGoPens, String driverStatus, String resultStatus, boolean fastestLap) {
        this.carPosition = carPosition;
        this.nameOfDriver = nameOfDriver;
        this.carIndex = carIndex;
        this.lastLapTime = lastLapTime;
        this.currentLapTime = currentLapTime;
        this.sector1TimeInMS = sector1TimeInMS;
        this.sector2TimeInMS = sector2TimeInMS;
        this.currentLapNum = currentLapNum;
        this.penalties = penalties;
        this.warnings = warnings;
        this.numUnservedDriveThroughPens = numUnservedDriveThroughPens;
        this.numUnservedStopGoPens = numUnservedStopGoPens;
        this.driverStatus = driverStatus;
        this.resultStatus = resultStatus;
        this.fastestLap = fastestLap;
    }

}
