/*
* Copyright 2016 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : marketing-common
*
* @File name : WcAccessTokenResDto.java
*
* @Author : sangdeliang
*
* @Date : 2016年12月19日
*
----------------------------------------------------------------------------------
*     Date       Who       Version     Comments
* 1. 2016年12月19日    sangdeliang    1.0
*
*
*
*
----------------------------------------------------------------------------------
*/
	
package com.yonyou.microservice.wechat.dto.pictxt;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
*
* @author sangdeliang
* @ description 微信返回TOKEN结果
* @date 2016年12月19日
*/

public class WcTokenResultDto   implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 7181166627610550623L;

    @JsonProperty("access_token") 
    private String accessToken;
    
    @JsonProperty("expires_in") 
    private String expiresIn;
    
    /**
     * @return the accessToken
     */
    @JsonIgnore
    public String getAccessToken() {
        return accessToken;
    }
    
    /**
     * @param accessToken the accessToken to set
     */
    @JsonIgnore
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    
    /**
     * @return the expiresIn
     */
    @JsonIgnore
    public String getExpiresIn() {
        return expiresIn;
    }
    
    /**
     * @param expiresIn the expiresIn to set
     */
    @JsonIgnore
    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }
    
}
