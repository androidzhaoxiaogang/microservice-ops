package com.yonyou.microservice.wechat.config;

import java.util.Properties;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

@Configuration
//注意，由于MapperScannerConfigurer执行的比较早，所以必须有下面的注解
@AutoConfigureAfter(DatasourceConfig.class)
public class MyBatisMapperScannerConfig {
	 	@Bean
//	 	@Primary
	    public MapperScannerConfigurer mapperScannerConfigurer() {
	 		 MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		        mapperScannerConfigurer.setBasePackage("com.yonyou.microservice.wechat.dao");
//		        mapperScannerConfigurer.setAnnotationClass(MySQLDb.class);
		        Properties properties = new Properties();
		        properties.setProperty("mappers", "com.yonyou.microservice.wechat.util.MyMapper");
		        properties.setProperty("notEmpty", "false");
		        properties.setProperty("IDENTITY", "MYSQL");
		        mapperScannerConfigurer.setProperties(properties);
		        return mapperScannerConfigurer;
	    }
	 	
//	 	@Bean
//	    public MapperScannerConfigurer mapperScannerConfigurerOracle() {
//	 		 MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//		        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryOracle");
//		        mapperScannerConfigurer.setBasePackage("com.yonyou.microservice.wechat.dao");
////		        mapperScannerConfigurer.setAnnotationClass(OracleDb.class);
//		        Properties properties = new Properties();
//		        properties.setProperty("mappers", "com.yonyou.microservice.wechat.util.MyMapper");
//		        properties.setProperty("notEmpty", "false");
//		        properties.setProperty("IDENTITY", "ORACLE");
//		        mapperScannerConfigurer.setProperties(properties);
//		        return mapperScannerConfigurer;
//	    }
}