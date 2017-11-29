///*
//* Copyright 2017 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
//*
//* This software is published under the terms of the YONYOU Software
//* License version 1.0, a copy of which has been included with this
//* distribution in the LICENSE.txt file.
//*
//* @Project Name : marketing-wechat-push
//*
//* @File name : MessageSenderTest.java
//*
//* @Author : LiuJun
//*
//* @Date : 2017年1月5日
//*
//----------------------------------------------------------------------------------
//*     Date       Who       Version     Comments
//* 1. 2017年1月5日    LiuJun    1.0
//*
//*
//*
//*
//----------------------------------------------------------------------------------
//*/
//	
//package com.yonyou.marketing.wechat.entrance;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.marketing.common.constants.MessagePushConstant;
//import org.marketing.common.entity.wechatpushmessage.WeChatMessageProtocol;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import com.yonyou.microservice.wechat.WeChatPushApplication;
//import com.yonyou.marketing.wechat.push.WeChatPushMessageTestUtil;
//
//
///**
//*
//* @author LiuJun
//* 消息队列发送单元测试
//* @date 2017年1月5日
//*/
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = WeChatPushApplication.class)
//public class MessageSenderTest {
//    
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//
//    @Test
//    public void sendMessageTest(){
//        WeChatMessageProtocol messageProtocol = WeChatPushMessageTestUtil.getDemoWXTemplate();
//        this.rabbitTemplate.convertAndSend(MessagePushConstant.WECHAT_QUEUE, messageProtocol);
//    }
//    
//    
//    
//    
//    
//
//}
