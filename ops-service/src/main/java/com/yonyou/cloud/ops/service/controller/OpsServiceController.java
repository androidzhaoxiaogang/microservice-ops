//package com.yonyou.cloud.ops.service.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.yonyou.cloud.common.annotation.YcApi;
//import com.yonyou.cloud.common.beans.RestResultResponse;
//import com.yonyou.cloud.common.controller.BaseController;
//import com.yonyou.cloud.ops.service.entity.EurekaApplications;
//import com.yonyou.cloud.ops.service.entity.InstanceInfo;
//import com.yonyou.cloud.ops.service.service.OpsServiceService;
//
//
//@RestController
//public class OpsServiceController {
//	
//	@Autowired
//	OpsServiceService opsServiceService;
//	
//	@RequestMapping(value="all",method=RequestMethod.GET)
//	@YcApi
//	public RestResultResponse<EurekaApplications> getAll(){
//		return  new RestResultResponse<EurekaApplications>().data(opsServiceService.getAll()).success(true);
//	}
//	
//	@RequestMapping(value="delete",method=RequestMethod.DELETE)
//	@YcApi
//	public RestResultResponse<EurekaApplications> deleteOne(){
//		return  new RestResultResponse<EurekaApplications>().data(opsServiceService.getAll()).success(true);
//	}
//	
//	
//	
//	
//}
