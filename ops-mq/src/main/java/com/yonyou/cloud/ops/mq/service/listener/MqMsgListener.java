package com.yonyou.cloud.ops.mq.service.listener;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;
import com.xiaoleilu.hutool.json.JSONObject;
import com.xiaoleilu.hutool.json.JSONUtil;
import com.yonyou.cloud.ops.mq.common.MqMessageType;
import com.yonyou.cloud.ops.mq.entity.MqConsumer;
import com.yonyou.cloud.ops.mq.entity.MqMessage;
import com.yonyou.cloud.ops.mq.entity.MqProducer;
import com.yonyou.cloud.ops.mq.service.MqConsumeDetailInfoService;
import com.yonyou.cloud.ops.mq.service.MqConsumerService;
import com.yonyou.cloud.ops.mq.service.MqMessageService;
import com.yonyou.cloud.ops.mq.service.MqProducerService;


@Service
public class MqMsgListener implements ChannelAwareMessageListener{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private Jackson2JsonMessageConverter convert =  new Jackson2JsonMessageConverter();
	
//	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

	@Autowired
	MqProducerService  mqProducerService;
	
	@Autowired
	MqMessageService  mqMessageService;
	
	@Autowired
	MqConsumerService mqConsumerService;
	
	@Autowired
	MqConsumeDetailInfoService mqConsumeDetailInfoService;
	
	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		
		JSONObject j = JSONUtil.parseObj(convert.fromMessage(message));
		
		String type = j.get("type").toString().toUpperCase();
		String host = j.get("host").toString();
		String time = j.get("time").toString();
		JSONObject properties =j.getJSONObject("properties");
		
		MqMessageType mqMessageType = MqMessageType.of(type);
		if(mqMessageType == null){
			logger.error("Illegal message type.message:{}",j.toStringPretty());
			return;
		}
		
		MqMessage mqMessage = new MqMessage();
		properties.toBean(mqMessage);
		mqMessage.setHost(host);
		mqMessage.setOccurTime(Long.parseLong(time));
		
		mqMessageService.save(mqMessage, mqMessageType);
		
		switch (mqMessageType) {
		case SEND:
			MqProducer producer = new MqProducer();
			BeanUtils.copyProperties(mqMessage, producer);
			mqProducerService.save(producer);
			break;
		case CONSUMER:
			MqConsumer consumer = new MqConsumer();
			BeanUtils.copyProperties(mqMessage, consumer);
			consumer.setConsumerId(String.valueOf(new Random().nextInt(10)));
			consumer.setMsgKey("TEST");
			mqConsumerService.save(consumer);
			mqConsumeDetailInfoService.save(consumer);
			break;
		default:
			break;
		}
		
	}
	
}
