package com.api.distributed.system.apisystem.controller;

import com.api.distributed.system.apisystem.dto.CarStatusList;
import com.api.distributed.system.apisystem.dto.FinalClasificationList;
import com.api.distributed.system.apisystem.entity.FinalClassificationEntity;
import com.api.distributed.system.apisystem.repository.FinalClassificationRepository;
import com.api.distributed.system.apisystem.service.CarFinalClassificationService;
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
    private CarFinalClassificationService carFinalClassificationService;


    @PostMapping("/post-clasification")
    public ResponseEntity<String> postClasification(@RequestHeader("Unique-Key") String key,
                                        @RequestBody FinalClasificationList finalClasificationList){
        return carFinalClassificationService.postData(key, finalClasificationList);
    }

    @GetMapping("/get-classification")
    public ResponseEntity<FinalClassificationEntity> getFinalClassification(@RequestParam BigInteger sessionUid, @RequestParam String key){
        return carFinalClassificationService.getFinalClassification(sessionUid,key);
    }
}
