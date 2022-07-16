package com.api.distributed.system.apisystem.controller;

import com.api.distributed.system.apisystem.dto.CarDamageList;
import com.api.distributed.system.apisystem.dto.EventDto;
import com.api.distributed.system.apisystem.entity.CarDamageEntity;
import com.api.distributed.system.apisystem.repository.CarDamageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@RestController
@RequestMapping("/damage")
public class CarDamageController {

    @Autowired
    private CarDamageRepository carDamageRepository;

    @PostMapping("/post-damage")
    public ResponseEntity<?> postDamage(@RequestHeader("Unique-Key") String key,
                                        @RequestBody CarDamageList carDamageList){
        carDamageRepository.save(new CarDamageEntity(carDamageList.getSessionUid(),key,
                carDamageList.getCarDamageDataDtoList(), new Timestamp(new Date().getTime())));
        return ResponseEntity.ok("Object saved");
    }

    @GetMapping("/get-damage")
    public ResponseEntity<CarDamageEntity> getDamage(@RequestParam BigInteger sessionUid, @RequestParam String key){
        CarDamageEntity carDamageEntity = carDamageRepository.findFirstBySessionUidAndKeyOrderByTimestampDesc(sessionUid, key);
        if(carDamageEntity!=null){
            return ResponseEntity.ok(carDamageEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
