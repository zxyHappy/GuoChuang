package com.riskassess.config;

import com.riskassess.service.SceneService;
import com.riskassess.service.impl.SceneServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SceneConfiguration {

    @Bean
    public SceneService getSceneService(){
        return new SceneServiceImpl();
    }
}
