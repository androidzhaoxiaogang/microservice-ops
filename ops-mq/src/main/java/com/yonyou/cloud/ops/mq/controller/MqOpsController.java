package com.yonyou.cloud.ops.mq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yonyou.cloud.common.annotation.YcApi;
import com.yonyou.cloud.common.beans.PageResultResponse;
import com.yonyou.cloud.common.beans.RestResultResponse;
import com.yonyou.cloud.common.service.utils.ESPageQuery;
import com.yonyou.cloud.ops.mq.entity.MqData;
import com.yonyou.cloud.ops.mq.entity.MqProducer;
import com.yonyou.cloud.ops.mq.service.MqProducerService;

@RestController
@RequestMapping("/mq")
public class MqOpsController {
	
	@Autowired
	MqProducerService mqProducerService;
	
	
	@RequestMapping(value="/page",method=RequestMethod.POST)
	@YcApi
	public PageResultResponse<MqProducer> queryByPage(@RequestBody ESPageQuery query){
		return mqProducerService.pageQuery(query,query.getIndex());
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@YcApi
	public RestResultResponse<MqProducer> getByList(String queryString,String index){
		return new RestResultResponse<MqData>().success(true).data(mqProducerService.selectList(index, queryString));
	}
}
