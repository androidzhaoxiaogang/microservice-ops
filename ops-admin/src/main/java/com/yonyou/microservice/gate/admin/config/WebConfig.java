package com.yonyou.microservice.gate.admin.config;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.yonyou.cloud.common.exception.GlobalExceptionHandler;
import com.yonyou.microservice.auth.client.interceptor.ServiceAuthRestInterceptor;
import com.yonyou.microservice.auth.client.interceptor.UserAuthRestInterceptor;

/**
 * Created by ace on 2017/9/8.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Bean
    GlobalExceptionHandler getGlobalExceptionHandler(){
        return new GlobalExceptionHandler();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ArrayList<String> commonPathPatterns = getExcludeCommonPathPatterns();
        registry.addInterceptor(getServiceAuthRestInterceptor()).addPathPatterns("/**").excludePathPatterns(commonPathPatterns.toArray(new String[]{}));
        commonPathPatterns .add("/api/user/username/**");
        commonPathPatterns .add("/api/user/phone/**");
        registry.addInterceptor(getUserAuthRestInterceptor()).addPathPatterns("/**").excludePathPatterns(commonPathPatterns.toArray(new String[]{}));
        super.addInterceptors(registry);
    }

    @Bean
    ServiceAuthRestInterceptor getServiceAuthRestInterceptor(){
        return new ServiceAuthRestInterceptor();
    }

    @Bean
    UserAuthRestInterceptor getUserAuthRestInterceptor(){
        return new UserAuthRestInterceptor();
    }

    private ArrayList<String> getExcludeCommonPathPatterns(){
        ArrayList<String> list = new ArrayList<>();
        String[] urls = {
        		"/api/**",
                "/v2/api-docs",
                "/swagger-resources/**"
        };
        Collections.addAll(list,urls);
        return list;

    }
}
