package com.api.distributed.system.apisystem.repository;

import com.api.distributed.system.apisystem.entity.CarStatusEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface CarStatusRepository extends MongoRepository<CarStatusEntity, String> {
    CarStatusEntity findFirstBySessionUidAndKeyOrderByDateDesc(BigInteger sessionUid, String key);
    List<CarStatusEntity> findAllByKey(String key);
}
