package com.api.distributed.system.apisystem.repository;

import com.api.distributed.system.apisystem.entity.FinalClassificationEntity;
import com.api.distributed.system.apisystem.entity.LapDataEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface LapDataRepository extends MongoRepository<LapDataEntity, String> {
    LapDataEntity findFirstBySessionUidAndKeyOrderByDateDesc(BigInteger sessionUid, String key);
    List<LapDataEntity> findAllByKey(String key);
}
