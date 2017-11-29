package com.yonyou.microservice.wechat.mq;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitOperations;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.yonyou.cloud.mom.client.impl.MqSenderDefaultImpl;
import com.yonyou.cloud.mom.core.store.ProducerMsgStore;
import com.yonyou.cloud.mom.core.store.impl.DbStoreProducerMsg;
import com.yonyou.cloud.mom.core.util.SpringUtil;

@Configuration
@ComponentScan(basePackages = "com.yonyou.cloud.mom")
public class MqConfig {
	
	
	//初始化生产者相关实现类
	@Bean
	public MqSenderDefaultImpl mqSenderDefaultImpl(RabbitOperations rabbitOperations) {
		MqSenderDefaultImpl mqSenderDefaultImpl = new MqSenderDefaultImpl();
		mqSenderDefaultImpl.setRabbitOperations(rabbitOperations);
		return mqSenderDefaultImpl;
	}

	@Bean
	public SpringUtil springUtil() {
		return new SpringUtil();
	}
 
	@Bean
	public Queue attentionQueue() {
		return new Queue("attention", true); // 队列持久
	}

	//设定交换机类型
	@Bean
	public DirectExchange eventExchange() {
		return new DirectExchange("event-wechat");
	}

	//交换机和队列绑定
	@Bean
	public Binding wechatBindingAttention() {
		return BindingBuilder.bind(attentionQueue()).to(eventExchange()).with("attention");
	}
	

	 
	@Bean
	public Queue unAttentionQueue() {
		return new Queue("unAttention", true); // 队列持久
	}


	//交换机和队列绑定
	@Bean
	public Binding wechatBindingUnAttention() {
		return BindingBuilder.bind(unAttentionQueue()).to(eventExchange()).with("unAttention");
	}


	@Bean
	public MessageConverter messageConverter() {
		JsonMessageConverter jsonMessageConverter = new JsonMessageConverter();
		return jsonMessageConverter;
	}
 
}