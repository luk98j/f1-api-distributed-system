package com.api.distributed.system.apisystem.enums;

import java.util.HashMap;
import java.util.Map;

public enum Team {
    MERCEDES(0),
    FERRARI(1),
    RED_BULL_RACING(2),
    WILLIAMS(3),
    ASTON_MARTIN(4),
    ALPINE(5),
    ALPHA_TAURI(6),
    HAAS(7),
    MCLAREN(8),
    ALFA_ROMEO(9),
    CAMPOS_19(43),
    CARLIN_19(44),
    SAUBER_JUNIOR_CHAROUZ_19(45),
    DAMS_19(46),
    UNI_VIRTUOSI_19(47),
    MP_MOTORSPORT_19(48),
    PREMA_19(49),
    TRIDENT_19(50),
    ARDEN_19(51),
    Art_GP_20(70),
    Campos_20(71),
    Carlin_20(72),
    Charouz_20(73),
    Dams_20(74),
    Uni_Virtuosi_20(75),
    MP_Motorsport_20(76),
    Prema_20(77),
    Trident_20(78),
    BWT_20(79),
    Hitech_20(80),
    Mercedes_2020(85),
    Ferrari_2020(86),
    Red_Bull_2020(87),
    Williams_2020(88),
    Racing_Point_2020(89),
    Renault_2020(90),
    Alpha_Tauri_2020(91),
    Haas_2020(92),
    McLaren_2020(93),
    Alfa_Romeo_2020(94),
    Prema_21(106),
    Uni_Virtuosi_21(107),
    Carlin_21(108),
    Hitech_21(109),
    Art_GP_21(110),
    MP_Motorsport_21(111),
    Charouz_21(112),
    Dams_21(113),
    Campos_21(114),
    BWT_21(115),
    Trident_21(116);

    private static Map<Integer, Team> map = new HashMap<>();

    static {
        for (Team team : Team.values()) {
            map.put(team.value, team);
        }
    }

    private int value;

    Team(int value) {
        this.value = value;
    }

    public static Team valueOf(int value) {
        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}
