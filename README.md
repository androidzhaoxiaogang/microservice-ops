# microservice-ops
# 使用方法

---
- pom.xml引用
```

   		<dependency>  
  		  <groupId>com.yonyou.cloud</groupId>
  		  <artifactId>microservice-zuul-db-starter</artifactId>
  		  <version>0.0.1</version>
		</dependency>
```
- 启动类注解

```

@EnableZuulProxyStore
@ComponentScan(basePackages = {"com.yonyou.cloud"})
```
- application.properties

```
zuul.store.mysql.enabled=true

spring.datasource.driverClassName=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://10.180.8.205:3306/ag_gate?useUnicode=true&amp;characterEncoding=utf8mb4
spring.datasource.username=root
spring.datasource.password=rcs
```
