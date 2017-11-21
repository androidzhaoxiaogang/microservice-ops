package com.yonyou.microservice.gate.server.config;

import org.springframework.context.annotation.Bean;

import com.yonyou.microservice.auth.client.interceptor.ServiceFeignInterceptor;

/**
 * Created by ace on 2017/9/12.
 */
//@Configuration
public class ZuulConfig {
    @Bean
    ServiceFeignInterceptor getClientTokenInterceptor(){
        return new ServiceFeignInterceptor();
    }
}
