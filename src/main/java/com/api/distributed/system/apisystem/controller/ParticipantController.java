package com.api.distributed.system.apisystem.controller;


import com.api.distributed.system.apisystem.dto.LapDataList;
import com.api.distributed.system.apisystem.dto.ParticipantListDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController("/participant-data")
@AllArgsConstructor
public class ParticipantController {

    @PostMapping("/post-participant")
    public ResponseEntity<?> postParticipant(@RequestHeader("Unique-Key") String key,
                                     @RequestBody ParticipantListDto participantListDto){

    }
}
