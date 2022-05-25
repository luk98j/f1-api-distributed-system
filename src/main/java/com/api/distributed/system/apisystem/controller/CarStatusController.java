package com.api.distributed.system.apisystem.controller;

import com.api.distributed.system.apisystem.dto.CarDamageList;
import com.api.distributed.system.apisystem.dto.CarStatusList;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController("/car-status")
@AllArgsConstructor
public class CarStatusController {

    @PostMapping("/post-status")
    public ResponseEntity<?> postStatus(@RequestHeader("Unique-Key") String key,
                                        @RequestBody CarStatusList carStatusList){

    }
}
