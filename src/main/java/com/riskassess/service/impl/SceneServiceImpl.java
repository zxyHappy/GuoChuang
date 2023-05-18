package com.riskassess.service.impl;

import com.riskassess.entity.Scene;
import com.riskassess.mapper.SceneMapper;
import com.riskassess.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class SceneServiceImpl implements SceneService {

    @Autowired
    private SceneMapper sceneMapper;

    @Override
    public int insertScene(Scene scene) {
        int i = sceneMapper.insert(scene);
        if(i == 1){
            return 0;
        }else {
            return 1;
        }
    }

    @Override
    public int deleteScene(int id) {
        int i = sceneMapper.delete(id);
        if(i == 1){
            return 0;
        }else {
            return 1;
        }
    }
}
