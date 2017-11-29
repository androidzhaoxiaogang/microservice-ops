/*
* Copyright 2016 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : marketing-common
*
* @File name : WcMediaParamDto.java
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
* @ description 微信媒体信息上传DTO
* @date 2016年12月19日
*/

public class WcMediaParamDto  implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -2832595818919053173L;
    /**
     * 调用接口凭证
     */
    @JsonProperty("access_token") 
    private String accessToken;
    /**
     * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     */
    private String type;
    /**
     * form-data中媒体文件标识，有filename、filelength、content-type等信息 
     */
    private String media;
    
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
     * @return the type
     */
    public String getType() {
        return type;
    }
    
    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * @return the media
     */
    public String getMedia() {
        return media;
    }
    
    /**
     * @param media the media to set
     */
    public void setMedia(String media) {
        this.media = media;
    }
    
    
}
