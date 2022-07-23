package com.api.distributed.system.apisystem.repository;

import com.api.distributed.system.apisystem.entity.ParticipantEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;

@Repository
public interface ParticipantRepository extends MongoRepository<ParticipantEntity, String> {
    Boolean existsBySessionUidAndKey(BigInteger sessionUid, String key);
    ParticipantEntity findFirstBySessionUidAndKeyOrderByTimestampDesc(BigInteger sessionUid, String key);
}
