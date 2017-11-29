//package com.yonyou.marketing.message.spi;
//
//import static org.junit.Assert.assertTrue;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.yonyou.microservice.wechat.WeChatPushApplication;
//import com.yonyou.microservice.wechat.entity.wechatpushmessage.WeChatMessageProtocol;
//import com.yonyou.microservice.wechat.provider.MessageProvideAdapter;
//import com.yonyou.microservice.wechat.provider.ProviderMessage;
//import com.yonyou.microservice.wechat.resolver.MessageResolver;
//import com.yonyou.microservice.wechat.resolver.PushMessage;
//import com.yonyou.marketing.wechat.push.WeChatPushMessageTestUtil;
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
//* @Package         com.yonyou.marketing.message.push.provider.impl
//
//* @Author          LuZhen
//
//* @FileName        MessageProvideWebChatWxToolsProvideTest
//
//* @Date            16/11/10
//
//----------------------------------------------------------------------------------
//*     Date          Who             Version         Comments
//* 1. 16/11/10        LuZhen          1.0             Create Source
//*
//----------------------------------------------------------------------------------
//*/
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = WeChatPushApplication.class)
//public class MessageProvideWebChatWxToolsProvideTest {
//    
//    @Autowired
//    private MessageProvideAdapter adapter;
//
//    @Autowired
//    private MessageResolver resolver;
//
//    @Test
//    public void push2ProviderCaseWXTemplateCase1() throws Exception {
//        //
////        WeChatMessageProtocol origin = WeChatPushMessageTestUtil.getDemoWXTemplate();
////        //
////        PushMessage pushMessage= WeChatPushMessageTestUtil.getPushMessage4Test(origin,resolver);
////        ProviderMessage providerMessage = adapter.trans2Provider(pushMessage);
//        //
////        assertTrue(adapter.push2Provider(providerMessage).getSuccess());
//    }
//
//}