package com.api.distributed.system.apisystem.repository;

import com.api.distributed.system.apisystem.entity.CarDamageEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CarDamageRepository extends MongoRepository<CarDamageEntity, String> {
    CarDamageEntity findFirstBySessionUidAndKeyOrderByTimestampDesc(BigInteger sessionUid, String key);
}
