package com.yonyou.microservice.gate.server;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yonyou.microservice.auth.client.EnableAceAuthClient;
import com.yonyou.microservice.gate.ratelimit.EnableAceGateRateLimit;
import com.yonyou.microservice.gate.ratelimit.config.IUserPrincipal;
import com.yonyou.microservice.gate.ratelimit.config.properties.RateLimitProperties;
import com.yonyou.microservice.gate.server.config.UserPrincipal;
import com.yonyou.microservice.gate.server.utils.DBLog;

/**
 * Created by Ace on 2017/6/2.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients({"com.yonyou.microservice.auth.client.feign","com.yonyou.microservice.gate.server.feign"})
@EnableZuulProxy
@EnableScheduling
@EnableAceAuthClient
@EnableAceGateRateLimit
@RestController
public class GateBootstrap {
	@Autowired
	private RateLimitProperties p;
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
    	return "ok";
    }
    public static void main(String[] args) {
        DBLog.getInstance().start();
        SpringApplication.run(GateBootstrap.class, args);
    }

    @Bean
    @Primary
    IUserPrincipal userPrincipal(){
        return new UserPrincipal();
    }
}
