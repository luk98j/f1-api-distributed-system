package com.api.distributed.system.apisystem.repository;

import com.api.distributed.system.apisystem.entity.ParticipantEntity;
import com.api.distributed.system.apisystem.entity.RaceEventEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Repository
public interface RaceEventRepository extends MongoRepository<RaceEventEntity, String> {
    List<RaceEventEntity> findAllByKey(String key);
    RaceEventEntity findFirstBySessionUidAndKeyOrderByDateDesc(BigInteger sessionUid, String key);
}
