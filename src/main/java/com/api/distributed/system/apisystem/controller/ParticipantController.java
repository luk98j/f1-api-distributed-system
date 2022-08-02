package com.api.distributed.system.apisystem.controller;


import com.api.distributed.system.apisystem.dto.LapDataList;
import com.api.distributed.system.apisystem.dto.ParticipantDto;
import com.api.distributed.system.apisystem.dto.ParticipantExtendDto;
import com.api.distributed.system.apisystem.dto.ParticipantListDto;
import com.api.distributed.system.apisystem.entity.KeyEntity;
import com.api.distributed.system.apisystem.entity.ParticipantEntity;
import com.api.distributed.system.apisystem.enums.PitStatus;
import com.api.distributed.system.apisystem.enums.ResultStatus;
import com.api.distributed.system.apisystem.repository.KeyRepository;
import com.api.distributed.system.apisystem.repository.ParticipantRepository;
import com.api.distributed.system.apisystem.service.ParticipantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/participant-data")
@AllArgsConstructor
public class ParticipantController {
    @Autowired
    private ParticipantService participantService;

    @PostMapping("/post-participant")
    public ResponseEntity<String> postParticipant(@RequestHeader("Unique-Key") String key,
                                     @RequestBody ParticipantListDto participantListDto){
        return participantService.postParticipant(key, participantListDto);
    }

    @GetMapping("/get-last-participants")
    public ResponseEntity<List<ParticipantEntity>> getParticipant(@RequestParam BigInteger sessionUid, @RequestParam String key){
        System.out.println(new Date());
        return participantService.getLastParticipantData(sessionUid, key);
    }
}
