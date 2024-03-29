package com.api.distributed.system.apisystem.service;

import com.api.distributed.system.apisystem.dto.FastestLapDto;
import com.api.distributed.system.apisystem.dto.FastestLapExtendedDto;
import com.api.distributed.system.apisystem.entity.BasicEntity;
import com.api.distributed.system.apisystem.entity.FastestLapEntity;
import com.api.distributed.system.apisystem.entity.ParticipantEntity;
import com.api.distributed.system.apisystem.repository.FastestLapRepository;
import com.api.distributed.system.apisystem.repository.ParticipantRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static com.api.distributed.system.apisystem.utilities.Utils.replaceSecondsToMinutes;

@Service
@AllArgsConstructor
public class FastestLapService extends BasicService{
    @Autowired
    private FastestLapRepository fastestLapRepository;
    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private ParticipantService participantService;

    @Override
    public List<FastestLapEntity> getListByKey(String key){
        return fastestLapRepository.findAllByKey(key);
    }

    public ResponseEntity<String> postFastestLap(String key,
                                                 FastestLapDto fastestLapDto){
        fastestLapRepository.save(new FastestLapEntity(fastestLapDto.getSessionUid(),
                key, fastestLapDto, new Date()));
        if(participantRepository.existsBySessionUidAndKey(fastestLapDto.getSessionUid(), key)){
            List<ParticipantEntity> participantEntityList = participantRepository.findAllBySessionUidAndKey(fastestLapDto.getSessionUid(), key);
            ParticipantEntity participantEntity = compareTimestamps(participantEntityList);
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

    @Override
    public <T extends BasicEntity> void deleteEntity(T tClass) {
        fastestLapRepository.delete((FastestLapEntity) tClass);
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

    public ResponseEntity<FastestLapExtendedDto> getFastestLap(BigInteger sessionUid, String key) {
        FastestLapEntity fastestLapEntity = fastestLapRepository.findFirstBySessionUidAndKeyOrderByDateDesc(sessionUid, key);
        if(fastestLapEntity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            String fastestLapDriverName = participantService.getParticipantName(fastestLapEntity.getFastestLapDto().getCarId(),
                    sessionUid, key);
            FastestLapExtendedDto fastestLapExtendedDto = new FastestLapExtendedDto(
                    fastestLapDriverName.replace("_"," "),
                    fastestLapEntity.getFastestLapDto().getCarId(),
                    replaceSecondsToMinutes(fastestLapEntity.getFastestLapDto().getTime())
            );
            return ResponseEntity.ok(fastestLapExtendedDto);
        }
    }
}
