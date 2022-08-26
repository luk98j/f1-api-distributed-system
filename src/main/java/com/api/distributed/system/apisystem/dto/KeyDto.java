package com.api.distributed.system.apisystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeyDto {
    private String sessionUid;
    private String key;
}
