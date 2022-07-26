package com.api.distributed.system.apisystem.service;

import com.api.distributed.system.apisystem.entity.BasicEntity;
import com.api.distributed.system.apisystem.entity.CarDamageEntity;

import java.util.List;

public abstract class BasicService {

    public List<? extends BasicEntity> getListByKey(String key){
        return null;
    }

    public <T extends BasicEntity> void deleteEntity(T tClass){

    }
}
