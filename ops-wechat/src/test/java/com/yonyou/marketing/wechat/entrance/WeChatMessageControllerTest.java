//package com.yonyou.marketing.wechat.entrance;
//
//import com.alibaba.fastjson.JSON;
//import com.yonyou.microservice.wechat.WeChatPushApplication;
//import com.yonyou.marketing.wechat.push.WeChatPushMessageTestUtil;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.marketing.common.entity.wechatpushmessage.WeChatMessageProtocol;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.junit.Assert.assertTrue;
//
///*
//* Copyright 2016 SAIC-GM Corporation Ltd. All Rights Reserved.
//*
//* This software is published under the terms of the SAIC-GM Software
//* License version 1.0, a copy of which has been included with this
//* distribution in the LICENSE.txt file.
//*
//* @Project         marketing
//
//* @Package         com.yonyou.marketing.wechat.entrance
//
//* @Author          LuZhen
//
//* @FileName        WeChatMessageContollerTest
//
//* @Date            2016/12/19
//
//----------------------------------------------------------------------------------
//*     Date          Who             Version         Comments
//* 1. 2016/12/19        LuZhen          1.0             Create Source
//*
//----------------------------------------------------------------------------------
//*/
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = WeChatPushApplication.class)
//@WebAppConfiguration
//public class WeChatMessageControllerTest {
//
//    @Autowired
//    private WebApplicationContext webApplicationConnect;
//
//    private MockMvc mockMvc;
//
//    @Before
//    public void setupMockMvc() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();
//    }
//
//    @Test
//    public void receiveMessage() throws Exception {
//        WeChatMessageProtocol origin = WeChatPushMessageTestUtil.getDemoWXTemplate();
//        MvcResult mvcResult = mockMvc.perform(
//                MockMvcRequestBuilders
//                        .post("/weChatMessages")
//                        .content(JSON.toJSONString(origin))
//                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andReturn();
//        int status = mvcResult.getResponse().getStatus();
//        System.out.println(status);
//        assertTrue(status == 200);
//    }
//
//}