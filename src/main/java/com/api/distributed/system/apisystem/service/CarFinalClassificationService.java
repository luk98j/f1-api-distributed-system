package com.api.distributed.system.apisystem.service;

import com.api.distributed.system.apisystem.dto.FinalClasificationList;
import com.api.distributed.system.apisystem.entity.BasicEntity;
import com.api.distributed.system.apisystem.entity.FinalClassificationEntity;
import com.api.distributed.system.apisystem.repository.FinalClassificationRepository;
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
public class CarFinalClassificationService extends BasicService{
    @Autowired
    private FinalClassificationRepository finalClassificationRepository;

    public ResponseEntity<String> postData(String key, FinalClasificationList finalClasificationList) {
        finalClassificationRepository.save(new FinalClassificationEntity(finalClasificationList.getSessionUid(), key,
                finalClasificationList.getList(), new Date()));
        return ResponseEntity.ok("Object saved");
    }

    public ResponseEntity<FinalClassificationEntity> getFinalClassification(BigInteger sessionUid,String key){
        FinalClassificationEntity finalClassificationEntity = finalClassificationRepository.findFirstBySessionUidAndKeyOrderByDateDesc(sessionUid,key);
        if(finalClassificationEntity!=null){
            return ResponseEntity.ok(finalClassificationEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Override
    public List<FinalClassificationEntity> getListByKey(String key){
        return finalClassificationRepository.findAllByKey(key);
    }

    @Override
    public <T extends BasicEntity> void deleteEntity(T tClass) {
        finalClassificationRepository.delete((FinalClassificationEntity) tClass);
    }
}
