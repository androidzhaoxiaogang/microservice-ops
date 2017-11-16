package com.yonyou.cloud.ops.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring4all.swagger.EnableSwagger2Doc;

@SpringBootApplication
@EnableSwagger2Doc
public class OpsMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpsMqApplication.class, args);
	}
}
