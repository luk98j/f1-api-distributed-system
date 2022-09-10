package com.api.distributed.system.apisystem.controller;

import com.api.distributed.system.apisystem.dto.CarStatusList;
import com.api.distributed.system.apisystem.service.CarStatusService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
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
}
