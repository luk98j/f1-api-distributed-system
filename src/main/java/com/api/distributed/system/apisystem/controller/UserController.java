package com.api.distributed.system.apisystem.controller;

import com.api.distributed.system.apisystem.dto.KeyDto;
import com.api.distributed.system.apisystem.service.KeyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-data")
@AllArgsConstructor
public class UserController {

    @Autowired
    private KeyService keyService;

    @GetMapping("/check-key")
    public ResponseEntity<KeyDto> getKey(@RequestParam String key){
        return keyService.checkIfKeyExistsAndReturnIt(key);
    }
}
