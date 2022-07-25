package com.api.distributed.system.apisystem.controller;

import com.api.distributed.system.apisystem.dto.CarDamageList;
import com.api.distributed.system.apisystem.dto.CarStatusList;
import com.api.distributed.system.apisystem.entity.CarStatusEntity;
import com.api.distributed.system.apisystem.repository.CarStatusRepository;
import com.api.distributed.system.apisystem.service.CarStatusService;
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
    private CarStatusService carStatusService;

    @PostMapping("/post-status")
    public ResponseEntity<String> postStatus(@RequestHeader("Unique-Key") String key,
                                        @RequestBody CarStatusList carStatusList){
        return carStatusService.postData(key, carStatusList);
    }

//    @GetMapping("/get-status")
//    public ResponseEntity<CarStatusDto> getStatus(@RequestParam BigInteger sessionUid, @RequestParam String key){
//        return carStatusService.getData(sessionUid, key);
//    }
}
