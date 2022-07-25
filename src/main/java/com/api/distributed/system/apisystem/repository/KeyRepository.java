package com.api.distributed.system.apisystem.repository;

import com.api.distributed.system.apisystem.entity.KeyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyRepository extends MongoRepository<KeyEntity, String> {
}
