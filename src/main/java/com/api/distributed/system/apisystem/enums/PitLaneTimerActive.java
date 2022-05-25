package com.api.distributed.system.apisystem.enums;

import java.util.HashMap;
import java.util.Map;

public enum PitLaneTimerActive {
    INACTIVE(0),
    ACTIVE(1);

    private static Map<Integer, PitLaneTimerActive> map = new HashMap<>();

    static {
        for (PitLaneTimerActive pitStatus : PitLaneTimerActive.values()) {
            map.put(pitStatus.value, pitStatus);
        }
    }

    private int value;

    PitLaneTimerActive(int value) {
        this.value = value;
    }

    public static PitLaneTimerActive valueOf(int value) {
        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}
