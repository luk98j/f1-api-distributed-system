package com.api.distributed.system.apisystem.repository;

import com.api.distributed.system.apisystem.entity.Healthcheck;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthcheckRepository extends MongoRepository<Healthcheck, String> {
}
