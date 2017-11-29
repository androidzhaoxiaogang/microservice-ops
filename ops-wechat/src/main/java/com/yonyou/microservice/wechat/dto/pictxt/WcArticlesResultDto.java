/*
* Copyright 2016 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : marketing-common
*
* @File name : WcArticlesResultDto.java
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
* @ description 图文小心返回结果DTO
* @date 2016年12月19日
*/

public class WcArticlesResultDto  implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -5426551382623355328L;
    /**
     * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb），次数为news，即图文消息 
     */
    private String type;
    /**
     * 媒体文件/图文消息上传后获取的唯一标识 
     */
    @JsonProperty("media_id") 
    private String mediaId;
    /**
     * 媒体文件上传时间 
     */
    @JsonProperty("created_at")
    private Long createdAt;
    
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
     * @return the mediaId
     */
    @JsonIgnore
    public String getMediaId() {
        return mediaId;
    }

    
    /**
     * @param mediaId the mediaId to set
     */
    @JsonIgnore
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    
    /**
     * @return the createdAt
     */
    @JsonIgnore
    public Long getCreatedAt() {
        return createdAt;
    }

    
    /**
     * @param createdAt the createdAt to set
     */
    @JsonIgnore
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }
    
    
}
