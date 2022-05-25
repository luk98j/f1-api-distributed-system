package com.api.distributed.system.apisystem.controller;

import com.api.distributed.system.apisystem.dto.CarStatusList;
import com.api.distributed.system.apisystem.dto.CarTelemetryList;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController("/car-telemetry")
@AllArgsConstructor
public class CarTelemetryController {

    @PostMapping("/post-telemetry")
    public ResponseEntity<?> postStatus(@RequestHeader("Unique-Key") String key,
                                        @RequestBody CarTelemetryList carTelemetryList){

    }
}
