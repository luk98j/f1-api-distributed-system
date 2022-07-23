package com.api.distributed.system.apisystem.service;

import com.api.distributed.system.apisystem.repository.ParticipantRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class SessionService {

    @Autowired
    private ParticipantRepository participantRepository;

    public boolean checkIfParticipantTableExistsWithKeyAndSessionId(BigDecimal sessionId, String sessionKey){
        return participantRepository.existsBySessionUidAndKey(sessionId, sessionKey);
    }
}
