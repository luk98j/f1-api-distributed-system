package com.api.distributed.system.apisystem.service;

import com.api.distributed.system.apisystem.dto.*;
import com.api.distributed.system.apisystem.entity.FastestLapEntity;
import com.api.distributed.system.apisystem.entity.ParticipantEntity;
import com.api.distributed.system.apisystem.entity.RaceEventEntity;
import com.api.distributed.system.apisystem.enums.PenaltyType;
import com.api.distributed.system.apisystem.enums.PitStatus;
import com.api.distributed.system.apisystem.enums.ResultStatus;
import com.api.distributed.system.apisystem.repository.FastestLapRepository;
import com.api.distributed.system.apisystem.repository.ParticipantRepository;
import com.api.distributed.system.apisystem.repository.RaceEventRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@Service
public class EventService {

    @Autowired
    private RaceEventRepository raceEventRepository;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private FastestLapRepository fastestLapRepository;
    @Autowired
    private ParticipantRepository participantRepository;

    public ResponseEntity<String> postSession(String key,
                                              EventDto eventDto){
        raceEventRepository.save(new RaceEventEntity(eventDto.getSessionUid(),key,
                eventDto.getEventName(),""));
        return ResponseEntity.ok("Object saved");
    }


    public ResponseEntity<String> postFastestLap(String key,
                                                 FastestLapDto fastestLapDto){
        fastestLapRepository.save(new FastestLapEntity(fastestLapDto.getSessionUid(),
                key, fastestLapDto, new Timestamp(new Date().getTime())));
        if(participantRepository.existsBySessionUidAndKey(fastestLapDto.getSessionUid(), key)){
            ParticipantEntity participantEntity = participantRepository.findFirstBySessionUidAndKeyOrderByTimestampDesc(fastestLapDto.getSessionUid(), key);
            for(int i=0; i< participantEntity.getParticipantListDtoList().size(); i++){
                if(participantEntity.getParticipantListDtoList().get(i).isFastestLap() &&
                        participantEntity.getParticipantListDtoList().get(i).getCarIndex() != fastestLapDto.getCarId()) {
                    participantEntity.getParticipantListDtoList().get(i).setFastestLap(false);
                } else if(participantEntity.getParticipantListDtoList().get(i).getCarIndex() == fastestLapDto.getCarId()){
                    participantEntity.getParticipantListDtoList().get(i).setFastestLap(true);
                }
            }
            participantRepository.save(participantEntity);
        }
        return ResponseEntity.ok("Object saved");
    }


    public ResponseEntity<String> postRetirement(String key,
                                                 CarEventDto carEventDto){
        if(participantRepository.existsBySessionUidAndKey(carEventDto.getSessionUid(), key)){
            ParticipantEntity participantEntity = participantRepository.findFirstBySessionUidAndKeyOrderByTimestampDesc(carEventDto.getSessionUid(), key);
            for(int i=0; i< participantEntity.getParticipantListDtoList().size(); i++){
                if(participantEntity.getParticipantListDtoList().get(i).getCarIndex() == carEventDto.getCarId()){
                    participantEntity.getParticipantListDtoList().get(i).setResultStatus(ResultStatus.RETIRED);
                }
            }
            participantRepository.save(participantEntity);
        }
        return ResponseEntity.ok("Object saved");
    }


    public ResponseEntity<String> postDrs(String key,
                                          DrsDto drsDto){
        raceEventRepository.save(new RaceEventEntity(drsDto.getSessionUid(),key,
                "drs", String.valueOf(drsDto.isEnable())));
        return ResponseEntity.ok("Object saved");
    }

    @PostMapping("/team-pits")
    public ResponseEntity<String> postTeamPits(@RequestHeader("Unique-Key") String key,
                                               @RequestBody CarEventDto carEventDto){
        if(participantRepository.existsBySessionUidAndKey(carEventDto.getSessionUid(), key)){
            ParticipantEntity participantEntity = participantRepository.findFirstBySessionUidAndKeyOrderByTimestampDesc(carEventDto.getSessionUid(), key);
            for(int i=0; i< participantEntity.getParticipantListDtoList().size(); i++){
                if(participantEntity.getParticipantListDtoList().get(i).getCarIndex() == carEventDto.getCarId()){
                    participantEntity.getParticipantListDtoList().get(i).setPitStatus(PitStatus.PITTING);
                }
            }
            participantRepository.save(participantEntity);
        }
        raceEventRepository.save(new RaceEventEntity(carEventDto.getSessionUid(),key,
                "team-pit",String.valueOf(carEventDto.getCarId())));
        return ResponseEntity.ok("Object saved");
    }

    public ResponseEntity<String> postRaceWinner(String key,
                                                 CarEventDto carEventDto){
        //todo
        //Participant table should be edited here
        raceEventRepository.save(new RaceEventEntity(carEventDto.getSessionUid(),key,
                "race-winner",String.valueOf(carEventDto.getCarId())));
        return ResponseEntity.ok("Object saved");
    }


    public ResponseEntity<String> postPenalty(String key,
                                              PenaltyDto penaltyDto){
        //todo
        if(participantRepository.existsBySessionUidAndKey(penaltyDto.getSessionUid(), key)){
            ParticipantEntity participantEntity = participantRepository.findFirstBySessionUidAndKeyOrderByTimestampDesc(penaltyDto.getSessionUid(), key);
            for(int i=0; i< participantEntity.getParticipantListDtoList().size(); i++){
                if(participantEntity.getParticipantListDtoList().get(i).getCarIndex() == penaltyDto.getCarId()){
                    participantEntity.getParticipantListDtoList().get(i).addPenalty(PenaltyType.valueOf(penaltyDto.getPenaltyType()), Integer.parseInt(penaltyDto.getTime()));
                }
            }
            participantRepository.save(participantEntity);
        }
        return ResponseEntity.ok("Object saved");
    }
}