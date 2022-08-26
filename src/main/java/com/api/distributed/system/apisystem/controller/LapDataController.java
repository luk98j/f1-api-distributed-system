package com.api.distributed.system.apisystem.controller;

import com.api.distributed.system.apisystem.dto.EventDto;
import com.api.distributed.system.apisystem.dto.LapDataDto;
import com.api.distributed.system.apisystem.dto.LapDataList;
import com.api.distributed.system.apisystem.dto.LapDataWithOrderDto;
import com.api.distributed.system.apisystem.entity.LapDataEntity;
import com.api.distributed.system.apisystem.repository.LapDataRepository;
import com.api.distributed.system.apisystem.service.LapDataService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/lap-data")
@AllArgsConstructor
public class LapDataController {
    @Autowired
    private LapDataService lapDataService;

    @PostMapping("/post-lap")
    public ResponseEntity<String> postLap(@RequestHeader("Unique-Key") String key,
                                         @RequestBody LapDataList lapDataList){
        return lapDataService.postData(key, lapDataList);
    }

    @GetMapping("/get-lap-data")
    public ResponseEntity<List<LapDataWithOrderDto>> getLap(@RequestParam BigInteger sessionUid, @RequestParam String key){
        return lapDataService.getAllData(sessionUid, key);
    }
}
