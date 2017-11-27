package com.yonyou.microservice.auth.client.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yonyou.microservice.auth.client.config.ServiceAuthConfig;
import com.yonyou.microservice.auth.client.config.UserAuthConfig;
import com.yonyou.microservice.auth.client.jwt.ServiceAuthUtil;
import com.yonyou.microservice.gate.common.context.BaseContextHandler;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * Created by ace on 2017/9/15.
 */
public class ServiceFeignInterceptor implements RequestInterceptor {
    private Logger logger = LoggerFactory.getLogger(ServiceFeignInterceptor.class);
    @Autowired
    private ServiceAuthConfig serviceAuthConfig;
    @Autowired
    private UserAuthConfig userAuthConfig;
    @Autowired
    private ServiceAuthUtil serviceAuthUtil;
    
    public ServiceFeignInterceptor(){
    	System.out.println("--ServiceFeignInterceptor,init,threadid:"+Thread.currentThread());
    }


    @Override
    public void apply(RequestTemplate requestTemplate) {
    	System.out.println("--ServiceFeignInterceptor,threadid:"+Thread.currentThread());
    	System.out.println("-------x1:"+serviceAuthConfig.getTokenHeader());
    	System.out.println("-------x2:"+serviceAuthUtil.getClientToken());
    	System.out.println("-------x3:"+userAuthConfig.getTokenHeader());
    	System.out.println("-------x4:"+BaseContextHandler.getToken());
    	System.out.println("-------url:"+requestTemplate.url());
    	
        requestTemplate.header(serviceAuthConfig.getTokenHeader(), serviceAuthUtil.getClientToken());
        requestTemplate.header(userAuthConfig.getTokenHeader(), BaseContextHandler.getToken());
    }
}