package com.tenthpower.config;

import com.tenthpower.util.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IdWorkerConfig {

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
