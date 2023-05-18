package com.riskassess.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Scene {
    private int id;
    private String name;
    private int step;
    private double slope;
    private int light;
    private double slip;
    private int identifier;
    private double square;

}
