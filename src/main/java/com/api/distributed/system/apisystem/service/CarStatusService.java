package com.api.distributed.system.apisystem.service;

import com.api.distributed.system.apisystem.dto.CarStatusDto;
import com.api.distributed.system.apisystem.dto.CarStatusList;
import com.api.distributed.system.apisystem.entity.BasicEntity;
import com.api.distributed.system.apisystem.entity.CarStatusEntity;
import com.api.distributed.system.apisystem.repository.CarStatusRepository;
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
public class CarStatusService extends BasicService{

    @Autowired
    private CarStatusRepository carStatusRepository;

    public ResponseEntity<String> postData(String key,
                                             CarStatusList carStatusList){
        carStatusRepository.save(new CarStatusEntity(carStatusList.getSessionUid(), key,
                carStatusList.getCarStatusDtoList(), new Date()));
        return ResponseEntity.ok("Objected saved");
    }

    public ResponseEntity<CarStatusEntity> getData(BigInteger sessionUid,String key){
        CarStatusEntity carStatusEntity = carStatusRepository.findFirstBySessionUidAndKeyOrderByDateDesc(sessionUid,key);
        if(carStatusEntity != null){
            return ResponseEntity.ok(carStatusEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    public List<CarStatusDto> getCarStatusBySessionUidAndKey(BigInteger sessionUid, String key){
        return carStatusRepository.findFirstBySessionUidAndKeyOrderByDateDesc(sessionUid, key).getCarStatusDtoList();
    }

    @Override
    public List<CarStatusEntity> getListByKey(String key){
        return carStatusRepository.findAllByKey(key);
    }

    @Override
    public <T extends BasicEntity> void deleteEntity(T tClass) {
        carStatusRepository.delete((CarStatusEntity) tClass);
    }
}
