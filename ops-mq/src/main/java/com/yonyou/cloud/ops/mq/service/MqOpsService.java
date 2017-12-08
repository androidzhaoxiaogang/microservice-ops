package com.yonyou.cloud.ops.mq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MqOpsService {
	
	@Autowired
	MqProducerService mqProducerService;
	
	@Autowired
	MqMessageService mqMessageService;
	
	@Autowired
	MqConsumerService mqConsumerService;
	
	@Autowired
	MqConsumeDetailInfoService mqConsumeDetailInfoService;
	
	
}

