package com.youyou.microservice.auth.server;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by Ace on 2017/6/2.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan("com.youyou.microservice.auth.server.mapper")
public class AuthBootstrap {
    public static void main(String[] args) {

//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
//
//    	String password = "wys";
//    	String password1 = new BCryptPasswordEncoder(UserConstant.PW_ENCORDER_SALT).encode("wys");
//    	System.out.println("-------------p"+password1);
//        if (encoder.matches(password, password1)) {
//        	System.out.println("-------------x");
//        }
        SpringApplication.run(AuthBootstrap.class, args);
    }
}
