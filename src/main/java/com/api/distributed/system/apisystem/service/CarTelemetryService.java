package com.api.distributed.system.apisystem.service;

import com.api.distributed.system.apisystem.dto.CarTelemetryList;
import com.api.distributed.system.apisystem.entity.BasicEntity;
import com.api.distributed.system.apisystem.entity.CarTelemetryEntity;
import com.api.distributed.system.apisystem.repository.CarTelemetryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CarTelemetryService extends BasicService{
    @Autowired
    private CarTelemetryRepository carTelemetryRepository;

    public ResponseEntity<String> postStatus(String key,
                                             CarTelemetryList carTelemetryList){
        carTelemetryRepository.save(new CarTelemetryEntity(carTelemetryList.getSessionUid(),key, carTelemetryList.getCarTelemetryDtoList(),
                new Date()));
        return ResponseEntity.ok("Objected saved");
    }


    public ResponseEntity<CarTelemetryEntity> getTelemetry(BigInteger sessionUid, String key){
        CarTelemetryEntity carTelemetryEntity = carTelemetryRepository.findFirstBySessionUidAndKeyOrderByDateDesc(sessionUid,key);
        if(carTelemetryEntity != null){
            return ResponseEntity.ok(carTelemetryEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Override
    public List<CarTelemetryEntity> getListByKey(String key){
        return carTelemetryRepository.findAllByKey(key);
    }

    @Override
    public <T extends BasicEntity> void deleteEntity(T tClass) {
        carTelemetryRepository.delete((CarTelemetryEntity) tClass);
    }
}
