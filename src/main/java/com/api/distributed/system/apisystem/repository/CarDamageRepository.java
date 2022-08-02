package com.api.distributed.system.apisystem.repository;

import com.api.distributed.system.apisystem.entity.BasicEntity;
import com.api.distributed.system.apisystem.entity.CarDamageEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface CarDamageRepository extends MongoRepository<CarDamageEntity, String> {
    CarDamageEntity findFirstBySessionUidAndKeyOrderByDateDesc(BigInteger sessionUid, String key);
    List<CarDamageEntity> findAllByKey(String key);
    void deleteAllByKey(String key);

}
