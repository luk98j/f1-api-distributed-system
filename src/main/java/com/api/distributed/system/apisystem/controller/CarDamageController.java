package com.api.distributed.system.apisystem.controller;

import com.api.distributed.system.apisystem.dto.CarDamageList;
import com.api.distributed.system.apisystem.dto.EventDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Controller
@RestController("/damage")
public class CarDamageController {

    @PostMapping("/post-damage")
    public ResponseEntity<?> postDamage(@RequestHeader("Unique-Key") String key,
                                        @RequestBody CarDamageList carDamageList){

    }
}
