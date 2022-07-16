package com.api.distributed.system.apisystem.controller;

import com.api.distributed.system.apisystem.dto.CarStatusList;
import com.api.distributed.system.apisystem.dto.FinalClasificationList;
import com.api.distributed.system.apisystem.entity.FinalClassificationEntity;
import com.api.distributed.system.apisystem.repository.FinalClassificationRepository;
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
@RequestMapping("/final-clasification")
@AllArgsConstructor
public class CarFinalClassificationController {

    @Autowired
    private FinalClassificationRepository finalClassificationRepository;

    @PostMapping("/post-clasification")
    public ResponseEntity<?> postClasification(@RequestHeader("Unique-Key") String key,
                                        @RequestBody FinalClasificationList finalClasificationList){
        finalClassificationRepository.save(new FinalClassificationEntity(finalClasificationList.getSessionUid(), key,
                finalClasificationList.getList(), new Timestamp(new Date().getTime())));
        return ResponseEntity.ok("Object saved");
    }

    @GetMapping("/get-classification")
    public ResponseEntity<FinalClassificationEntity> getFinalClassification(@RequestParam BigInteger sessionUid, @RequestParam String key){
        FinalClassificationEntity finalClassificationEntity = finalClassificationRepository.findFirstBySessionUidAndKeyOrderByTimestampDesc(sessionUid,key);
        if(finalClassificationEntity!=null){
            return ResponseEntity.ok(finalClassificationEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
