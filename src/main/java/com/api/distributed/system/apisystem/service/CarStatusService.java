package com.api.distributed.system.apisystem.service;

import com.api.distributed.system.apisystem.dto.CarStatusList;
import com.api.distributed.system.apisystem.entity.CarStatusEntity;
import com.api.distributed.system.apisystem.repository.CarStatusRepository;
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
public class CarStatusService {

    @Autowired
    private CarStatusRepository carStatusRepository;

    public ResponseEntity<String> postData(String key,
                                             CarStatusList carStatusList){
        carStatusRepository.save(new CarStatusEntity(carStatusList.getSessionUid(), key,
                carStatusList.getCarStatusDtoList(), new Timestamp(new Date().getTime())));
        return ResponseEntity.ok("Objected saved");
    }

    public ResponseEntity<CarStatusEntity> getData(BigInteger sessionUid,String key){
        CarStatusEntity carStatusEntity = carStatusRepository.findFirstBySessionUidAndKeyOrderByTimestampDesc(sessionUid,key);
        if(carStatusEntity != null){
            return ResponseEntity.ok(carStatusEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
