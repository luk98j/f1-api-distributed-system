package com.api.distributed.system.apisystem.controller;

import com.api.distributed.system.apisystem.dto.CarStatusList;
import com.api.distributed.system.apisystem.dto.FinalClasificationList;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController("/final-clasification")
@AllArgsConstructor
public class CarFinalClassificationController {

    @PostMapping("/post-clasification")
    public ResponseEntity<?> postClasification(@RequestHeader("Unique-Key") String key,
                                        @RequestBody FinalClasificationList finalClasificationList){

    }
}
