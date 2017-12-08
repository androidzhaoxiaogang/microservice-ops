# microservice-ops
微服务运维平台，基于Spring Cloud实现

## 包含功能
主要用于代理微服务项目与业务无关的部分包括  
1.认证  
2.权鉴  
3.限流  
4.动态路由  
5.动态filter  
6.服务监控（基于springbootAdmin，eureka，pinpoint）  
7.消息监控（与[消息中间件](https://github.com/yonyou-auto-dev/microservice-mom)项目配合使用）  
8.任务中心

## 整体架构
![](https://github.com/yonyou-auto-dev/microservice-ops/blob/master/model.jpg)

绿色部分为运维平台会代理的部分
从左向右，所有请求会经过网关统一认证，鉴权，限流后再转发到相应的业务模块