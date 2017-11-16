package com.yonyou.cloud.ops.mq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yonyou.cloud.common.annotation.YcApi;
import com.yonyou.cloud.common.beans.PageResultResponse;
import com.yonyou.cloud.common.beans.RestResultResponse;
import com.yonyou.cloud.ops.mq.entity.MqData;
import com.yonyou.cloud.ops.mq.service.MqDataService;

@RestController
@RequestMapping("/mq")
public class MqOpsController {
	
	@Autowired
	MqDataService mqDataService;
	
	
	@RequestMapping(value="/page",method=RequestMethod.GET)
	@YcApi
	public PageResultResponse<MqData> queryByPage(Integer pageNum,Integer pageSize,String tableName,String queryStr,String orderBy,String orderType){
		return mqDataService.pageQuery(queryStr, tableName, pageNum, pageSize, orderBy, orderType);
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@YcApi
	public RestResultResponse<MqData> getByList(String queryString,String tableName){
		return new RestResultResponse<MqData>().success(true).data(mqDataService.queryList(queryString, tableName));
		
	}
}
