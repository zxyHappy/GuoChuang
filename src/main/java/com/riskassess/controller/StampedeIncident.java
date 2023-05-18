package com.riskassess.controller;


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


}
