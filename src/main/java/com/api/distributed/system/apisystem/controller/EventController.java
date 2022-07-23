package com.api.distributed.system.apisystem.controller;

import com.api.distributed.system.apisystem.dto.*;
import com.api.distributed.system.apisystem.entity.FastestLapEntity;
import com.api.distributed.system.apisystem.entity.ParticipantEntity;
import com.api.distributed.system.apisystem.entity.RaceEventEntity;
import com.api.distributed.system.apisystem.enums.ResultStatus;
import com.api.distributed.system.apisystem.repository.FastestLapRepository;
import com.api.distributed.system.apisystem.repository.ParticipantRepository;
import com.api.distributed.system.apisystem.repository.RaceEventRepository;
import com.api.distributed.system.apisystem.service.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("/event")
@AllArgsConstructor
public class EventController {

    @Autowired
    private RaceEventRepository raceEventRepository;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private FastestLapRepository fastestLapRepository;
    @Autowired
    private ParticipantRepository participantRepository;

    @PostMapping("/main-event")
    public ResponseEntity<?> postSession(@RequestHeader("Unique-Key") String key,
                                                @RequestBody EventDto eventDto){
        raceEventRepository.save(new RaceEventEntity(eventDto.getSessionUid(),key,
                eventDto.getEventName(),""));
        return ResponseEntity.ok("Object saved");
    }

    @PostMapping("/fastest-lap")
    public ResponseEntity<?> postFastestLap(@RequestHeader("Unique-Key") String key,
                                                @RequestBody FastestLapDto fastestLapDto){

        fastestLapRepository.save(new FastestLapEntity(fastestLapDto.getSessionUid(),
                key, fastestLapDto, new Timestamp(new Date().getTime())));
        return ResponseEntity.ok("Object saved");
    }

    @PostMapping("/retirement")
    public ResponseEntity<?> postRetirement(@RequestHeader("Unique-Key") String key,
                                            @RequestBody CarEventDto carEventDto){
        //todo
        //Participant table should be edited here
        if(participantRepository.existsBySessionUidAndKey(carEventDto.getSessionUid(), key)){
            ParticipantEntity participantEntity = participantRepository.findFirstBySessionUidAndKeyOrderByTimestampDesc(carEventDto.getSessionUid(), key);
            ParticipantDto participantDto = participantEntity.getParticipantListDtoList().get(carEventDto.getCarId());
            participantDto.setResultStatus(ResultStatus.RETIRED);

        } else {

        }
        return ResponseEntity.ok("Object saved");
    }

    @PostMapping("/drs")
    public ResponseEntity<?> postDrs(@RequestHeader("Unique-Key") String key,
                                            @RequestBody DrsDto drsDto){
        raceEventRepository.save(new RaceEventEntity(drsDto.getSessionUid(),key,
                "drs", String.valueOf(drsDto.isEnable())));
        return ResponseEntity.ok("Object saved");
    }

    @PostMapping("/team-pits")
    public ResponseEntity<?> postTeamPits(@RequestHeader("Unique-Key") String key,
                                     @RequestBody CarEventDto carEventDto){
        //todo
        //Participant table should be edited here
        raceEventRepository.save(new RaceEventEntity(carEventDto.getSessionUid(),key,
                "team-pit",String.valueOf(carEventDto.getCarId())));
        return ResponseEntity.ok("Object saved");
    }

    @PostMapping("/race-winner")
    public ResponseEntity<?> postRaceWinner(@RequestHeader("Unique-Key") String key,
                                     @RequestBody CarEventDto carEventDto){
        //todo
        //Participant table should be edited here
        raceEventRepository.save(new RaceEventEntity(carEventDto.getSessionUid(),key,
                "race-winner",String.valueOf(carEventDto.getCarId())));
        return ResponseEntity.ok("Object saved");
    }

    @PostMapping("/penalty")
    public ResponseEntity<?> postPenalty(@RequestHeader("Unique-Key") String key,
                                     @RequestBody PenaltyDto penaltyDto){
        //todo
        //Participant table should be edited here
        return ResponseEntity.ok("Object saved");
    }
}
