package com.api.distributed.system.apisystem.service;

import com.api.distributed.system.apisystem.dto.LapDataList;
import com.api.distributed.system.apisystem.entity.LapDataEntity;
import com.api.distributed.system.apisystem.repository.LapDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.sql.Timestamp;
import java.util.Date;

@Service
@AllArgsConstructor
public class LapDataService {

    @Autowired
    private LapDataRepository lapDataRepository;


    public ResponseEntity<String> postData(String key,
                                          LapDataList lapDataList){
        lapDataRepository.save(new LapDataEntity(lapDataList.getSessionUid(), key, lapDataList.getLapDataDtoList(),
                new Timestamp(new Date().getTime())));
        return ResponseEntity.ok("Object saved");
    }
}
