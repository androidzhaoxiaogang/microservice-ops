package com.yonyou.cloud.ops.mq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.yonyou.cloud.common.service.EsBaseService;
import com.yonyou.cloud.ops.mq.common.MqOpsConstant;
import com.yonyou.cloud.ops.mq.entity.MqConsumer;

@Service
public class MqConsumerService extends EsBaseService<MqConsumer>{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public void save(MqConsumer mqConsumer) throws Exception{
		
		if(Boolean.valueOf(mqConsumer.getSuccess())){
			mqConsumer.setSuccessTime(mqConsumer.getOccurTime());
		}else{
			mqConsumer.setFailTimes(mqConsumer.getFailTimes() + 1);
		}
		
		MqConsumer consumer = selectOne(MqOpsConstant.INDEX, "msgKey:" + mqConsumer.getMsgKey() + " AND " + "consumerId:" + mqConsumer.getConsumerId());
		if(consumer == null){
			insert(MqOpsConstant.INDEX, mqConsumer);
		} else if(Boolean.valueOf(consumer.getSuccess())){
			logger.error("this message has been consumed==========>>>>>>msgkey:{}  consmerId{}", consumer.getMsgKey(), consumer.getConsumerId());
		}  else {
			update(MqOpsConstant.INDEX, mqConsumer, mqConsumer.getMsgKey());
		}
	}
}
