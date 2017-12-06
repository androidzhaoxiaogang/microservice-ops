package com.yonyou.cloud.ops.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.spring4all.swagger.EnableSwagger2Doc;

@SpringBootApplication
@EnableSwagger2Doc
@EnableDiscoveryClient
public class OpsMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpsMqApplication.class, args);
	}
}
