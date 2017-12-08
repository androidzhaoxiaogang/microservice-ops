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

**绿色部分为运维平台会代理的部分从左向右，所有请求会经过网关统一认证，鉴权，限流后再转发到相应的业务模块。**

**蓝色部分是微服务的基础server层，参考这个[server项目](https://github.com/yonyou-auto-dev/microservice-server)**

## 模块大致说明（从左向右）

* **平台业务部分**，参考 [这个项目](https://github.com/yonyou-auto-dev/microservice-ops-ui)，使用VUE+ELementUI实现运维的界面，前后端分离。

* **网关服务 ops-gate：**  
	基于SpringCloud Netflix Zuul开发，实现了基于JWT的权限认证(也支持业务自行认证，只由网关代理JWT)、URL鉴权、动态路由、动态filter。
	
* **权限服务 ops-auth：**  
	具体权限认证判断的逻辑在该服务中实现，网关通过调用它来实现对应的认证功能，同时支持服务之间的调用时的鉴权（暂未release）。
	
* **消息监控 ops-mq：**  
	与[消息中间件](https://github.com/yonyou-auto-dev/microservice-mom)项目配合使用，该项目的中间件client已经默认加入了[埋点](https://github.com/yonyou-auto-dev/track-sdk)功能，该埋点的数据会反应消息发送以及接受的具体情况，后续通过logstash输出到mq中，ops-mq订阅对应的事件来收集消息发送以及接受的情况，并且提供页面来监控每一个消息的生命周期。
	
* **任务中心 ops-task：**  
	将定时任务的调用和业务执行剥离出来，该项目服务调度部分，通过简单的配置可以发布任务给业务服务，支持http方式或者mq发布方式，业务服务只需要提供对应的接口或者订阅相关事件即可。
	
* **服务监控 ops-service：**  
	通过调用eureka的接口来查看所有已注册服务的信息，查看服务提供的api清单(基于swagger)，查看SQL执行效率（基于durid）。
	
* **运维后台逻辑 ops-admin**  
	运维后台自身的一些逻辑，对表的增删改查等。
	
## 一些详细说明

### 关于网关的动态路由

已经实现在后台通过配置设定某些URL路由到哪些服务，也可以路由到异构系统中去，动态修改无需重启服务

### 关于动态Filter
基于groovy实现，直接在页面动态添加自己Filter的逻辑,动态修改网关filter无需重启服务
