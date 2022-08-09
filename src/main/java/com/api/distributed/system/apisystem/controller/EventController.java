package com.api.distributed.system.apisystem.controller;

import com.api.distributed.system.apisystem.dto.*;
import com.api.distributed.system.apisystem.entity.FastestLapEntity;
import com.api.distributed.system.apisystem.entity.ParticipantEntity;
import com.api.distributed.system.apisystem.entity.RaceEventEntity;
import com.api.distributed.system.apisystem.enums.PenaltyType;
import com.api.distributed.system.apisystem.enums.PitStatus;
import com.api.distributed.system.apisystem.enums.ResultStatus;
import com.api.distributed.system.apisystem.repository.FastestLapRepository;
import com.api.distributed.system.apisystem.repository.ParticipantRepository;
import com.api.distributed.system.apisystem.repository.RaceEventRepository;
import com.api.distributed.system.apisystem.service.EventService;
import com.api.distributed.system.apisystem.service.FastestLapService;
import com.api.distributed.system.apisystem.service.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("/event")
@AllArgsConstructor
public class EventController {

    @Autowired
    private EventService eventService;
    @Autowired
    private FastestLapService fastestLapService;

    @PostMapping("/main-event")
    public ResponseEntity<String> postSession(@RequestHeader("Unique-Key") String key,
                                                @RequestBody EventDto eventDto){
        return eventService.postSession(key, eventDto);
    }

    @PostMapping("/fastest-lap")
    public ResponseEntity<String> postFastestLap(@RequestHeader("Unique-Key") String key,
                                                @RequestBody FastestLapDto fastestLapDto){
        return fastestLapService.postFastestLap(key, fastestLapDto);
    }

    @PostMapping("/retirement")
    public ResponseEntity<String> postRetirement(@RequestHeader("Unique-Key") String key,
                                            @RequestBody CarEventDto carEventDto){
        return eventService.postRetirement(key, carEventDto);
    }

    @PostMapping("/drs")
    public ResponseEntity<String> postDrs(@RequestHeader("Unique-Key") String key,
                                            @RequestBody DrsDto drsDto){
        return eventService.postDrs(key, drsDto);
    }

    @PostMapping("/team-pits")
    public ResponseEntity<String> postTeamPits(@RequestHeader("Unique-Key") String key,
                                     @RequestBody CarEventDto carEventDto){
       return eventService.postTeamPits(key, carEventDto);
    }

    @PostMapping("/race-winner")
    public ResponseEntity<String> postRaceWinner(@RequestHeader("Unique-Key") String key,
                                     @RequestBody CarEventDto carEventDto){
        return eventService.postRaceWinner(key, carEventDto);
    }

    @PostMapping("/penalty")
    public ResponseEntity<String> postPenalty(@RequestHeader("Unique-Key") String key,
                                     @RequestBody PenaltyDto penaltyDto){
        return eventService.postPenalty(key, penaltyDto);
    }
}
