package com.api.distributed.system.apisystem.service;

import com.api.distributed.system.apisystem.dto.FastestLapDto;
import com.api.distributed.system.apisystem.entity.BasicEntity;
import com.api.distributed.system.apisystem.entity.FastestLapEntity;
import com.api.distributed.system.apisystem.entity.ParticipantEntity;
import com.api.distributed.system.apisystem.entity.RaceEventEntity;
import com.api.distributed.system.apisystem.repository.FastestLapRepository;
import com.api.distributed.system.apisystem.repository.ParticipantRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class FastestLapService extends BasicService{
    @Autowired
    private FastestLapRepository fastestLapRepository;
    @Autowired
    private ParticipantRepository participantRepository;

    @Override
    public List<FastestLapEntity> getListByKey(String key){
        return fastestLapRepository.findAllByKey(key);
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

    @Override
    public <T extends BasicEntity> void deleteEntity(T tClass) {
        fastestLapRepository.delete((FastestLapEntity) tClass);
    }
}
