///*
//* Copyright 2016 YONYOU Corporation Ltd. All Rights Reserved.
//*
//* This software is published under the terms of the YONYOU Software
//* License version 1.0, a copy of which has been included with this
//* distribution in the LICENSE.txt file.
//*
//* @Project         marketing
//
//* @Package         com.yonyou.marketing.message.push.entrance
//
//* @Author          LuZhen
//
//* @FileName        MessageEntrance
//
//* @Date            2016/11/15
//
//----------------------------------------------------------------------------------
//*     Date          Who             Version         Comments
//* 1. 2016/11/15        LuZhen          1.0             Create Source
//*
//----------------------------------------------------------------------------------
//*/
//package com.yonyou.microservice.wechat.config;
//
//
//import java.util.concurrent.Executors;
//
//import org.apache.log4j.Logger;
////import org.marketing.common.constants.MessagePushConstant;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;
//
//import com.google.common.util.concurrent.ListeningExecutorService;
//import com.google.common.util.concurrent.MoreExecutors;
//import com.yonyou.microservice.wechat.common.MessagePushConstant;
//
//@Component
//public class PushMessageConfiguration {
//
//    private final static Logger logger = Logger.getLogger(PushMessageConfiguration.class);
//
////    @Bean
////    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
////    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
////        RabbitTemplate template = new RabbitTemplate(connectionFactory);
////        //json
////        template.setMessageConverter(new Jackson2JsonMessageConverter());
////        return template;
////    }
//
////    @Bean
////    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
////        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
////        factory.setConnectionFactory(connectionFactory);
////        factory.setMessageConverter(new Jackson2JsonMessageConverter());
////        //TODO 其它属性后续设置
////        return factory;
////    }
//
//
////    @Bean(name = MessagePushConstant.WECHAT_QUEUE_TEST)
////    public Queue testQueue() {
////        return new Queue(MessagePushConstant.WECHAT_QUEUE_TEST);
////    }
////
////    @Bean(name = MessagePushConstant.WECHAT_QUEUE)
////    public Queue queue() {
////        return new Queue(MessagePushConstant.WECHAT_QUEUE);
////    }
//
//
//    @Value("${marketing.message.pool.size}")
//    private int poolSize;
//
//    @Bean(name=MessagePushConstant.PROVIDER_POOL)
//    @Autowired
//    public ListeningExecutorService commandExecutorPool(){
//        return  MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(poolSize));
//    }
//
////    @Bean
////    public MessageProvideWebChatAdapter getMessageWebChatProvide() throws Exception{
////        ServiceLoader<MessageProvideWebChatAdapter> serviceLoader
////                =   ServiceLoader.load(MessageProvideWebChatAdapter.class);
////        //默认只有一个
////        if(serviceLoader.iterator().hasNext()) {
////            return serviceLoader.iterator().next();
////        }
////        else{
////            logger.error("no MessageProvideWebChatWxToolsProvide found");
////            throw new Exception("no MessageProvideWebChatWxToolsProvide found");
////        }
////    }
//
//
//}
