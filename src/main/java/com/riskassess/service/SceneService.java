package com.riskassess.service;

import com.riskassess.entity.Scene;
import org.springframework.stereotype.Service;


public interface SceneService {

    /**
     *
     * @param scene 新建的场景
     * @return 0代表成功，1代表失败
     */
    int insertScene(Scene scene);

    /**
     *
     * @param id
     * @return
     */
    int deleteScene(int id);

}
