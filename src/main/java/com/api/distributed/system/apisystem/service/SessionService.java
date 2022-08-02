package com.api.distributed.system.apisystem.service;

import com.api.distributed.system.apisystem.dto.PacketSessionDto;
import com.api.distributed.system.apisystem.entity.BasicEntity;
import com.api.distributed.system.apisystem.entity.SessionEntity;
import com.api.distributed.system.apisystem.repository.PacketSessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class SessionService extends BasicService{

    @Autowired
    private PacketSessionRepository packetSessionRepository;


    public ResponseEntity<String> postSession(String key,
                                              PacketSessionDto packetSessionDto){
        packetSessionRepository.save(new SessionEntity(packetSessionDto.getSessionid(), key, packetSessionDto,
                new Date()));
        return ResponseEntity.ok("Object saved");
    }

    @Override
    public List<SessionEntity> getListByKey(String key){
        return packetSessionRepository.findAllByKey(key);
    }

    @Override
    public <T extends BasicEntity> void deleteEntity(T tClass) {
        packetSessionRepository.delete((SessionEntity) tClass);
    }

}
