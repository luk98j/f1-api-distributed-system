package com.api.distributed.system.apisystem.data;

import com.api.distributed.system.apisystem.enums.ZoneFlag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MarshalZone {

    public static final int SIZE = 5;

    private float zoneStart;
    public ZoneFlag zoneFlag;

}
