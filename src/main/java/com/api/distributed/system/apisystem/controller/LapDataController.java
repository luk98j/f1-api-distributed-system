package com.api.distributed.system.apisystem.controller;

import com.api.distributed.system.apisystem.dto.EventDto;
import com.api.distributed.system.apisystem.dto.LapDataDto;
import com.api.distributed.system.apisystem.dto.LapDataList;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lap-data")
@AllArgsConstructor
public class LapDataController {

    @PostMapping("/post-lap")
    public ResponseEntity<?> postLap(@RequestHeader("Unique-Key") String key,
                                         @RequestBody LapDataList lapDataList){
//        System.out.println(key);
//        for (LapDataDto lapDataDto:lapDataList.getLapDataDtoList()){
//            System.out.println(lapDataDto.toString());
//        }

        return ResponseEntity.ok("XD");
    }
}
