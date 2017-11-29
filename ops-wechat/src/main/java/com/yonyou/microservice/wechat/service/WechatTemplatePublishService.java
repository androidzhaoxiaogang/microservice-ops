package com.yonyou.microservice.wechat.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.xiaoleilu.hutool.http.HttpUtil;
import com.yonyou.microservice.wechat.config.WebChatToolsConfig;

@Service
public class WechatTemplatePublishService {
    private final static Logger logger = Logger.getLogger(WechatTemplatePublishService.class);
    @Autowired
    private WebChatToolsConfig config;

	public String sendTemplateMessage(String templateMessage, String accessToken) {
        //WxMpSendTemplateMessageResponse responseContent;
        String body;
        try {
//            responseContent = restTemplate.postForEntity
//                    (config.getWebChatTemplateSendUrl()+"?access_token="+accessToken,
//                    templateMessage,WxMpSendTemplateMessageResponse.class).getBody();
            logger.debug("postdata is "+templateMessage);
            body=HttpUtil.post(config.getWebChatTemplateSendUrl()+"?access_token="+accessToken, templateMessage);
//            responseContent = JSON.parseObject(body,WxMpSendTemplateMessageResponse.class);
        } catch (RestClientException e) {
            logger.error(e);
//            responseContent = new WxMpSendTemplateMessageResponse();
//            responseContent.setErrorCode(-1);
//            responseContent.setErrorMessage("fail");
//            responseContent.setMessageId("-1");
            return "505";
        }
        return body;
	}
    
    
	public String addTemplate(String templateMessage, String accessToken) {
		String body;
        try {
//            responseContent = restTemplate.postForEntity
//                    (config.getWebChatTemplateAddUrl()+"?access_token="+accessToken, request,WxMpAddTemplateResponse.class).getBody();

            body=HttpUtil.post(config.getWebChatTemplateAddUrl()+"?access_token="+accessToken, templateMessage);
        } catch (RestClientException e) {
            logger.error(e);
//            responseContent = new WxMpAddTemplateResponse();
//            responseContent.setErrorCode(-1);
//            responseContent.setErrorMessage("fail");
//            responseContent.setTemplateId("-1");
            return "505";
        }
        return body;
	}
}
