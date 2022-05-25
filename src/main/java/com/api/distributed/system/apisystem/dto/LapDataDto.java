package com.api.distributed.system.apisystem.dto;


import com.api.distributed.system.apisystem.enums.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LapDataDto {
    private float lastLapTime;
    private float currentLapTime;
    private int sector1TimeInMS;
    private int sector2TimeInMS;
    private short carPosition;
    private short currentLapNum;
    private PitStatus pitStatus;
    private Sector sector;
    private short currentLapInvalid;
    private short penalties;
    private short warnings;
    private short numUnservedDriveThroughPens;
    private short numUnservedStopGoPens;
    private DriverStatus driverStatus;
    private ResultStatus resultStatus;
    private PitLaneTimerActive pitLaneTimerActive;
    private float pitLaneTimeInLaneInMS;
    private float pitStopTimerInMS;
    private float pitStopShouldServePen;
}
