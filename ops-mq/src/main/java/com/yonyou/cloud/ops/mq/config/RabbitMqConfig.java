package com.yonyou.cloud.ops.mq.config;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yonyou.cloud.ops.mq.service.listener.MqMsgListener;

@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue mqOps() {
        return new Queue("mqMsgCollection-mqOps");
    }


    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("mqMsgCollection");
    }

    @Bean
    Binding bindingMqMsgExchange(Queue mqOps,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(mqOps).to(fanoutExchange);
    }
    
    @Bean
	public SimpleMessageListenerContainer messageContainer1(ConnectionFactory connectionFactory,
			MqMsgListener mqMsgListener) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
		container.setQueues(mqOps());
		container.setExposeListenerChannel(true);
		container.setConcurrentConsumers(10);
		container.setAcknowledgeMode(AcknowledgeMode.AUTO); // 设置确认模式手工确认
		container.setMessageListener(mqMsgListener);
		container.setMaxConcurrentConsumers(10);//设置最大消费者数量 防止大批量涌入
		return container;
	}
    
//    @Bean
//    public DefaultClassMapper typeMapper() {
//        DefaultClassMapper typeMapper = new DefaultClassMapper();
//        Map<String, Class<?>> idClassMapping = new HashMap<String, Class<?>>();
////        idClassMapping.put("range", Track.class);
//        typeMapper.setIdClassMapping(idClassMapping);
//        //typeMapper.setDefaultType(Loan.class);
//        return typeMapper;
//    }
	
}
