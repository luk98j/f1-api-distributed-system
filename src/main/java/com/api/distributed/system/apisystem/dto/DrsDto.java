package com.api.distributed.system.apisystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class DrsDto extends MainDto {
    private BigInteger sessionUid;
    private boolean enable;
}
