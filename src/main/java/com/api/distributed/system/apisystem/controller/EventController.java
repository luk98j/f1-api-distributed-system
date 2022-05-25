package com.api.distributed.system.apisystem.controller;

import com.api.distributed.system.apisystem.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController("/event")
@AllArgsConstructor
public class EventController {

    @PostMapping("/main-event")
    public ResponseEntity<?> postSession(@RequestHeader("Unique-Key") String key,
                                                @RequestBody EventDto eventDto){

    }

    @PostMapping("/fastest-lap")
    public ResponseEntity<?> postFastestLap(@RequestHeader("Unique-Key") String key,
                                                @RequestBody FastestLapDto fastestLapDto){

    }

    @PostMapping("/retirement")
    public ResponseEntity<?> postRetirement(@RequestHeader("Unique-Key") String key,
                                            @RequestBody CarEventDto carEventDto){

    }

    @PostMapping("/drs")
    public ResponseEntity<?> postDrs(@RequestHeader("Unique-Key") String key,
                                            @RequestBody DrsDto drsDto){

    }

    @PostMapping("/team-pits")
    public ResponseEntity<?> postDrs(@RequestHeader("Unique-Key") String key,
                                     @RequestBody CarEventDto carEventDto){

    }

    @PostMapping("/race-winner")
    public ResponseEntity<?> postDrs(@RequestHeader("Unique-Key") String key,
                                     @RequestBody CarEventDto carEventDto){

    }

    @PostMapping("/penalty")
    public ResponseEntity<?> postDrs(@RequestHeader("Unique-Key") String key,
                                     @RequestBody PenaltyDto penaltyDto){

    }
}
