package com.api.distributed.system.apisystem.dto;

import com.api.distributed.system.apisystem.enums.ActualTyreCompound;
import com.api.distributed.system.apisystem.enums.VehicleFiaFlag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarStatusDto {
    private int carIndex;
    private ActualTyreCompound actualTyreCompound;
    private short tyresAgeLaps;
    private float ersStoreEnergy;
    private float fuelInTank;
    private VehicleFiaFlag vehicleFiaFlag;
}
