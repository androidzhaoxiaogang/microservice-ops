package com.yonyou.microservice.gate.admin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yonyou.microservice.auth.client.EnableAceAuthClient;
import com.yonyou.microservice.auth.client.annotation.IgnoreClientToken;
import com.yonyou.microservice.auth.client.annotation.IgnoreUserToken;

/**
 * ${DESCRIPTION}
 *
 * @author joy
 * @create 2017-05-25 12:44
 */
@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
@EnableFeignClients({"com.yonyou.microservice.auth.client.feign"})
@EnableScheduling
@EnableAceAuthClient
@ServletComponentScan("com.yonyou.microservice.gate.admin.config.druid")
@RestController
@IgnoreUserToken
@IgnoreClientToken
@EnableDiscoveryClient
public class AdminBootstrap {
    public static void main(String[] args) {
//    	String password = new BCryptPasswordEncoder(UserConstant.PW_ENCORDER_SALT).encode("wys");
//    	System.out.println(password);
        new SpringApplicationBuilder(AdminBootstrap.class).web(true).run(args);    
    }
    
    @RequestMapping("/back/admin/test")
    public String test(){
    	System.out.println("--call test");
    	return "ok";
    }
}
