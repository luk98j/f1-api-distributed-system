package com.api.distributed.system.apisystem.repository;

import com.api.distributed.system.apisystem.entity.CarTelemetryEntity;
import com.api.distributed.system.apisystem.entity.FastestLapEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.List;

public interface FastestLapRepository extends MongoRepository<FastestLapEntity,String> {
    FastestLapEntity findFirstBySessionUidAndKeyOrderByDateDesc(BigInteger sessionUid, String key);
    List<FastestLapEntity> findAllByKey(String key);
}
