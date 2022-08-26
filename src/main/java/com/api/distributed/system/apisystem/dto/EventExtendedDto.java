package com.api.distributed.system.apisystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
public class EventExtendedDto extends EventDto{
    private String value;

    public EventExtendedDto(BigInteger sessionUid, String eventName, String value) {
        super(sessionUid, eventName);
        this.value = value;
    }
}
