package com.riskassess.mapper;

import com.riskassess.entity.Scene;
import org.apache.ibatis.annotations.Mapper;


public interface SceneMapper {


    boolean insert(Scene scene);

    boolean delete(int id);


}
