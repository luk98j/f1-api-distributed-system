package com.api.distributed.system.apisystem.service;

import com.api.distributed.system.apisystem.dto.CarDamageList;
import com.api.distributed.system.apisystem.entity.CarDamageEntity;
import com.api.distributed.system.apisystem.repository.CarDamageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Service
@AllArgsConstructor
public class CarDamageService {
    @Autowired
    private final CarDamageRepository carDamageRepository;

    public ResponseEntity<String> saveData(String key, CarDamageList carDamageList){
        carDamageRepository.save(new CarDamageEntity(carDamageList.getSessionUid(),key,
                carDamageList.getCarDamageDataDtoList(), new Timestamp(new Date().getTime())));
        return ResponseEntity.ok("Object saved");
    }

    public ResponseEntity<CarDamageEntity> getDataAboutDamage(BigInteger sessionUid, String key){
        CarDamageEntity carDamageEntity = carDamageRepository.findFirstBySessionUidAndKeyOrderByTimestampDesc(sessionUid, key);
        if(carDamageEntity!=null){
            return ResponseEntity.ok(carDamageEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
