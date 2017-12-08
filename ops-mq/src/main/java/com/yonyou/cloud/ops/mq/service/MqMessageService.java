package com.yonyou.cloud.ops.mq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.yonyou.cloud.common.service.EsBaseService;
import com.yonyou.cloud.ops.mq.common.MqMessageStatus;
import com.yonyou.cloud.ops.mq.common.MqMessageType;
import com.yonyou.cloud.ops.mq.common.MqOpsConstant;
import com.yonyou.cloud.ops.mq.entity.MqMessage;

@Service
public class MqMessageService extends EsBaseService<MqMessage>{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public void save (MqMessage mqMessage, MqMessageType mqMessageType) throws Exception{
		switch (mqMessageType) {
		case SEND:
			if(Boolean.valueOf(mqMessage.getSuccess())){
				mqMessage.setProduceSuccessTime(mqMessage.getOccurTime());
				mqMessage.setStatus(MqMessageStatus.PRODUCED.name());
			}else{
				mqMessage.setProduceFailTimes(mqMessage.getConsumeFailTimes() + 1);
				mqMessage.setStatus(MqMessageStatus.PRODUCE_FAIL.name());
			}
			break;
			
		case CONSUMER:
			if(Boolean.valueOf(mqMessage.getSuccess())){
				mqMessage.setConsumeSuccessTime(mqMessage.getOccurTime());
				mqMessage.setStatus(MqMessageStatus.CONSUMED.name());
			}else{
				mqMessage.setConsumeFailTimes(mqMessage.getConsumeFailTimes() + 1);
				mqMessage.setStatus(MqMessageStatus.CONSUME_FAIL.name());
			}
			break;

		default:
			break;
		}
		
		MqMessage oldMessage = selectOne(MqOpsConstant.INDEX, "msgKey:" + mqMessage.getMsgKey());
		
		if(oldMessage == null){
			insert(MqOpsConstant.INDEX, mqMessage);
		} else if((MqMessageStatus.CONSUMED.name().equals(oldMessage.getStatus()) && MqMessageType.SEND == mqMessageType)
				||(MqMessageStatus.PRODUCED.name().equals(oldMessage.getStatus()) && MqMessageType.CONSUMER == mqMessageType)){
			logger.error("this message status is success,msgkey:{}", mqMessage.getMsgKey());
		} else {
			update(MqOpsConstant.INDEX, mqMessage, oldMessage.getEsId());
		}
	}
} 
