package com.api.distributed.system.apisystem.service;

import com.api.distributed.system.apisystem.dto.*;
import com.api.distributed.system.apisystem.entity.*;
import com.api.distributed.system.apisystem.repository.LapDataRepository;
import com.api.distributed.system.apisystem.utilities.Utils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.*;

@Service
@AllArgsConstructor
public class LapDataService extends BasicService{

    @Autowired
    private LapDataRepository lapDataRepository;

    @Autowired
    private CarDamageService carDamageService;
    @Autowired
    private ParticipantService participantService;


    public ResponseEntity<String> postData(String key,
                                          LapDataList lapDataList){
        lapDataRepository.save(new LapDataEntity(lapDataList.getSessionUid(), key, lapDataList.getLapDataDtoList(),
                new Date()));
        return ResponseEntity.ok("Object saved");
    }

    @Override
    public List<LapDataEntity> getListByKey(String key){
        return lapDataRepository.findAllByKey(key);
    }

    @Override
    public <T extends BasicEntity> void deleteEntity(T tClass) {
        lapDataRepository.delete((LapDataEntity) tClass);
    }

    public ResponseEntity<List<LapDataWithOrderDto>> getAllData(BigInteger sessionUid, String key) {
        List<LapDataDto> lapDataDtoList = lapDataRepository.findFirstBySessionUidAndKeyOrderByDateDesc(sessionUid, key).getLapDataDtoList();
        List<ParticipantExtendDto> participantEntityList = participantService.getLastParticipant(sessionUid,key);
        List<CarDamageDataDto> carDamageDataDtoList = carDamageService.getListBySessionUidAndKey(sessionUid, key);
        List<LapDataWithOrderDto> lapDataWithOrderDtos = new ArrayList<>();
        for (LapDataDto lapDataDto: lapDataDtoList) {
            ParticipantExtendDto participantExtendDto = getAccurateParticiapantData(participantEntityList, lapDataDto.getCarIndex());
            CarDamageDataDto carDamageDataDto = getAccurateCarDamageData(carDamageDataDtoList, lapDataDto.getCarIndex());
            if(participantExtendDto!=null && carDamageDataDto!=null) {
                LapDataWithOrderDto lapDataWithOrderDto = new LapDataWithOrderDto(
                        lapDataDto.getCarPosition(),
                        participantExtendDto.getName(),
                        lapDataDto.getCarIndex(),
                        Utils.changeMilisecondsToMinutes(lapDataDto.getLastLapTime()),
                        Utils.changeMilisecondsToMinutes(lapDataDto.getCurrentLapTime()),
                        Utils.changeMilisecondsToSeconds(lapDataDto.getSector1TimeInMS()),
                        Utils.changeMilisecondsToSeconds(lapDataDto.getSector2TimeInMS()),
                        lapDataDto.getCurrentLapNum(),
                        lapDataDto.getPenalties(),
                        lapDataDto.getWarnings(),
                        lapDataDto.getNumUnservedDriveThroughPens(),
                        lapDataDto.getNumUnservedStopGoPens(),
                        lapDataDto.getDriverStatus().name(),
                        lapDataDto.getResultStatus().name(),
                        participantExtendDto.isFastestLap(),
                        carDamageDataDto.getTyresWear(),
                        carDamageDataDto.getTyresDamage(),
                        carDamageDataDto.getBrakesDamage(),
                        carDamageDataDto.getFrontLeftWingDamage(),
                        carDamageDataDto.getFrontRightWingDamage(),
                        carDamageDataDto.getRearWingDamage(),
                        carDamageDataDto.getFloorDamage(),
                        carDamageDataDto.getDiffuserDamage(),
                        carDamageDataDto.getSidepodDamage());
                lapDataWithOrderDtos.add(lapDataWithOrderDto);
            }

        }

        lapDataWithOrderDtos.sort((Comparator.comparingInt(LapDataWithOrderDto::getCarPosition)));
        return ResponseEntity.ok(lapDataWithOrderDtos);
    }

    private ParticipantExtendDto getAccurateParticiapantData(List<ParticipantExtendDto> participantEntityList, int carId){
        ParticipantExtendDto participantExtendDtoObject = null;
        for(ParticipantExtendDto participantExtendDto:participantEntityList){
            if(carId == participantExtendDto.getCarIndex()){
                participantExtendDtoObject =  participantExtendDto;
            }
        }
        return participantExtendDtoObject;
    }

    private CarDamageDataDto getAccurateCarDamageData(List<CarDamageDataDto> carDamageDataDtoList, int carId){
        CarDamageDataDto carDamageDataDtoObject = null;
        for(CarDamageDataDto carDamageDataDto: carDamageDataDtoList){
            if(carId == carDamageDataDto.getCarIndex()){
                carDamageDataDtoObject = carDamageDataDto;
            }
        }
        return carDamageDataDtoObject;
    }
}
