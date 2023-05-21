package com.riskassess.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CrowdData {

    // 场景id
    private int id;
    // 人群数量
    private int num;
    // 是否有对冲人流
    private int a2;
    //人员流速差异
    private int a3;

}
