package com.api.distributed.system.apisystem.repository;

import com.api.distributed.system.apisystem.entity.LapDataEntity;
import com.api.distributed.system.apisystem.entity.SessionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface PacketSessionRepository extends MongoRepository<SessionEntity, String> {
    SessionEntity findFirstBySessionUidAndKeyOrderByDateDesc(BigInteger sessionUid, String key);
    List<SessionEntity> findAllByKey(String key);
}
