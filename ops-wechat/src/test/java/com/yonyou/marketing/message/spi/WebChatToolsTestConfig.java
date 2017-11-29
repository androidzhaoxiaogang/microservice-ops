/*
* Copyright 2016 YONYOU Corporation Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project         marketing

* @Package         com.yonyou.marketing.message.push.spi.webchattools

* @Author          LuZhen

* @FileName        WebChatToolesConfig

* @Date            2016/11/16

----------------------------------------------------------------------------------
*     Date          Who             Version         Comments
* 1. 2016/11/16        LuZhen          1.0             Create Source
*
----------------------------------------------------------------------------------
*/
package com.yonyou.marketing.message.spi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:wechatTest.properties")
public class WebChatToolsTestConfig {

    @Value("${marketing.message.sender.webchat.appid}")
    private String webChatAppId;

    @Value("${marketing.message.sender.webchat.token}")
    private String webChatToken;

    @Value("${marketing.message.sender.webchat.appsecret}")
    private String webChatSecret;

    @Value("${marketing.message.sender.webchat.encodingAESKey}")
    private String webChatEncodingAESKey;


    public String getWebChatAppId() {
        return webChatAppId;
    }

    public void setWebChatAppId(String webChatAppId) {
        this.webChatAppId = webChatAppId;
    }

    public String getWebChatToken() {
        return webChatToken;
    }

    public void setWebChatToken(String webChatToken) {
        this.webChatToken = webChatToken;
    }

    public String getWebChatSecret() {
        return webChatSecret;
    }

    public void setWebChatSecret(String webChatSecret) {
        this.webChatSecret = webChatSecret;
    }

    public String getWebChatEncodingAESKey() {
        return webChatEncodingAESKey;
    }

    public void setWebChatEncodingAESKey(String webChatEncodingAESKey) {
        this.webChatEncodingAESKey = webChatEncodingAESKey;
    }

    @Override
    public String toString() {
        return "WebChatToolesConfig{" +
                "webChatAppId='" + webChatAppId + '\'' +
                ", webChatToken='" + webChatToken + '\'' +
                ", webChatSecret='" + webChatSecret + '\'' +
                ", webChatEncodingAESKey='" + webChatEncodingAESKey + '\'' +
                '}';
    }
}
