package com.api.distributed.system.apisystem.service;

import com.api.distributed.system.apisystem.dto.PacketSessionDto;
import com.api.distributed.system.apisystem.dto.SessionInfoDto;
import com.api.distributed.system.apisystem.entity.BasicEntity;
import com.api.distributed.system.apisystem.entity.SessionEntity;
import com.api.distributed.system.apisystem.repository.PacketSessionRepository;
import com.api.distributed.system.apisystem.utilities.Utils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public ResponseEntity<SessionInfoDto> getSessionInformation(BigInteger sessionUid, String key) {
        SessionEntity sessionEntity = packetSessionRepository.findFirstBySessionUidAndKeyOrderByDateDesc(sessionUid, key);
        if(sessionEntity!=null && sessionEntity.getPacketSessionDto()!= null){
            return ResponseEntity.ok(createSessionInfoDto(sessionEntity));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    private SessionInfoDto createSessionInfoDto(SessionEntity sessionEntity){
        PacketSessionDto packetSessionDto = sessionEntity.getPacketSessionDto();
        String trackName = Utils.replaceChars(packetSessionDto.getTrackId().name(), "_",'_', ' ');
        String weatherName = Utils.replaceChars(packetSessionDto.getWeather().name(), "_",'_', ' ');
        SessionInfoDto sessionInfoDto = SessionInfoDto.builder()
                .airTemperature(packetSessionDto.getAirTemperature())
                .pitSpeedLimit(packetSessionDto.getPitSpeedLimit())
                .safetyCarStatus(packetSessionDto.getSafetyCarStatus())
                .trackName(trackName)
                .trackTemperature(packetSessionDto.getTrackTemperature())
                .weather(weatherName)
                .marshalZones(packetSessionDto.getMarshalZones().subList(0, packetSessionDto.getNumMarshalZones()))
                .weatherForecastSamples(packetSessionDto.getWeatherForecastSamples().subList(0,packetSessionDto.getNumWeatherForecastSamples()))
                .build();
        return sessionInfoDto;
    }


}
