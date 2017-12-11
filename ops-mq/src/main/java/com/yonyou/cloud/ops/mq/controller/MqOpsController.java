package com.yonyou.cloud.ops.mq.controller;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.util.StringUtil;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.yonyou.cloud.common.annotation.YcApi;
import com.yonyou.cloud.common.beans.PageResultResponse;
import com.yonyou.cloud.common.beans.RestResultResponse;
import com.yonyou.cloud.common.service.utils.ESPageQuery;
import com.yonyou.cloud.ops.mq.common.MqMessageStatus;
import com.yonyou.cloud.ops.mq.common.MqOpsConstant;
import com.yonyou.cloud.ops.mq.dto.MqConsumerDto;
import com.yonyou.cloud.ops.mq.dto.MqMessageResponseDto;
import com.yonyou.cloud.ops.mq.dto.MqQueryRequestDto;
import com.yonyou.cloud.ops.mq.entity.MqConsumeDetailInfo;
import com.yonyou.cloud.ops.mq.entity.MqConsumer;
import com.yonyou.cloud.ops.mq.entity.MqData;
import com.yonyou.cloud.ops.mq.entity.MqMessage;
import com.yonyou.cloud.ops.mq.entity.MqProducer;
import com.yonyou.cloud.ops.mq.service.MqConsumeDetailInfoService;
import com.yonyou.cloud.ops.mq.service.MqConsumerService;
import com.yonyou.cloud.ops.mq.service.MqMessageService;
import com.yonyou.cloud.ops.mq.service.MqOpsService;
import com.yonyou.cloud.ops.mq.service.MqProducerService;

@RestController
@RequestMapping("/mq")
public class MqOpsController {
	
	@Autowired
	MqProducerService mqProducerService;
	
	@Autowired
	MqMessageService mqMessageService;
	
	@Autowired
	MqConsumerService mqConsumerService;
	
	@Autowired
	MqConsumeDetailInfoService mqConsumeDetailInfoService;
	
	@Autowired
	MqOpsService mqOpsService;
	
	Function<MqConsumer, MqConsumerDto> mqConsumer2Dto = new Function<MqConsumer, MqConsumerDto>(){
		@Override
		public MqConsumerDto apply(MqConsumer consumer) {
			MqConsumerDto mqConsumerDto = new MqConsumerDto();
			BeanUtils.copyProperties(consumer, mqConsumerDto);
			return mqConsumerDto;
		}
	};
	
	Function<MqMessage, MqMessageResponseDto> mqMessage2Dto = new Function<MqMessage, MqMessageResponseDto>(){
		@Override
		public MqMessageResponseDto apply(MqMessage message) {
			MqMessageResponseDto response = new MqMessageResponseDto();
			BeanUtils.copyProperties(message, response);
			if(StringUtil.isNotEmpty(response.getSuccess()))
				response.setSuccess(Boolean.valueOf(response.getSuccess())?"是":"否");
			if(StringUtil.isNotEmpty(response.getStatus()))
				response.setStatus(MqMessageStatus.valueOf(response.getStatus()).getName());
			return response;
		}
	};
//	@RequestMapping(value="/page",method=RequestMethod.POST)
//	@YcApi
//	public PageResultResponse<MqProducer> queryByPage(@RequestBody ESPageQuery query){
//		return mqProducerService.pageQuery(query,query.getIndex());
//	}
	
	@RequestMapping(value="/page",method=RequestMethod.POST)
	@YcApi
	public PageResultResponse<MqMessageResponseDto> queryByPage(@RequestBody MqQueryRequestDto request){
		PageResultResponse<MqMessageResponseDto> pageResultResponse = new PageResultResponse<MqMessageResponseDto>();
		ESPageQuery query = new ESPageQuery();
		BeanUtils.copyProperties(request, query);
		String[] fieldNames = Arrays.asList(MqQueryRequestDto.class.getDeclaredFields()).stream().map(field -> field.getName()).collect(Collectors.toList()).toArray(new String[0]);
		query.setQueryString(toQueryString(request, fieldNames));
		PageResultResponse<MqMessage> pageResult = mqMessageService.pageQuery(query, MqOpsConstant.INDEX);
		BeanUtils.copyProperties(pageResult, pageResultResponse);
		List<MqMessageResponseDto> dto = Lists.transform(pageResult.getData().getRows(), mqMessage2Dto);
		pageResultResponse.getData().setRows(dto);
		return pageResultResponse;
	}
	
	@RequestMapping(value="/consumedInfo/list/{msgKey}",method=RequestMethod.GET)
	@YcApi
	public RestResultResponse<List<MqConsumeDetailInfo>> queryConsumedInfos(@PathVariable("msgKey") String msgKey){
		RestResultResponse<List<MqConsumeDetailInfo>> response = new RestResultResponse<List<MqConsumeDetailInfo>>();
		List<MqConsumeDetailInfo> details = mqConsumeDetailInfoService.selectList(MqOpsConstant.INDEX, "msgKey:"+msgKey);
		response.setData(details);
		response.setSuccess(true);
		return response;
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@YcApi
	public RestResultResponse<MqProducer> getByList(String queryString,String index){
		return new RestResultResponse<MqData>().success(true).data(mqProducerService.selectList(index, queryString));
	}
	
	@RequestMapping(value="/mqMessage/{msgKey}",method=RequestMethod.GET)
	public RestResultResponse<MqMessageResponseDto> queryByPage(@PathVariable("msgKey") String msgKey){
		MqMessageResponseDto mqMessageResponseDto = new MqMessageResponseDto();
		
		MqMessage message = mqMessageService.selectOne(MqOpsConstant.INDEX, "msgKey:"+msgKey);
		BeanUtils.copyProperties(message, mqMessageResponseDto);
		List<MqProducer> producers = mqProducerService.selectList(MqOpsConstant.INDEX, "msgKey:"+msgKey);
		List<MqConsumer> consumers = mqConsumerService.selectList(MqOpsConstant.INDEX, "msgKey:"+msgKey);

		List<MqConsumerDto> consumersDto = Lists.transform(consumers, mqConsumer2Dto);
		for(MqConsumerDto c: consumersDto){
			List<MqConsumeDetailInfo> details = mqConsumeDetailInfoService.selectList(MqOpsConstant.INDEX, "msgKey:"+msgKey + " AND " + "consumerId:" + c.getConsumerId());
			c.setConsumeDetailInfos(details);
		}
		mqMessageResponseDto.setProducers(producers);
		mqMessageResponseDto.setConsumers(consumersDto);
		
		RestResultResponse<MqMessageResponseDto> response = new RestResultResponse<MqMessageResponseDto>();
		response.setData(mqMessageResponseDto);
		response.setSuccess(true);
		
		return response;
	}

	@RequestMapping(value="/messages",method=RequestMethod.POST)
	public RestResultResponse<List<MqMessageResponseDto>> queryByCondition(@RequestBody MqQueryRequestDto request){
		RestResultResponse<List<MqMessageResponseDto>> response = new RestResultResponse<List<MqMessageResponseDto>>();
		String[] fieldNames = Arrays.asList(MqQueryRequestDto.class.getDeclaredFields()).stream().map(field -> field.getName()).collect(Collectors.toList()).toArray(new String[0]);
		List<MqMessage> messages = mqMessageService.selectList(MqOpsConstant.INDEX, toQueryString(request, fieldNames));
		List<MqMessageResponseDto> messagesDto = Lists.transform(messages, mqMessage2Dto);
		response.setData(messagesDto);
		response.setSuccess(true);
		return response;
	}
	
	private String toQueryString(Object o, String...fuzzyFileds) {
		String queryString = "";
		List<String> fuzzyFiledlist = Arrays.asList(fuzzyFileds);
		Field[] fields=o.getClass().getDeclaredFields();  
	    for(int i=0;i<fields.length;i++){  
	        String name = fields[i].getName();  
	        String value = getFieldValueByName(fields[i].getName(), o);  
	        if(!StringUtils.isEmpty(value)){
	        	queryString += "AND " + name + ":" + (fuzzyFiledlist.contains(name)?value+"*":value) + " ";
	        }
	    }
	    return queryString.replaceFirst("AND", "");  
	} 

   private String getFieldValueByName(String fieldName, Object o) {  
       try {    
           String firstLetter = fieldName.substring(0, 1).toUpperCase();    
           String getter = "get" + firstLetter + fieldName.substring(1);    
           Method method = o.getClass().getMethod(getter, new Class[] {});    
           Object value = method.invoke(o, new Object[] {});    
           return value.toString();    
       } catch (Exception e) {    
           return null;    
       }    
   }  
}
