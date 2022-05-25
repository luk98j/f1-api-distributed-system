package com.api.distributed.system.apisystem.enums;

import java.util.HashMap;
import java.util.Map;

public enum EventCode {
    SESSION_STARTED("SSTA"),
    SESSION_ENDED("SEND"),
    FASTEST_LAP("FTLP"),
    RETIREMENT("RTMT"),
    DRS_ENABLED("DRSE"),
    DRS_DISABLED("DRSD"),
    TEAM_MATE_IN_PITS("TMPT"),
    CHEQUERED_FLAG("CHQF"),
    RACE_WINNER("RCWN"),
    PENALTY_ISSUED("PENA"),
    SPEED_TRAP_TRIGGERED("SPTP"),
    START_LIGHTS("STLG"),
    LIGHTS_OUT("LGOT"),
    DRIVE_THROUGH_SERVED("DTSV"),
    STOP_GO_SERVED("SGSV"),
    FLASHBACK("FLBK"),
    BUTTON_STATUS("BUTN");

    private static Map<String, EventCode> map = new HashMap<>();

    static {
        for (EventCode eventCode : EventCode.values()) {
            map.put(eventCode.value, eventCode);
        }
    }

    private String value;

    EventCode(String value) {
        this.value = value;
    }

    public static EventCode valueFrom(String value) {
        return map.get(value);
    }

    public String getValue() {
        return value;
    }
}
