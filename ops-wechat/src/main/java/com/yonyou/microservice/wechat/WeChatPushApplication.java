package com.yonyou.microservice.wechat;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * 启动类
 */
@SpringBootApplication
//@EnableTransactionManagement
//@EnableFeignClients
//@EnableConfigurationProperties
//@EnableDiscoveryClient
public class WeChatPushApplication {

    /**
     * 启动main函数
     * @param args  启动桉树
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        SpringApplication.run(WeChatPushApplication.class, args);
    }

}
