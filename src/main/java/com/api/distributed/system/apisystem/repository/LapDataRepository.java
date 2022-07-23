package com.api.distributed.system.apisystem.repository;

import com.api.distributed.system.apisystem.entity.FinalClassificationEntity;
import com.api.distributed.system.apisystem.entity.LapDataEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface LapDataRepository extends MongoRepository<LapDataEntity, String> {
    LapDataEntity findFirstBySessionUidAndKeyOrderByTimestampDesc(BigInteger sessionUid, String key);

}
