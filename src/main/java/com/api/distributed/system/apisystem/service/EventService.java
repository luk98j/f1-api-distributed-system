package com.api.distributed.system.apisystem.service;

import com.api.distributed.system.apisystem.dto.*;
import com.api.distributed.system.apisystem.entity.*;
import com.api.distributed.system.apisystem.enums.PenaltyType;
import com.api.distributed.system.apisystem.enums.PitStatus;
import com.api.distributed.system.apisystem.enums.ResultStatus;
import com.api.distributed.system.apisystem.repository.ParticipantRepository;
import com.api.distributed.system.apisystem.repository.RaceEventRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class EventService extends BasicService{

    @Autowired
    private RaceEventRepository raceEventRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    public ResponseEntity<String> postSession(String key,
                                              EventDto eventDto){
        raceEventRepository.save(new RaceEventEntity(eventDto.getSessionUid(),key,
                eventDto.getEventName(),"",new Date()));
        return ResponseEntity.ok("Object saved");
    }

    public ResponseEntity<String> postRetirement(String key,
                                                 CarEventDto carEventDto){
        if(participantRepository.existsBySessionUidAndKey(carEventDto.getSessionUid(), key)){
            List<ParticipantEntity> participantEntityList = participantRepository.findAllBySessionUidAndKey(carEventDto.getSessionUid(), key);
            ParticipantEntity participantEntity = compareTimestamps(participantEntityList);
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
                "drs", String.valueOf(drsDto.isEnable()), new Date()));
        return ResponseEntity.ok("Object saved");
    }


    public ResponseEntity<String> postTeamPits(String key,
                                               CarEventDto carEventDto){
        if(participantRepository.existsBySessionUidAndKey(carEventDto.getSessionUid(), key)){
            List<ParticipantEntity> participantEntityList = participantRepository.findAllBySessionUidAndKey(carEventDto.getSessionUid(), key);
            ParticipantEntity participantEntity = compareTimestamps(participantEntityList);
            for(int i=0; i< participantEntity.getParticipantListDtoList().size(); i++){
                if(participantEntity.getParticipantListDtoList().get(i).getCarIndex() == carEventDto.getCarId()){
                    participantEntity.getParticipantListDtoList().get(i).setPitStatus(PitStatus.PITTING);
                }
            }
            participantRepository.save(participantEntity);
        }
        raceEventRepository.save(new RaceEventEntity(carEventDto.getSessionUid(),key,
                "team-pit",String.valueOf(carEventDto.getCarId()), new Date()));
        return ResponseEntity.ok("Object saved");
    }

    public ResponseEntity<String> postRaceWinner(String key,
                                                 CarEventDto carEventDto){
        //todo
        //Participant table should be edited here
        raceEventRepository.save(new RaceEventEntity(carEventDto.getSessionUid(),key,
                "race-winner",String.valueOf(carEventDto.getCarId()),new Date()));
        return ResponseEntity.ok("Object saved");
    }


    public ResponseEntity<String> postPenalty(String key,
                                              PenaltyDto penaltyDto){

        if(participantRepository.existsBySessionUidAndKey(penaltyDto.getSessionUid(), key)){
            List<ParticipantEntity> participantEntityList = participantRepository.findAllBySessionUidAndKey(penaltyDto.getSessionUid(), key);
            ParticipantEntity participantEntity = compareTimestamps(participantEntityList);
            for(int i=0; i< participantEntity.getParticipantListDtoList().size(); i++){
                if(participantEntity.getParticipantListDtoList().get(i).getCarIndex() == penaltyDto.getCarId()){
                    participantEntity.getParticipantListDtoList().get(i).addPenalty(PenaltyType.valueOf(penaltyDto.getPenaltyType()), Integer.parseInt(penaltyDto.getTime()));
                }
            }
            participantRepository.save(participantEntity);
        }
        return ResponseEntity.ok("Object saved");
    }

    @Override
    public List<RaceEventEntity> getListByKey(String key){
        return raceEventRepository.findAllByKey(key);
    }

    @Override
    public <T extends BasicEntity> void deleteEntity(T tClass) {
        raceEventRepository.delete((RaceEventEntity) tClass);
    }

    private ParticipantEntity compareTimestamps(List<ParticipantEntity> participantEntityList){
        if(participantEntityList.size()==1){
            return participantEntityList.get(0);
        } else if (participantEntityList.size() > 1){
            ParticipantEntity firstParticipantEntity = participantEntityList.get(0);
            for(ParticipantEntity participantEntity:participantEntityList){
                if(firstParticipantEntity.getDate().getTime() > participantEntity.getDate().getTime() ){
                    firstParticipantEntity = participantEntity;
                }
            }
            return firstParticipantEntity;
        } else {
            return  participantEntityList.get(0);
        }
    }

    public ResponseEntity<EventDto> getLastEvent(String key, BigInteger sessionUid) {
        RaceEventEntity raceEventEntity = raceEventRepository.findFirstBySessionUidAndKeyOrderByDateDesc(sessionUid,key);
        if(raceEventEntity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            String newEventKey;
            if(raceEventEntity.getEventKey().contains("_")){
                newEventKey = raceEventEntity.getEventKey().replace("_"," ");
            } else {
                newEventKey = raceEventEntity.getEventKey();
            }
            if(raceEventEntity.getValue().length() != 0){
                EventExtendedDto eventExtendedDto = new EventExtendedDto(raceEventEntity.getSessionUid(),newEventKey, raceEventEntity.getValue());
                return ResponseEntity.ok(eventExtendedDto);
            } else {
                EventExtendedDto eventDto = new EventExtendedDto(raceEventEntity.getSessionUid(), newEventKey, "");
                return ResponseEntity.ok(eventDto);
            }
        }

    }
}
