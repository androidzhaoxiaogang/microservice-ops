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
package com.yonyou.microservice.wechat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class WebChatToolsConfig {



    @Value("${marketing.message.sender.webchat.template.sendUrl}")
    private String webChatTemplateSendUrl;

    @Value("${marketing.message.sender.webchat.template.addUrl}")
    private String webChatTemplateAddUrl;

    @Value("${marketing.message.sender.wechat.tokenUrl}")
    private String webChatTokenUrl;
    
    @Value("${query.template.id.url}")
    private String dealerTemplateIdUrl;


    public String getWebChatTokenUrl() {
        return webChatTokenUrl;
    }

    public void setWebChatTokenUrl(String webChatTokenUrl) {
        this.webChatTokenUrl = webChatTokenUrl;
    }


    public String getWebChatTemplateSendUrl() {
        return webChatTemplateSendUrl;
    }

    public void setWebChatTemplateSendUrl(String webChatTemplateSendUrl) {
        this.webChatTemplateSendUrl = webChatTemplateSendUrl;
    }



    public String getWebChatTemplateAddUrl() {
        return webChatTemplateAddUrl;
    }

    public void setWebChatTemplateAddUrl(String webChatTemplateAddUrl) {
        this.webChatTemplateAddUrl = webChatTemplateAddUrl;
    }
    
    
    /**
     * @return the dealerTemplateIdUrl
     */
    public String getDealerTemplateIdUrl() {
        return dealerTemplateIdUrl;
    }

    
    /**
     * @param dealerTemplateIdUrl the dealerTemplateIdUrl to set
     */
    public void setDealerTemplateIdUrl(String dealerTemplateIdUrl) {
        this.dealerTemplateIdUrl = dealerTemplateIdUrl;
    }

    @Override
    public String toString() {
        return "WebChatToolsConfig{" +
                "webChatTemplateSendUrl='" + webChatTemplateSendUrl + '\'' +
                ", webChatTemplateAddUrl='" + webChatTemplateAddUrl + '\'' +
                ", webChatTokenUrl='" + webChatTokenUrl + '\'' +
                '}';
    }
}
