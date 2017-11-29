/*
* Copyright 2016 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : marketing-common
*
* @File name : WcErrorResDto.java
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

/**
*
* @author sangdeliang
* @ description 微信返回消息ID
* @date 2016年12月19日
*/

public class WcMsgResultDto   implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -4343002905238390699L;
    /**
     * 错误编号
     */
    private String errcode;
    /**
     * 错误消息内容
     */
    private String errmsg;
    /**
     * 消息ID
     */
    private String msgid;
    /**
     * @return the errcode
     */
    public String getErrcode() {
        return errcode;
    }
    
    /**
     * @param errcode the errcode to set
     */
    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }
    
    /**
     * @return the errmsg
     */
    public String getErrmsg() {
        return errmsg;
    }
    
    /**
     * @param errmsg the errmsg to set
     */
    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    
    /**
     * @return the msgid
     */
    public String getMsgid() {
        return msgid;
    }

    
    /**
     * @param msgid the msgid to set
     */
    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }
    
}
