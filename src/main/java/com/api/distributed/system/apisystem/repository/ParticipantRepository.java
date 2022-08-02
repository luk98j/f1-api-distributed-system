package com.api.distributed.system.apisystem.repository;

import com.api.distributed.system.apisystem.entity.ParticipantEntity;
import com.api.distributed.system.apisystem.entity.SessionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Repository
public interface ParticipantRepository extends MongoRepository<ParticipantEntity, String> {
    Boolean existsBySessionUidAndKey(BigInteger sessionUid, String key);
    List<ParticipantEntity> findAllBySessionUidAndKey(BigInteger sessionUid, String key);
    List<ParticipantEntity> findAllByKey(String key);

}
