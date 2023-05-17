package com.riskassess;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.riskassess.*")
@MapperScan("com.riskassess.mapper")
public class RiskAssessApplication {

    public static void main(String[] args) {
        SpringApplication.run(RiskAssessApplication.class, args);
    }

}
