package com.api.distributed.system.apisystem.service;

import com.api.distributed.system.apisystem.dto.KeyDto;
import com.api.distributed.system.apisystem.entity.KeyEntity;
import com.api.distributed.system.apisystem.repository.KeyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class KeyService {
    @Autowired
    private KeyRepository keyRepository;

    public ResponseEntity<KeyDto> checkIfKeyExistsAndReturnIt(String key){
        List<KeyEntity> keyEntityList = keyRepository.findByKey(key);
        //todo
        // check if sort is working !
        if(!keyEntityList.isEmpty()){
            keyEntityList.sort((e1, e2)->  e1.getTimestamp().compareTo(e2.getTimestamp()));
            return ResponseEntity.ok(new KeyDto(keyEntityList.get(0).getSessionUid(), keyEntityList.get(0).getKey()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
