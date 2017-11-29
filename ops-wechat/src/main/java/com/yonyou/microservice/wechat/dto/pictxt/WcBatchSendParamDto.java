/*
* Copyright 2016 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : marketing-common
*
* @File name : WcBatchSendParamDto.java
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
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
*
* @author sangdeliang
* @ description 批量群发微信消息
* @date 2016年12月19日
*/

public class WcBatchSendParamDto   implements Serializable{

    private static final long serialVersionUID = -197059459965258338L;

    /**
     * 填写图文消息的接收者，一串OpenID列表，OpenID最少2个，最多10000个 
     */
    private List<String> touser;
    
    /**
     * 群发的消息类型，图文消息为mpnews，文本消息为text，语音为voice，音乐为music，图片为image，视频为video，卡券为wxcard 
     */
    private String msgtype;
    /**
     *  用于设定即将发送的图文消息 
     */
    private Mpnews mpnews = new Mpnews();
    
    
    
    /**
     * @return the touser
     */
    public List<String> getTouser() {
        return touser;
    }


    
    /**
     * @param touser the touser to set
     */
    public void setTouser(List<String> touser) {
        this.touser = touser;
    }


    
    /**
     * @return the msgtype
     */
    public String getMsgtype() {
        return msgtype;
    }


    
    /**
     * @param msgtype the msgtype to set
     */
    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }


    
    /**
     * @return the mpnews
     */
    public Mpnews getMpnews() {
        return mpnews;
    }


    
    /**
     * @param mpnews the mpnews to set
     */
    public void setMpnews(Mpnews mpnews) {
        this.mpnews = mpnews;
    }


    public class Mpnews   implements Serializable{

        private static final long serialVersionUID = 7155357813356368576L;
        /**
         * 用于群发的图文消息的media_id 
         */
        @JsonProperty("media_id") 
        private String mediaId;

        
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
        
    }

}
