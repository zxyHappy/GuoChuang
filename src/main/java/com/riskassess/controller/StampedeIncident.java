package com.riskassess.controller;


import com.riskassess.entity.CrowdData;
import com.riskassess.entity.Scene;
import com.riskassess.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/scene")
@ResponseBody
public class StampedeIncident {

    @Autowired
    SceneService sceneService;

    @RequestMapping(value = "/add")
    public HashMap<String,Object> addScene(@RequestBody Scene scene){
        int i = sceneService.insertScene(scene);
        HashMap<String,Object> map = new HashMap<>();
        switch (i){
            case 0:
                map.put("msg","场景加入成功");
                map.put("status",0);
                break;
            case 1:
                map.put("msg","场景加入失败");
                map.put("status",1);
                break;
            default:
                return null;
        }
        return map;
    }

    @GetMapping(value = "/delete/{id}")
    public HashMap<String,Object> delete(@PathVariable int id){
        int i = sceneService.deleteScene(id);
        HashMap<String,Object> map = new HashMap<>();
        switch (i){
            case 0:
                map.put("msg","场景删除成功");
                map.put("status",0);
                break;
            case 1:
                map.put("msg","场景删除失败");
                map.put("status",1);
                break;
            default:
                return null;
        }
        return map;
    }

    @RequestMapping(value = "/update")
    public HashMap<String,Object> updateScene(@RequestBody Scene scene){
        int i = sceneService.updateScene(scene);
        HashMap<String,Object> map = new HashMap<>();
        switch (i){
            case 0:
                map.put("msg","场景更新成功");
                map.put("status",0);
                break;
            case 1:
                map.put("msg","场景更新失败");
                map.put("status",1);
                break;
            default:
                return null;
        }
        return map;
    }

    @RequestMapping(value = "/getValue")
    public HashMap<String,Object> getValue(@RequestBody CrowdData crowdData){
        int i = sceneService.selectScene(crowdData);
        HashMap<String,Object> map = new HashMap<>();
        map.put("危险性级别", i);
        switch (i){
            case 1:
                map.put("msg","异常严重，须立即疏散人群");
                break;
            case 2:
                map.put("msg","非常严重，需加强警戒，严格控制");
                break;
            case 3:
                map.put("msg","比较严重，需严密监控");
                break;
            case 4:
                map.put("msg","不太严重，正常预防");
                break;
            default:break;
        }
        map.put("status",0);
        return map;
    }


}
