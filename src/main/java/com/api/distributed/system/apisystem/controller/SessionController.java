package com.api.distributed.system.apisystem.controller;

import com.api.distributed.system.apisystem.dto.PacketSessionDto;
import com.api.distributed.system.apisystem.dto.SessionInfoDto;
import com.api.distributed.system.apisystem.service.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@CrossOrigin
@RequestMapping("/session-data")
@AllArgsConstructor
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping("/post-session")
    public ResponseEntity<String> postSession(@RequestHeader("Unique-Key") String key,
                                     @RequestBody PacketSessionDto packetSessionDto){
        return sessionService.postSession(key, packetSessionDto);
    }

    @GetMapping("/get-session-information")
    public ResponseEntity<SessionInfoDto> getSessionInformation(@RequestParam BigInteger sessionUid, @RequestParam String key){
        return sessionService.getSessionInformation(sessionUid,key);
    }

}
