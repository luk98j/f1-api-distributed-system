package com.api.distributed.system.apisystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.math.BigInteger;

@Data
@AllArgsConstructor
public class KeyDto {
    private BigInteger sessionUid;
    private String key;
}
