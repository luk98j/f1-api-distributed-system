package com.api.distributed.system.apisystem.repository;

import com.api.distributed.system.apisystem.entity.CarDamageEntity;
import com.api.distributed.system.apisystem.entity.CarStatusEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface CarStatusRepository extends MongoRepository<CarStatusEntity, String> {
    CarStatusEntity findFirstBySessionUidAndKeyOrderByTimestampDesc(BigInteger sessionUid, String key);
}
