package com.api.distributed.system.apisystem.repository;

import com.api.distributed.system.apisystem.entity.FastestLapEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface FastestLapRepository extends MongoRepository<FastestLapEntity,String> {
    FastestLapEntity  findFirstBySessionUidAndKeyOrderByTimestampDesc(BigInteger sessionUid, String key);
}
