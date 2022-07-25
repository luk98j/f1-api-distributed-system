package com.api.distributed.system.apisystem.service;

import com.api.distributed.system.apisystem.dto.FinalClasificationList;
import com.api.distributed.system.apisystem.entity.FinalClassificationEntity;
import com.api.distributed.system.apisystem.repository.FinalClassificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Service
@AllArgsConstructor
public class CarFinalClassificationService {
    @Autowired
    private FinalClassificationRepository finalClassificationRepository;

    public ResponseEntity<String> postData(String key, FinalClasificationList finalClasificationList) {
        finalClassificationRepository.save(new FinalClassificationEntity(finalClasificationList.getSessionUid(), key,
                finalClasificationList.getList(), new Timestamp(new Date().getTime())));
        return ResponseEntity.ok("Object saved");
    }

    public ResponseEntity<FinalClassificationEntity> getFinalClassification(BigInteger sessionUid,String key){
        FinalClassificationEntity finalClassificationEntity = finalClassificationRepository.findFirstBySessionUidAndKeyOrderByTimestampDesc(sessionUid,key);
        if(finalClassificationEntity!=null){
            return ResponseEntity.ok(finalClassificationEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
