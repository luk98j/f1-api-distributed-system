package com.api.distributed.system.apisystem.controller;

import com.api.distributed.system.apisystem.dto.EventDto;
import com.api.distributed.system.apisystem.dto.LapDataDto;
import com.api.distributed.system.apisystem.dto.LapDataList;
import com.api.distributed.system.apisystem.entity.LapDataEntity;
import com.api.distributed.system.apisystem.repository.LapDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("/lap-data")
@AllArgsConstructor
public class LapDataController {
    @Autowired
    private LapDataRepository lapDataRepository;

    @PostMapping("/post-lap")
    public ResponseEntity<?> postLap(@RequestHeader("Unique-Key") String key,
                                         @RequestBody LapDataList lapDataList){
        lapDataRepository.save(new LapDataEntity(lapDataList.getSessionUid(), key, lapDataList.getLapDataDtoList(),
                new Timestamp(new Date().getTime())));
        return ResponseEntity.ok("Object saved");
    }
}
