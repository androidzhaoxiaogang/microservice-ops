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
//* @FileName        PushMessageTestUtil
//
//* @Date            16/11/5
//
//----------------------------------------------------------------------------------
//*     Date          Who             Version         Comments
//* 1. 16/11/5        LuZhen          1.0             Create Source
//*
//----------------------------------------------------------------------------------
//*/
//package com.yonyou.marketing.wechat.push;
//
//import static org.junit.Assert.assertTrue;
//import static org.marketing.common.constants.MessagePushConstant.WX_MSG_PROP_COLOR;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.marketing.common.constants.BusinessConstant;
//import org.marketing.common.constants.MessagePushConstant;
//import org.marketing.common.entity.wechatpushmessage.WeChatMessageProtocol;
//import org.marketing.common.entity.wechatpushmessage.WeChatMessageProtocolHandleInfo;
//import org.marketing.common.entity.wechatpushmessage.WeChatMessageProtocolMessageContent;
//import org.marketing.common.entity.wechatpushmessage.WeChatMessageProtocolMessageLinkContent;
//import org.marketing.common.entity.wechatpushmessage.WeChatMessageProtocolMessageTemplateContent;
//import org.marketing.common.entity.wechatpushmessage.WeChatMessageProtocolReceiver;
//import org.marketing.common.entity.wechatpushmessage.WeChatMessageProtocolSender;
//import org.marketing.common.util.DateUtil;
//
//import com.yonyou.microservice.wechat.resolver.MessageResolver;
//import com.yonyou.microservice.wechat.resolver.PushMessage;
//
///**
// * 测试帮助类
// */
//public class WeChatPushMessageTestUtil {
//
//    /**
//     * TEST WebChat Public Template Message
//     * 行业模板
//     * @return  MessageProtocol
//     */
//    public static WeChatMessageProtocol getDemoWXTemplate(){
//        WeChatMessageProtocol messageProtocol = new WeChatMessageProtocol();
//
//        WeChatMessageProtocolReceiver receiver = new WeChatMessageProtocolReceiver();
//        receiver.setDetail(true);
//        receiver.setPlatform(MessagePushConstant.PUSH_PLATFORM.WC_PUBLIC);
//        //openID 需要通过接口调用获取
////        receiver.addDetailList("omLPIwCuHiobN1XE09Sf_3G_LXiQ");//陆臻
//        receiver.addDetailList("omLPIwMuKtW70hklrdQDPLVnXZkU");//刘俊
//        receiver.addDetailList("omLPIwITFcilUn_u5EPrINDwFlPg");//陈春周
//        WeChatMessageProtocolMessageContent message = new WeChatMessageProtocolMessageContent();
//        //试驾预约
//        message.setContent("TM00629");
//        
//        message.setSourceType(BusinessConstant.SOURCE_TYPE_WECHAT);
//
//        //
//        WeChatMessageProtocolMessageTemplateContent content1 = new WeChatMessageProtocolMessageTemplateContent();
//        content1.setKey("first");content1.setValue("您的试驾预约已安排");
//        content1.addExtraMap(WX_MSG_PROP_COLOR,"#FF0000");
//        message.addTemplateConentList(content1);
//
//        WeChatMessageProtocolMessageTemplateContent content2 = new WeChatMessageProtocolMessageTemplateContent();
//        content2.setKey("keynote1");content2.setValue("宝马XYZ");
//        message.addTemplateConentList(content2);
//
//        WeChatMessageProtocolMessageTemplateContent content3 = new WeChatMessageProtocolMessageTemplateContent();
//        content3.setKey("keynote2");content3.setValue(DateUtil2.formateDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
//        message.addTemplateConentList(content3);
//
//        WeChatMessageProtocolMessageTemplateContent content4 = new WeChatMessageProtocolMessageTemplateContent();
//        content4.setKey("keynote3");content4.setValue("ABC顾问");
//        message.addTemplateConentList(content4);
//
//        
//        WeChatMessageProtocolMessageTemplateContent content5 = new WeChatMessageProtocolMessageTemplateContent();
//        content5.setKey("remark");content5.setValue("我是备注Test");
//        message.addTemplateConentList(content5);
//
//        WeChatMessageProtocolSender sender = new WeChatMessageProtocolSender();
//        sender.setOriginApplicationHost("host1");
//        sender.setOriginApplicationName("app1");
//        sender.setClientAppId("wxb85ed633e428bafc");
//        sender.setDealerCode("270001");
//        messageProtocol.setMessage(message);
//        messageProtocol.setReceiver(receiver);
//        messageProtocol.setSender(sender);
//        messageProtocol.setPushChannel(MessagePushConstant.PUSH_CHANNEL.WEBCHAT);
//
//        return messageProtocol;
//    }
//
//    /**
//     * TEST 微信客服文字消息
//     * @return  MessageProtocol
//     */
//    public static WeChatMessageProtocol getDemoWebchatCustomTextMessage(){
//        WeChatMessageProtocol messageProtocol = new WeChatMessageProtocol();
//
//        WeChatMessageProtocolReceiver receiver = new WeChatMessageProtocolReceiver();
//        receiver.setDetail(true);
//        receiver.addDetailList("openId1");
//
//
//        WeChatMessageProtocolMessageContent message = new WeChatMessageProtocolMessageContent();
//        message.setContent("custom text message");
//        message.setContentType(MessagePushConstant.MESSAGE_CONTENT_TYPE.TEXT);
//
//        WeChatMessageProtocolSender sender = new WeChatMessageProtocolSender();
//        sender.setOriginApplicationHost("host1");
//        sender.setOriginApplicationName("app1");
//        sender.setClientAppId("wxb85ed633e428bafc");
//
//        messageProtocol.setMessage(message);
//        messageProtocol.setReceiver(receiver);
//        messageProtocol.setSender(sender);
//        messageProtocol.setPushChannel(MessagePushConstant.PUSH_CHANNEL.WEBCHAT);
//
//        return messageProtocol;
//    }
//
//
//
//    /**
//     * TEST 微信客服图片消息
//     * @return  MessageProtocol
//     */
//    public static WeChatMessageProtocol getDemoWebchatCustomPicMessage(){
//        WeChatMessageProtocol messageProtocol = new WeChatMessageProtocol();
//
//        WeChatMessageProtocolReceiver receiver = new WeChatMessageProtocolReceiver();
//        receiver.setDetail(true);
//        receiver.addDetailList("openId2");
//
//        WeChatMessageProtocolMessageContent message = new WeChatMessageProtocolMessageContent();
//        message.setContent("MEDIA_ID");
//        message.setContentType(MessagePushConstant.MESSAGE_CONTENT_TYPE.IMAGE);
//
//        WeChatMessageProtocolSender sender = new WeChatMessageProtocolSender();
//        sender.setOriginApplicationHost("host1");
//        sender.setOriginApplicationName("app1");
//        sender.setClientAppId("wxb85ed633e428bafc");
//
//        messageProtocol.setMessage(message);
//        messageProtocol.setReceiver(receiver);
//        messageProtocol.setSender(sender);
//        messageProtocol.setPushChannel(MessagePushConstant.PUSH_CHANNEL.WEBCHAT);
//
//        return messageProtocol;
//    }
//
//    /**
//     * TEST 微信客服语音消息
//     * @return  MessageProtocol
//     */
//    public static WeChatMessageProtocol getDemoWebchatCustomVoiceMessage(){
//        WeChatMessageProtocol messageProtocol = new WeChatMessageProtocol();
//
//        WeChatMessageProtocolReceiver receiver = new WeChatMessageProtocolReceiver();
//        receiver.setDetail(true);
//        receiver.addDetailList("openId2");
//
//        WeChatMessageProtocolMessageContent message = new WeChatMessageProtocolMessageContent();
//        message.setContent("MEDIA_ID");
//        message.setContentType(MessagePushConstant.MESSAGE_CONTENT_TYPE.VOICE);
//
//        WeChatMessageProtocolSender sender = new WeChatMessageProtocolSender();
//        sender.setOriginApplicationHost("host1");
//        sender.setOriginApplicationName("app1");
//        sender.setClientAppId("wxb85ed633e428bafc");
//
//        messageProtocol.setMessage(message);
//        messageProtocol.setReceiver(receiver);
//        messageProtocol.setSender(sender);
//        messageProtocol.setPushChannel(MessagePushConstant.PUSH_CHANNEL.WEBCHAT);
//
//        return messageProtocol;
//    }
//
//
//    /**
//     * TEST 微信客服视频消息
//     * @return  MessageProtocol
//     */
//    public static WeChatMessageProtocol getDemoWebchatVIDEOMessage(){
//        WeChatMessageProtocol messageProtocol = new WeChatMessageProtocol();
//
//        WeChatMessageProtocolReceiver receiver = new WeChatMessageProtocolReceiver();
//        receiver.setDetail(true);
//        receiver.addDetailList("openId3");
//
//        WeChatMessageProtocolMessageContent message = new WeChatMessageProtocolMessageContent();
//        message.setContent("MEDIA_ID");
//        message.setTitle("TITLE");
//        message.setContentType(MessagePushConstant.MESSAGE_CONTENT_TYPE.VIDEO);
//        Map<String,String> extraMap= new HashMap<>();
//        extraMap.put(MessagePushConstant.WX_MSG_PROP_DESC,"desc1");
//        extraMap.put(MessagePushConstant.WX_MSG_PROP_THUMB,"media1");
//        message.addExtraParaMap(extraMap);
//
//
//        WeChatMessageProtocolSender sender = new WeChatMessageProtocolSender();
//        sender.setOriginApplicationHost("host1");
//        sender.setOriginApplicationName("app1");
//        sender.setClientAppId("wxb85ed633e428bafc");
//
//        messageProtocol.setMessage(message);
//        messageProtocol.setReceiver(receiver);
//        messageProtocol.setSender(sender);
//        messageProtocol.setPushChannel(MessagePushConstant.PUSH_CHANNEL.WEBCHAT);
//
//        return messageProtocol;
//    }
//
//
//
//    /**
//     * TEST 微信客服图文消息
//     * @return  MessageProtocol
//     */
//    public static WeChatMessageProtocol getDemoWebchatArticleMessage(){
//        WeChatMessageProtocol messageProtocol = new WeChatMessageProtocol();
//
//        WeChatMessageProtocolReceiver receiver = new WeChatMessageProtocolReceiver();
//        receiver.setDetail(true);
//        receiver.addDetailList("openId4");
//
//        WeChatMessageProtocolMessageContent message = new WeChatMessageProtocolMessageContent();
//        message.setContent("MEDIA_ID");
//        message.setContentType(MessagePushConstant.MESSAGE_CONTENT_TYPE.NEWS);
//        WeChatMessageProtocolMessageLinkContent linkContent1 = new WeChatMessageProtocolMessageLinkContent();
//        linkContent1.setTitle("title1");
//        linkContent1.setDesc("desc1");
//        linkContent1.setPicUrl("pic1");
//        linkContent1.setUrl("url1");
//        WeChatMessageProtocolMessageLinkContent linkContent2 = new WeChatMessageProtocolMessageLinkContent();
//        linkContent2.setTitle("title2");
//        linkContent2.setDesc("desc2");
//        linkContent2.setPicUrl("pic2");
//        linkContent2.setUrl("url2");
//        List<WeChatMessageProtocolMessageLinkContent> linkContentList = new ArrayList<>();
//        linkContentList.add(linkContent1);
//        linkContentList.add(linkContent2);
//        message.addLinkContentList(linkContentList);
//        Map<String,String> extraMap= new HashMap<>();
//        extraMap.put(MessagePushConstant.WX_MSG_PROP_DESC,"desc1");
//        extraMap.put(MessagePushConstant.WX_MSG_PROP_THUMB,"media1");
//        message.addExtraParaMap(extraMap);
//
//        WeChatMessageProtocolSender sender = new WeChatMessageProtocolSender();
//        sender.setOriginApplicationHost("host1");
//        sender.setOriginApplicationName("app1");
//        sender.setClientAppId("wxb85ed633e428bafc");
//
//        messageProtocol.setMessage(message);
//        messageProtocol.setReceiver(receiver);
//        messageProtocol.setSender(sender);
//        messageProtocol.setPushChannel(MessagePushConstant.PUSH_CHANNEL.WEBCHAT);
//
//        return messageProtocol;
//    }
//
//    /**
//     * 快速获取测试模拟推送消息
//     * @param origin   messageProtocol
//     * @param resolver          resolver
//     * @return  PushMessage
//     */
//    public static PushMessage getPushMessage4Test(WeChatMessageProtocol origin, MessageResolver resolver){
//        WeChatMessageProtocolHandleInfo newHandleInfo = WeChatMessageProtocolHandleInfo.init(origin.getHandleInfo());
//        origin.setHandleInfo(newHandleInfo);
//        PushMessage pushMessage = resolver.receiveMessage(origin);
//        assertTrue(resolver.validateMessage(pushMessage));
//        return pushMessage;
//    }
//
//}
