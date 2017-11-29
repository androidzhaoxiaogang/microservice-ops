/*
* Copyright 2016 SAIC-GM Corporation Ltd. All Rights Reserved.
*
* This software is published under the terms of the SAIC-GM Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project         marketing

* @Package         com.yonyou.marketing.wechat.entrance

* @Author          LuZhen

* @FileName        WeChatMessageContoller

* @Date            2016/12/19

----------------------------------------------------------------------------------
*     Date          Who             Version         Comments
* 1. 2016/12/19        LuZhen          1.0             Create Source
*
----------------------------------------------------------------------------------
*/
package com.yonyou.microservice.wechat.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yonyou.microservice.wechat.common.CookieConstant;
import com.yonyou.microservice.wechat.common.WechatDict;
import com.yonyou.microservice.wechat.entity.Check;
import com.yonyou.microservice.wechat.service.TokenService;
import com.yonyou.microservice.wechat.service.WechatMessageService;
import com.yonyou.microservice.wechat.service.WechatTemplatePublishService;
import com.yonyou.microservice.wechat.util.CookieSecurityUtil;

import net.sf.json.JSONObject;

@Controller
public class WeChatMessageController {

    private static Logger logger = Logger.getLogger(WeChatMessageController.class);

//    @Autowired
//    private MessageResolver messageResolver;

    @Autowired
    private ApplicationContext context;

//    @Autowired
//    private ListeningExecutorService executorService;
    
    @Autowired
    private WechatMessageService wechatMessageService;
    
    @Autowired
    private TokenService tokenService;
    @Autowired
    private WechatTemplatePublishService wechatTemplatePublishService;
    
//    @Autowired
//    private PushLocalThread push;

    //微信验证服务器回调接口  
	@RequestMapping(value = "/wechatcall/request", method = RequestMethod.GET)//, produces="text/html;charset=UTF-8"
	@ResponseBody 
	public String validateGet(Check tokenModel, HttpServletRequest req,
			HttpServletResponse res) throws ParseException, IOException {
		logger.info("----WeChatMessageController,get,check");
		String validate = wechatMessageService.validate(WechatDict.token, tokenModel);
		logger.info("---"+validate);
		return validate;
	}
    
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
    *///@RequestBody Map<String, String> map,
    @RequestMapping(value = "/wechatcall/request", method = RequestMethod.POST)//,  produces = "text/plain;charset=UTF-8"
    @ResponseBody
    public String receiveDealerWeChatMsg(
    		HttpServletRequest req,HttpServletResponse rps,@RequestBody String xml) throws Exception{
		logger.info("----WeChatMessageController,post,"+xml);
//        String returnMsg = wechatMessageService.receiveAndReplyDealerWeChatMsg(dealerAppid,nonce,timestamp,signature,xml);
		String returnMsg = wechatMessageService.receiveAndReplyDealerWeChatMsg(xml,rps);
		String openid=req.getParameter("openid");
		logger.info("----WeChatMessageController,openid,"+openid);
		writeWechatCookiesInfo(openid,rps);
        return returnMsg;
    }
    
	@RequestMapping(value = "/genToken", method = RequestMethod.GET)
	@ResponseBody
	public String genToken() {
		Map<String,String> map =new HashMap();
		String tmp=tokenService.genAccessToken();
		map.put("token", tmp);
		map.put("name", "success");
		logger.info("--genToken:"+tmp);
		JSONObject obj=JSONObject.fromObject(map);
		return obj.toString();
	}
    
	//发送模板消息
	@RequestMapping(value = "/wechat-push/api/sendTemplateMessage", method = RequestMethod.POST)
	@ResponseBody
	public String sendTemplateMessage(@RequestBody String message) {
		logger.info("--sendTemplateMessage:"+message);
		return wechatTemplatePublishService.sendTemplateMessage(message, tokenService.getAccessToken());
	}
    
	//添加消息模板
	@RequestMapping(value = "/wechat-push/api/addTemplate", method = RequestMethod.GET)
	@ResponseBody
	public String addTemplate(@RequestBody String message) {
		logger.info("--massSendPicTxtMessage:"+message);
		return wechatTemplatePublishService.addTemplate(message, tokenService.getAccessToken());
	}
    
//	//添加消息模板
//	@RequestMapping(value = "/wechat-push/api/addTemplate", method = RequestMethod.GET)
//	@ResponseBody
//	public String addTemplate(@RequestBody String message) {
//		return "";
//	}
    
	@RequestMapping(value = "/wechat-push/api/v1/user/{openid}", method = RequestMethod.GET)
	@ResponseBody
	public String getUserByopenid(@PathVariable("openid") String openid) {
		return wechatMessageService.getUser(openid);
	}

    
	@RequestMapping(value = "/wechatcall/test", method = RequestMethod.GET)//, produces="text/html;charset=UTF-8"
	@ResponseBody 
	public String validateTest(Check tokenModel, HttpServletRequest req,
			HttpServletResponse res) throws ParseException, IOException {
		logger.info("---test,user="+req.getHeader("user"));
		
		return "helloword";
	}
    private void writeWechatCookiesInfo(String openid, HttpServletResponse response){
		try {
	        Cookie cookies;
			cookies = new Cookie(CookieConstant.WECHAT_COOKIE_OPENID,CookieSecurityUtil.encrypt(openid));
			cookies.setMaxAge(30*60);
	        cookies.setPath("/");
	        response.addCookie(cookies);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }    
	
    //@RequestMapping(value = "/wechatcall/request",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public void receiveMessage(@RequestBody WeChatMessageProtocol protocol){
//        logger.debug("protocol is "+protocol);
//        //获取处理信息
//        WeChatMessageProtocolHandleInfo newHandleInfo = WeChatMessageProtocolHandleInfo.init(protocol.getHandleInfo());
//        protocol.setHandleInfo(newHandleInfo);
//        //丢弃消息
//        if(newHandleInfo.isDeprive()){
//            logger.error("deprive message "+protocol);
//            return;
//        }
//        //转换为协议消息
//        PushMessage pushMessage=messageResolver.receiveMessage(protocol);
//        //验证协议消息
//        if(!messageResolver.validateMessage(pushMessage)){
//            logger.error("message validate error");
//            return ;
//        }
//        push.push(pushMessage);
//    }

    
}
