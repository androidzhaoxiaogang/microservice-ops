/*
* Copyright 2016 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : marketing-dealer-open-api
*
* @File name : RestParamDto.java
*
* @Author : sangdeliang
*
* @Date : 2016年11月29日
*
----------------------------------------------------------------------------------
*     Date       Who       Version     Comments
* 1. 2016年11月29日    sangdeliang    1.0
*
*
*
*
----------------------------------------------------------------------------------
*/
	
package com.yonyou.microservice.wechat.dto.rest;

import java.util.Map;

/**
*
* @author sangdeliang
* @ description 参数封装
* @date 2016年11月29日
*/

public class RestServiceParamDto {
    //发送消息的对方地址URL
    private String url;
    //发送消息的JSON内容
    private String json;
    //消息头
    private Map<String, String> headersParams;
    //URL参数 放置在URL的后面，譬如 ?aaa=1&bbb=2
    private Map<String, String> urlParams;
    
    public RestServiceParamDto() {
        super();
    }
    /**
    *
    * @author sangdeliang
    * TODO description
    * @date 2016年11月29日
    * @param url
    * @param json
    * @param headersParams
    */
    	
    public RestServiceParamDto(String url, String json, Map<String, String> headersParams){
        super();
        this.url = url;
        this.json = json;
        this.headersParams = headersParams;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }
    
    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
    /**
     * @return the json
     */
    public String getJson() {
        return json;
    }
    
    /**
     * @param json the json to set
     */
    public void setJson(String json) {
        this.json = json;
    }

    
    /**
     * @return the headersParams
     */
    public Map<String, String> getHeadersParams() {
        return headersParams;
    }

    
    /**
     * @param headersParams the headersParams to set
     */
    public void setHeadersParams(Map<String, String> headersParams) {
        this.headersParams = headersParams;
    }
    
    /**
     * @return the urlParams
     */
    public Map<String, String> getUrlParams() {
        return urlParams;
    }
    
    /**
     * @param urlParams the urlParams to set
     */
    public void setUrlParams(Map<String, String> urlParams) {
        this.urlParams = urlParams;
    }

    
    
}
