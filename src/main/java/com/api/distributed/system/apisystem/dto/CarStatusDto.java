package com.api.distributed.system.apisystem.dto;

import com.api.distributed.system.apisystem.enums.ActualTyreCompound;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CarStatusDto {
    private ActualTyreCompound actualTyreCompound;
    private short tyresAgeLaps;
    private float ersStoreEnergy;
}
