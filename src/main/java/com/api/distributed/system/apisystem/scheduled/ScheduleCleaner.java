package com.api.distributed.system.apisystem.scheduled;

import com.api.distributed.system.apisystem.entity.BasicEntity;
import com.api.distributed.system.apisystem.entity.KeyEntity;
import com.api.distributed.system.apisystem.repository.*;
import com.api.distributed.system.apisystem.service.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Slf4j
@EnableScheduling
@Component
public class ScheduleCleaner {
    private CarDamageService carDamageService;
    private CarFinalClassificationService carFinalClassificationService;
    private CarStatusService carStatusService;
    private CarTelemetryService carTelemetryService;
    private EventService eventService;
    private KeyService keyService;
    private LapDataService lapDataService;
    private ParticipantService participantService;
    private SessionService sessionService;

    @Autowired
    public ScheduleCleaner(CarDamageService carDamageService, CarFinalClassificationService carFinalClassificationService,
                           CarStatusService carStatusService, CarTelemetryService carTelemetryService,
                           EventService eventService, KeyService keyService, LapDataService lapDataService,
                           ParticipantService participantService, SessionService sessionService) {
        this.carDamageService = carDamageService;
        this.carFinalClassificationService = carFinalClassificationService;
        this.carStatusService = carStatusService;
        this.carTelemetryService = carTelemetryService;
        this.eventService = eventService;
        this.keyService = keyService;
        this.lapDataService = lapDataService;
        this.participantService = participantService;
        this.sessionService = sessionService;
    }

    @Scheduled(cron = "0 0 12 1/2 * ? *")
    private void deleteOldData(){
        List<KeyEntity> keyEntityList = keyService.getListWithAllKeysOlderThanTwoDays();
        log.info("Delete old data, find {} keys to delete", keyEntityList.size());
        for(KeyEntity keyEntity: keyEntityList){
            deleteAllData(carDamageService, keyEntity.getKey());
            deleteAllData(carFinalClassificationService, keyEntity.getKey());
            deleteAllData(carStatusService, keyEntity.getKey());
            deleteAllData(carTelemetryService, keyEntity.getKey());
            deleteAllData(eventService, keyEntity.getKey());
            deleteAllData(lapDataService, keyEntity.getKey());
            deleteAllData(participantService, keyEntity.getKey());
            deleteAllData(sessionService, keyEntity.getKey());
            deleteAllData(keyService, keyEntity.getKey());
        }
    }

    private void deleteAllData(BasicService basicService, String key){
        List<? extends BasicEntity> list = basicService.getListByKey(key);
        for (BasicEntity basic: list) {
            basicService.deleteEntity(basic);
        }
    }
}
