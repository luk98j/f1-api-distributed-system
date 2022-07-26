package com.api.distributed.system.apisystem.service;

import com.api.distributed.system.apisystem.dto.KeyDto;
import com.api.distributed.system.apisystem.entity.BasicEntity;
import com.api.distributed.system.apisystem.entity.KeyEntity;
import com.api.distributed.system.apisystem.entity.RaceEventEntity;
import com.api.distributed.system.apisystem.repository.KeyRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class KeyService extends BasicService{
    private static final long TWO_DAYS = 3600 * 48;
    @Autowired
    private final KeyRepository keyRepository;

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

    public List<KeyEntity> getListWithAllKeysOlderThanTwoDays(){
        List<KeyEntity> keyEntityList = keyRepository.findAll();
        List<KeyEntity> keyEntityListOlderThanTwoDays = new ArrayList<>();
        long twoDaysAgo = new Timestamp(new Date().getTime()).getTime() - TWO_DAYS;
        if(!keyEntityList.isEmpty()){
            for(KeyEntity keyEntity: keyEntityList){
                if(keyEntity.getTimestamp().getTime() < twoDaysAgo){
                    keyEntityListOlderThanTwoDays.add(keyEntity);
                }
            }
        }
        return keyEntityListOlderThanTwoDays;
    }

    @Override
    public <T extends BasicEntity> void deleteEntity(T tClass) {
        keyRepository.delete((KeyEntity) tClass);
    }
}
