//package com.yonyou.marketing.wechat.push;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.marketing.common.constants.MessagePushConstant;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.context.ApplicationContext;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.yonyou.microservice.wechat.WeChatPushApplication;
//
//import static org.junit.Assert.*;
//
///*
//* Copyright 2016 YONYOU Corporation Ltd. All Rights Reserved.
//*
//* This software is published under the terms of the YONYOU Software
//* License version 1.0, a copy of which has been included with this
//* distribution in the LICENSE.txt file.
//*
//* @Project         marketing
//
//* @Package         com.yonyou.marketing.message.push
//
//* @Author          LuZhen
//
//* @FileName        PushApplicationTest
//
//* @Date            16/11/3
//
//----------------------------------------------------------------------------------
//*     Date          Who             Version         Comments
//* 1. 16/11/3        LuZhen          1.0             Create Source
//*
//----------------------------------------------------------------------------------
//*/
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = WeChatPushApplication.class)
//public class WeChatPushApplicationTest {
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    @Test
//    public void queue() throws Exception {
//        assertNotNull(applicationContext.getBean(MessagePushConstant.WECHAT_QUEUE));
//    }
//
//    @Test
//    public void testQueue() throws Exception {
//        assertNotNull(applicationContext.getBean(MessagePushConstant.WECHAT_QUEUE_TEST));
//    }
//
//    @Test
//    public void commandExecutorPool() throws Exception {
//        assertNotNull(applicationContext.getBean(MessagePushConstant.PROVIDER_POOL));
//    }
//
//}