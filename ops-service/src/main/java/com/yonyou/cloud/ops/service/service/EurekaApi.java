//package com.yonyou.cloud.ops.service.service;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@FeignClient(name="EUREKA-SERVICE")
//public interface EurekaApi {
//	
//	@RequestMapping(value = "/eureka/apps",method=RequestMethod.GET,headers="Accept=application/json")
//    public String getAll();
//	
//	@RequestMapping(value = "/eureka/apps",method=RequestMethod.GET,headers="Accept=application/json")
//	public String deleteOne();
//	
//	@RequestMapping(value = "/eureka/apps/{appID}/{instanceID}",method=RequestMethod.GET,headers="Accept=application/json")
//	public String deleteOne();
//}
