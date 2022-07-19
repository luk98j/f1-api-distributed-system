package com.api.distributed.system.apisystem.repository;

import com.api.distributed.system.apisystem.entity.RaceEventEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceEventRepository extends MongoRepository<RaceEventEntity, String> {
}
