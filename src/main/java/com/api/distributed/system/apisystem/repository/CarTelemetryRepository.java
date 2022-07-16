package com.api.distributed.system.apisystem.repository;

import com.api.distributed.system.apisystem.entity.CarStatusEntity;
import com.api.distributed.system.apisystem.entity.CarTelemetryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CarTelemetryRepository extends MongoRepository<CarTelemetryEntity, String> {
    CarTelemetryEntity findFirstBySessionUidAndKeyOrderByTimestampDesc(BigInteger sessionUid, String key);
}
