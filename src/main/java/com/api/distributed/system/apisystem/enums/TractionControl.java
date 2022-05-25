package com.api.distributed.system.apisystem.enums;

import java.util.HashMap;
import java.util.Map;

public enum TractionControl {
    OFF(0),
    MEDIUM(1),
    HIGH(2);

    private static Map<Integer, TractionControl> map = new HashMap<>();

    static {
        for (TractionControl tractionControl : TractionControl.values()) {
            map.put(tractionControl.value, tractionControl);
        }
    }

    private int value;

    TractionControl(int value) {
        this.value = value;
    }

    public static TractionControl valueOf(int value) {
        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}
