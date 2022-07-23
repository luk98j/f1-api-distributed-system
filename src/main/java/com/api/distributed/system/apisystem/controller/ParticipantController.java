package com.api.distributed.system.apisystem.controller;


import com.api.distributed.system.apisystem.dto.LapDataList;
import com.api.distributed.system.apisystem.dto.ParticipantListDto;
import com.api.distributed.system.apisystem.entity.ParticipantEntity;
import com.api.distributed.system.apisystem.repository.ParticipantRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("/participant-data")
@AllArgsConstructor
public class ParticipantController {
    @Autowired
    private ParticipantRepository participantRepository;

    @PostMapping("/post-participant")
    public ResponseEntity<?> postParticipant(@RequestHeader("Unique-Key") String key,
                                     @RequestBody ParticipantListDto participantListDto){
        System.out.println("Recived participant");
        System.out.println(participantListDto.toString());
        participantRepository.save(new ParticipantEntity(participantListDto.getSessionUid(), key,
                participantListDto.getParticipantDtoList(), new Timestamp(new Date().getTime())));
        return ResponseEntity.ok("Object saved");
    }
}
