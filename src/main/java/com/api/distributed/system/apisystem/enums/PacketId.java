package com.api.distributed.system.apisystem.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Motion	0	Contains all motion data for player’s car – only sent while player is in control
 * Session	1	Data about the session – track, time left
 * Lap Data	2	Data about all the lap times of cars in the session
 * Event	3	Various notable events that happen during a session
 * Participants	4	List of participants in the session, mostly relevant for multiplayer
 * Car Setups	5	Packet detailing car setups for cars in the race
 * Car Telemetry	6	Telemetry data for all cars
 * Car Status	7	Status data for all cars
 * Final Classification	8	Final classification confirmation at the end of a race
 * Lobby Info	9	Information about players in a multiplayer lobby
 * Car Damage	10	Damage status for all cars
 * Session History	11	Lap and tyre data for session
 */
@Getter
public enum PacketId {
    MOTION(0),
    SESSION(1),
    LAP_DATA(2),
    EVENT(3),
    PARTICIPANTS(4),
    CAR_SETUPS(5),
    CAR_TELEMETRY(6),
    CAR_STATUS(7),
    FINAL_CLASSIFICATION(8),
    LOBBY_INFO(9),
    CAR_DAMAGE(10),
    SESSION_HISTORY(11);

    private static final Map<Integer, PacketId> map = new HashMap<>();
    private final int value;

    static {
        for (PacketId packetId : PacketId.values()) {
            map.put(packetId.value, packetId);
        }
    }

    PacketId(int value) {
        this.value = value;
    }

    public static PacketId valueOf(int value) {
        return map.get(value);
    }

}
