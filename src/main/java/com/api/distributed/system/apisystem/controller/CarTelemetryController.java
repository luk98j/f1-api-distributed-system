package com.api.distributed.system.apisystem.controller;

import com.api.distributed.system.apisystem.dto.CarStatusList;
import com.api.distributed.system.apisystem.dto.CarTelemetryDto;
import com.api.distributed.system.apisystem.dto.CarTelemetryList;
import com.api.distributed.system.apisystem.entity.CarTelemetryEntity;
import com.api.distributed.system.apisystem.repository.CarTelemetryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("/car-telemetry")
@AllArgsConstructor
public class CarTelemetryController {
    @Autowired
    private CarTelemetryRepository carTelemetryRepository;

    @PostMapping("/post-telemetry")
    public ResponseEntity<?> postStatus(@RequestHeader("Unique-Key") String key,
                                        @RequestBody CarTelemetryList carTelemetryList){
        carTelemetryRepository.save(new CarTelemetryEntity(carTelemetryList.getSessionUid(),key, carTelemetryList.getCarTelemetryDtoList(),
                new Timestamp(new Date().getTime())));
        return ResponseEntity.ok("Objected saved");
    }

    @GetMapping("/get-telemetry")
    public ResponseEntity<CarTelemetryEntity> getTelemetry(@RequestParam BigInteger sessionUid, @RequestParam String key){
        CarTelemetryEntity carTelemetryEntity = carTelemetryRepository.findFirstBySessionUidAndKeyOrderByTimestampDesc(sessionUid,key);
        if(carTelemetryEntity != null){
            return ResponseEntity.ok(carTelemetryEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
