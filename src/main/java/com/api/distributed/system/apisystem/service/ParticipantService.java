package com.api.distributed.system.apisystem.service;

import com.api.distributed.system.apisystem.dto.ParticipantDto;
import com.api.distributed.system.apisystem.dto.ParticipantExtendDto;
import com.api.distributed.system.apisystem.dto.ParticipantListDto;
import com.api.distributed.system.apisystem.entity.KeyEntity;
import com.api.distributed.system.apisystem.entity.ParticipantEntity;
import com.api.distributed.system.apisystem.enums.PitStatus;
import com.api.distributed.system.apisystem.enums.ResultStatus;
import com.api.distributed.system.apisystem.repository.KeyRepository;
import com.api.distributed.system.apisystem.repository.ParticipantRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ParticipantService {
    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private KeyRepository keyRepository;


    public ResponseEntity<String> postParticipant(String key,
                                                  ParticipantListDto participantListDto){
        System.out.println("Recived participant");
        System.out.println(participantListDto.toString());
        if(!participantRepository.existsBySessionUidAndKey(participantListDto.getSessionUid(), key)){
            keyRepository.save(new KeyEntity(participantListDto.getSessionUid(), key, new Timestamp(new Date().getTime())));
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
                    participantExtendDtoList, new Timestamp(new Date().getTime())));
            return ResponseEntity.ok("Object saved");
        } else {
            return ResponseEntity.ok("Object exists");
        }
    }
}
