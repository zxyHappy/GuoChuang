package com.riskassess.mapper;

import com.riskassess.entity.Scene;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


public interface SceneMapper {


    int insert(Scene scene);

    int delete(int id);

    int update(Scene scene);

    Scene select(int id);


}
