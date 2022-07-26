package com.api.distributed.system.apisystem.repository;

import com.api.distributed.system.apisystem.entity.CarDamageEntity;
import com.api.distributed.system.apisystem.entity.FastestLapEntity;
import com.api.distributed.system.apisystem.entity.FinalClassificationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface FinalClassificationRepository extends MongoRepository<FinalClassificationEntity, String> {
    FinalClassificationEntity findFirstBySessionUidAndKeyOrderByTimestampDesc(BigInteger sessionUid, String key);
    List<FinalClassificationEntity> findAllByKey(String key);
}
