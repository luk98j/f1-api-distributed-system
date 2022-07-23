package com.api.distributed.system.apisystem.repository;

import com.api.distributed.system.apisystem.entity.SessionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacketSessionRepository extends MongoRepository<SessionEntity, String> {
}
