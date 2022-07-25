package com.api.distributed.system.apisystem.controller;

import com.api.distributed.system.apisystem.entity.SessionEntity;
import com.api.distributed.system.apisystem.repository.PacketSessionRepository;
import com.api.distributed.system.apisystem.service.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("/session-data")
@AllArgsConstructor
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping("/post-session")
    public ResponseEntity<String> postSession(@RequestHeader("Unique-Key") String key,
                                     @RequestBody com.f1distributedsystem.f1clientapp.dto.impl.PacketSessionDto packetSessionDto){
        return sessionService.postSession(key, packetSessionDto);
    }
}
