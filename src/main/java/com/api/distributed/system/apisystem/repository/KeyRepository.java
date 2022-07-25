package com.api.distributed.system.apisystem.repository;

import com.api.distributed.system.apisystem.entity.KeyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KeyRepository extends MongoRepository<KeyEntity, String> {
    List<KeyEntity> findByKey(String key);
}
