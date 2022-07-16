package com.api.distributed.system.apisystem.controller;

import com.api.distributed.system.apisystem.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event")
@AllArgsConstructor
public class EventController {

    @PostMapping("/main-event")
    public ResponseEntity<?> postSession(@RequestHeader("Unique-Key") String key,
                                                @RequestBody EventDto eventDto){
        System.out.println(key);
        System.out.println(eventDto);
        return ResponseEntity.ok("XD");
    }

    @PostMapping("/fastest-lap")
    public ResponseEntity<?> postFastestLap(@RequestHeader("Unique-Key") String key,
                                                @RequestBody FastestLapDto fastestLapDto){
        System.out.println(key);
        System.out.println(fastestLapDto);
        return ResponseEntity.ok("XD");
    }

    @PostMapping("/retirement")
    public ResponseEntity<?> postRetirement(@RequestHeader("Unique-Key") String key,
                                            @RequestBody CarEventDto carEventDto){
        System.out.println(key);
        System.out.println(carEventDto);
        return ResponseEntity.ok("XD");
    }

    @PostMapping("/drs")
    public ResponseEntity<?> postDrs(@RequestHeader("Unique-Key") String key,
                                            @RequestBody DrsDto drsDto){
        System.out.println(key);
        System.out.println(drsDto);
        return ResponseEntity.ok("XD");
    }

    @PostMapping("/team-pits")
    public ResponseEntity<?> postTeamPits(@RequestHeader("Unique-Key") String key,
                                     @RequestBody CarEventDto carEventDto){
        System.out.println(carEventDto);
        System.out.println(key);
        return ResponseEntity.ok("XD");
    }

    @PostMapping("/race-winner")
    public ResponseEntity<?> postRaceWinner(@RequestHeader("Unique-Key") String key,
                                     @RequestBody CarEventDto carEventDto){
        System.out.println(key);
        System.out.println(carEventDto);
        return ResponseEntity.ok("XD");
    }

    @PostMapping("/penalty")
    public ResponseEntity<?> postPenalty(@RequestHeader("Unique-Key") String key,
                                     @RequestBody PenaltyDto penaltyDto){
        System.out.println(penaltyDto);
        return ResponseEntity.ok("XD");
    }
}
