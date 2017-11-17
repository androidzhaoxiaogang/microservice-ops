package com.youyou.microservice.auth.server.configuration;

import com.youyou.microservice.auth.server.interceptor.ClientTokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ace on 2017/9/12.
 */
@Configuration
public class FeignConfiguration {
    @Bean
    ClientTokenInterceptor getClientTokenInterceptor(){
        return new ClientTokenInterceptor();
    }
}
