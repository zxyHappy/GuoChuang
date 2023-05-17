package com.riskassess.mapper;

import com.riskassess.entity.Scene;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


public interface SceneMapper {


    int insert(@Param("scene") Scene scene);

    boolean delete(int id);


}
