package com.api.distributed.system.apisystem.controller;

import com.api.distributed.system.apisystem.dto.EventDto;
import com.api.distributed.system.apisystem.dto.LapDataList;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController("/lap-data")
@AllArgsConstructor
public class LapDataController {

    @PostMapping("/post-lap")
    public ResponseEntity<?> postLap(@RequestHeader("Unique-Key") String key,
                                         @RequestBody LapDataList lapDataList){

    }
}
