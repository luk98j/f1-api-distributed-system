package com.api.distributed.system.apisystem.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 0	Melbourne
 * 1	Paul Ricard
 * 2	Shanghai
 * 3	Sakhir (Bahrain)
 * 4	Catalunya
 * 5	Monaco
 * 6	Montreal
 * 7	Silverstone
 * 8	Hockenheim
 * 9	Hungaroring
 * 10	Spa
 * 11	Monza
 * 12	Singapore
 * 13	Suzuka
 * 14	Abu Dhabi
 * 15	Texas
 * 16	Brazil
 * 17	Austria
 * 18	Sochi
 * 19	Mexico
 * 20	Baku (Azerbaijan)
 * 21	Sakhir Short
 * 22	Silverstone Short
 * 23	Texas Short
 * 24	Suzuka Short
 * 25	Hanoi
 * 26	Zandvoort
 * 27	Imola
 * 28	Portimão
 * 29	Jeddah
 */
@Getter
public enum Track {
    MELBOURNE(0),
    PAUL_RICARD(1),
    SHANGHAI(2),
    SAKHIR_BAHRAIN(3),
    CATALUNYA(4),
    MONACO(5),
    MONTREAL(6),
    SILVERSTONE(7),
    HOCKENHEIM(8),
    HUNGARORING(9),
    SPA(10),
    MONZA(11),
    SINGAPORE(12),
    SUZUKA(13),
    ABU_DHABI(14),
    TEXAS(15),
    BRAZIL(16),
    AUSTRIA(17),
    SOCHI(18),
    MEXICO(19),
    BAKU_AZERBAIJAN(20),
    SAKHIR_SHORT(21),
    SILVERSTONE_SHORT(22),
    TEXAS_SHORT(23),
    SUZUKA_SHORT(24),
    HANOI(25),
    ZANDVOORT(26),
    IMOLA(27),
    PORTIMAO(28),
    JEDDAH(29);

    private static Map<Integer, Track> map = new HashMap<>();

    static {
        for (Track track : Track.values()) {
            map.put(track.value, track);
        }
    }

    private int value;

    Track(int value) {
        this.value = value;
    }

    public static Track valueOf(int value) {
        return map.get(value);
    }
}
