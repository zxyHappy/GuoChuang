package com.riskassess.service.impl;

import com.riskassess.entity.CrowdData;
import com.riskassess.entity.Scene;
import com.riskassess.mapper.SceneMapper;
import com.riskassess.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;


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

    @Override
    public int updateScene(Scene scene) {
        int i = sceneMapper.update(scene);
        if(i == 1){
            return 0;
        }else {
            return 1;
        }
    }

    @Override
    public int selectScene(CrowdData data) {
        Scene scene = sceneMapper.select(data.getId());
        return riskAccumulation(data,scene);
    }

    public int riskAccumulation(CrowdData data,Scene scene){
        int num = data.getNum();
        double a1,a2=data.getA2(),a3=data.getA3();
        double b1,b2;
        double c1,c2,c3;
        double a,b,c,d=0;

        if(num>=2.13){
            a1=1;
        }else if(num<0.71){
            a1=0;
        }else {
            a1=(num-0.71)/1.42;
        }
        a = 0.2627*a1+0.2377*a2+0.1476*a3;

        b1=scene.getStep();
        b2=scene.getSlope();
        if(b2>15){
            b2=1;
        }else if(b2<10){
            b2=0;
        }else{
            b2=0.2*(b2-10);
        }
        b=0.0729*b1+0.0533*b2;

        c1=scene.getLight();
        c2=scene.getSlip();
        c3= scene.getIdentifier();
        c=0.1070*c1+0.1012*c2+0.0178*c3;

        double res=a+b+c+10*d;
//    分级
        if(res>=75){
            res=1;
        }else if(res>=50&&res<75){
            res=2;
        }else if(res>=25&&res<50){
            res=3;
        }else if(res>=15&&res<25){
            res=4;
        }else{
            res=0;
        }
        return (int)res;
    }
}
