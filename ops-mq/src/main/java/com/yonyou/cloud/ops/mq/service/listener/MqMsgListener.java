package com.yonyou.cloud.ops.mq.service.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;
import com.xiaoleilu.hutool.json.JSONObject;
import com.xiaoleilu.hutool.json.JSONUtil;
import com.yonyou.cloud.ops.mq.service.MqProducerService;


@Service
public class MqMsgListener implements ChannelAwareMessageListener{
	
	Jackson2JsonMessageConverter convert =  new Jackson2JsonMessageConverter();
	
	@Autowired
	MqProducerService  mqProducerService;
	
	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		
		System.out.println(convert.fromMessage(message));
		
		JSONObject j = JSONUtil.parseObj(convert.fromMessage(message));
		
		JSONObject p =j.getJSONObject("properties");
		
		
		System.out.println("j===="+j);
		System.out.println("p===="+p);
		
	}

}
