package com.api.distributed.system.apisystem.service;

import com.api.distributed.system.apisystem.entity.BasicEntity;
import com.api.distributed.system.apisystem.entity.ParticipantEntity;
import com.api.distributed.system.apisystem.entity.RaceEventEntity;
import com.api.distributed.system.apisystem.entity.SessionEntity;
import com.api.distributed.system.apisystem.repository.PacketSessionRepository;
import com.api.distributed.system.apisystem.repository.ParticipantRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class SessionService extends BasicService{

    @Autowired
    private PacketSessionRepository packetSessionRepository;


    public ResponseEntity<String> postSession(String key,
                                              com.f1distributedsystem.f1clientapp.dto.impl.PacketSessionDto packetSessionDto){
        packetSessionRepository.save(new SessionEntity(packetSessionDto.getSessionid(), key, packetSessionDto,
                new Timestamp(new Date().getTime())));
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
