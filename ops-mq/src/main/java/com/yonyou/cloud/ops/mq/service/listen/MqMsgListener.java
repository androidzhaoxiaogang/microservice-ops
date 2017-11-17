package com.yonyou.cloud.ops.mq.service.listen;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Service;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;

import com.rabbitmq.client.Channel;
import com.xiaoleilu.hutool.json.JSONUtil;


@Service
public class MqMsgListener implements ChannelAwareMessageListener{

//	@Autowired
//	MessageConverter messageConverter;
	JsonMessageConverter jsonMessageConverter = new JsonMessageConverter();
	
	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		System.out.println(message.getMessageProperties().getHeaders().get("__TypeId__"));
		System.out.println(message.getMessageProperties().getHeaders().get("__ContentTypeId__"));
		message.getMessageProperties().getHeaders().remove("__TypeId__");
		message.getMessageProperties().getHeaders().remove("__ContentTypeId__");
		message.getMessageProperties().getHeaders().remove("__KeyTypeId__");
		
		System.out.println(message.getMessageProperties().getHeaders().get("__TypeId__"));
		System.out.println(message.getMessageProperties().getHeaders().get("__ContentTypeId__"));
		
		
		System.out.println(JSONUtil.parseObj(message));
		
		System.out.println(jsonMessageConverter.fromMessage(message));
	}

}
