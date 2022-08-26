package com.api.distributed.system.apisystem.service;

import com.api.distributed.system.apisystem.dto.ParticipantDto;
import com.api.distributed.system.apisystem.dto.ParticipantExtendDto;
import com.api.distributed.system.apisystem.dto.ParticipantListDto;
import com.api.distributed.system.apisystem.entity.*;
import com.api.distributed.system.apisystem.enums.PitStatus;
import com.api.distributed.system.apisystem.enums.ResultStatus;
import com.api.distributed.system.apisystem.repository.KeyRepository;
import com.api.distributed.system.apisystem.repository.ParticipantRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ParticipantService extends BasicService{
    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private KeyRepository keyRepository;



    public ResponseEntity<String> postParticipant(String key,
                                                  ParticipantListDto participantListDto){
        System.out.println("Recived participant");
        System.out.println(participantListDto.toString());
        if(!checkIfParticipantTableExistsWithKeyAndSessionId(participantListDto.getSessionUid(), key)){
            keyRepository.save(new KeyEntity(participantListDto.getSessionUid(), key, new Date()));
            List<ParticipantExtendDto> participantExtendDtoList = new ArrayList<>();
            for (ParticipantDto participantDto: participantListDto.getParticipantDtoList()){
                participantExtendDtoList.add(new ParticipantExtendDto(
                        participantDto.getCarIndex(),
                        participantDto.getDriverId(),
                        participantDto.getNetworkId(),
                        participantDto.getName(),
                        participantDto.getYourTelemetry(),
                        ResultStatus.ACTIVE,
                        PitStatus.NONE,
                        false,
                        new ArrayList<>(),
                        0
                ));
            }
            participantRepository.save(new ParticipantEntity(participantListDto.getSessionUid(), key,
                    participantExtendDtoList, new Date()));
            return ResponseEntity.ok("Object saved");
        } else {
            return ResponseEntity.ok("Object exists");
        }
    }

    @Override
    public List<ParticipantEntity> getListByKey(String key){
        return participantRepository.findAllByKey(key);
    }

    private boolean checkIfParticipantTableExistsWithKeyAndSessionId(BigInteger sessionId, String sessionKey){
        return participantRepository.existsBySessionUidAndKey(sessionId, sessionKey);
    }

    @Override
    public <T extends BasicEntity> void deleteEntity(T tClass) {
        participantRepository.delete((ParticipantEntity) tClass);
    }

    public ResponseEntity<ParticipantEntity> getLastParticipantData(BigInteger sessionUid, String key) {
        return ResponseEntity.ok(participantRepository.findFirstBySessionUidAndKeyOrderByDateDesc(sessionUid, key));
    }

    public List<ParticipantExtendDto> getLastParticipant(BigInteger sessionUid, String key){
        return participantRepository.findFirstBySessionUidAndKeyOrderByDateDesc(sessionUid, key).getParticipantListDtoList();
    }

    public String getParticipantName(int carId, BigInteger sessionUid, String key){
        ParticipantEntity participantEntity = participantRepository.findFirstBySessionUidAndKeyOrderByDateDesc(sessionUid,key);
        for(ParticipantExtendDto participantExtendDto:participantEntity.getParticipantListDtoList()){
            if(participantExtendDto.getCarIndex() == carId){
                return participantExtendDto.getDriverId().name();
            }
        }
        return null;
    }
}
