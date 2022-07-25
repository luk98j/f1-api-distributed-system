package com.api.distributed.system.apisystem.service;

import com.api.distributed.system.apisystem.dto.CarTelemetryList;
import com.api.distributed.system.apisystem.entity.CarTelemetryEntity;
import com.api.distributed.system.apisystem.repository.CarTelemetryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Service
@AllArgsConstructor
public class CarTelemetryService {
    @Autowired
    private CarTelemetryRepository carTelemetryRepository;

    public ResponseEntity<String> postStatus(String key,
                                             CarTelemetryList carTelemetryList){
        carTelemetryRepository.save(new CarTelemetryEntity(carTelemetryList.getSessionUid(),key, carTelemetryList.getCarTelemetryDtoList(),
                new Timestamp(new Date().getTime())));
        return ResponseEntity.ok("Objected saved");
    }


    public ResponseEntity<CarTelemetryEntity> getTelemetry(BigInteger sessionUid, String key){
        CarTelemetryEntity carTelemetryEntity = carTelemetryRepository.findFirstBySessionUidAndKeyOrderByTimestampDesc(sessionUid,key);
        if(carTelemetryEntity != null){
            return ResponseEntity.ok(carTelemetryEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
