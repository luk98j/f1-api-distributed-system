package com.api.distributed.system.apisystem.dto;


import com.api.distributed.system.apisystem.utilities.Const;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CarDamageDataDto extends MainDto {
    private float tyresWear[] = new float[Const.TYRES];
    private short tyresDamage[] = new short[Const.TYRES];
    private short brakesDamage[] = new short[Const.TYRES];
    private short frontLeftWingDamage;
    private short frontRightWingDamage;
    private short rearWingDamage;
    private short floorDamage;
    private short diffuserDamage;
    private short sidepodDamage;
}
