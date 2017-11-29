/*
* Copyright 2016 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : marketing-service-wechat
*
* @File name : DealerWechatMessageController.java
*
* @Author : LiuJun
*
* @Date : 2016年12月6日
*
----------------------------------------------------------------------------------
*     Date       Who       Version     Comments
* 1. 2016年12月6日    LiuJun    1.0
*
*
*
*
----------------------------------------------------------------------------------
*/
	
package com.yonyou.microservice.wechat.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yonyou.microservice.wechat.common.ApiVersionConsts;
import com.yonyou.microservice.wechat.service.TokenService;
import com.yonyou.microservice.wechat.service.WechatLocalMassPublishService;

/**
*
* @author sangdeliang
* 经销商新闻资讯信息推送给用户
* @date 2016年12月6日
*/
@RestController
@RequestMapping(value = ApiVersionConsts.BASE_PATH )
public class WechatLocalPublishController {
    private static Logger logger=Logger.getLogger(WechatLocalPublishController.class);
    @Autowired
    private WechatLocalMassPublishService wechatLocalPublishService;
    @Autowired
    private TokenService tokenService;
//    @Autowired
//    private WebChatTemplateMessage webChatTemplateMessage;
    /**
    *
    * @author LiuJun
    * 接收经销商公众号消息入口
    * @date 2016年12月6日
    * @param openId
    * @param nonce
    * @param timestamp
    * @param signature
    * @param xml
    * @return
    */
    @RequestMapping(value = "/massSendMessage", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> massSendMessage() throws Exception{
        logger.info("newsInformationSend in");
        Map<String ,Object> resultMap ;
        try {
            String accessToken = tokenService.getAccessToken();
            
            resultMap = wechatLocalPublishService.treatWechatMessages(accessToken);//titleImageBytes, wechatInfo,
        } catch(Exception e) {
        	logger.error(e.getMessage(),e);
            resultMap = new HashMap<String , Object>();
            resultMap.put("STATUS", "0");
            resultMap.put("MESSAGE", e.getMessage());
        }
        return resultMap;
        
    }
    
//    //发送模板消息
//    @RequestMapping(value = "/templateMessage", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//    @ResponseBody
//    public String sendTemplateMessage(@RequestBody WeChatMessageProtocol origin) throws Exception{
//        logger.info("newsInformationSend in");
//        webChatTemplateMessage.transform(origin);
//        return "";
//        
//    }
    
    
    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> publictest() throws Exception{
        logger.info("newsInformationSend in");
        Map<String ,Object> resultMap ;
        try {
            String accessToken = tokenService.getAccessToken();
            
            resultMap = wechatLocalPublishService.treatWechatMessages(accessToken);//data, wechatInfo, 
        } catch(Exception e) {
            resultMap = new HashMap<>();
            resultMap.put("STATUS", "0");
            resultMap.put("MESSAGE", e.getMessage());
        }
        return resultMap;
        
    }
}
