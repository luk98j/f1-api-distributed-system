package com.api.distributed.system.apisystem.controller;

import com.api.distributed.system.apisystem.dto.CarDamageList;
import com.api.distributed.system.apisystem.dto.EventDto;
import com.api.distributed.system.apisystem.entity.CarDamageEntity;
import com.api.distributed.system.apisystem.repository.CarDamageRepository;
import com.api.distributed.system.apisystem.service.CarDamageService;
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
@CrossOrigin
public class CarDamageController {

    @Autowired
    private CarDamageService carDamageService;

    @PostMapping("/post-damage")
    public ResponseEntity<String> postDamage(@RequestHeader("Unique-Key") String key,
                                        @RequestBody CarDamageList carDamageList){
        return carDamageService.saveData(key,carDamageList);
    }

//    @GetMapping("/get-damage")
//    public ResponseEntity<CarDamageDto> getDamage(@RequestParam BigInteger sessionUid, @RequestParam String key){
//       return carDamageService.getDataAboutDamage(sessionUid,key);
//    }
}
