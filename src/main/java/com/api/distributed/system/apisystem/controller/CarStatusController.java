package com.api.distributed.system.apisystem.controller;

import com.api.distributed.system.apisystem.dto.CarDamageList;
import com.api.distributed.system.apisystem.dto.CarStatusList;
import com.api.distributed.system.apisystem.entity.CarStatusEntity;
import com.api.distributed.system.apisystem.repository.CarStatusRepository;
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
@RequestMapping("/car-status")
@AllArgsConstructor
public class CarStatusController {
    @Autowired
    private CarStatusRepository carStatusRepository;

    @PostMapping("/post-status")
    public ResponseEntity<?> postStatus(@RequestHeader("Unique-Key") String key,
                                        @RequestBody CarStatusList carStatusList){
        carStatusRepository.save(new CarStatusEntity(carStatusList.getSessionUid(), key,
                carStatusList.getCarStatusDtoList(), new Timestamp(new Date().getTime())));
        return ResponseEntity.ok("Objected saved");
    }

    @GetMapping("/get-status")
    public ResponseEntity<CarStatusEntity> getStatus(@RequestParam BigInteger sessionUid, @RequestParam String key){
        CarStatusEntity carStatusEntity = carStatusRepository.findFirstBySessionUidAndKeyOrderByTimestampDesc(sessionUid,key);
        if(carStatusEntity != null){
            return ResponseEntity.ok(carStatusEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
