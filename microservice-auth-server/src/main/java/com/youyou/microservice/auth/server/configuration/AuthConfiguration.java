package com.youyou.microservice.auth.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yonyou.microservice.gate.common.handler.GlobalExceptionHandler;

/**
 * Created by ace on 2017/9/10.
 */
@Configuration
public class AuthConfiguration {
    @Bean
    public GlobalExceptionHandler getGlobalExceptionHandler(){
        return new GlobalExceptionHandler();
    }

}
