/*
* Copyright 2017 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : marketing-common
*
* @File name : WcTemplateIdDto.java
*
* @Author : LiuJun
*
* @Date : 2017年1月12日
*
----------------------------------------------------------------------------------
*     Date       Who       Version     Comments
* 1. 2017年1月12日    LiuJun    1.0
*
*
*
*
----------------------------------------------------------------------------------
*/
	
package com.yonyou.microservice.wechat.dto.pictxt;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
*
* @author LiuJun
* 模板消息IDDto
* @date 2017年1月12日
*/
public class WcTemplateIdDto implements Serializable{
    
    private static final long serialVersionUID = -5370773206512187037L;

    private String errcode;
    
    private String errmsg;
    
    @JsonProperty("template_id")
    private String  templateId;

    
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
     * @return the templateId
     */
    public String getTemplateId() {
        return templateId;
    }

    
    /**
     * @param templateId the templateId to set
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }
    
    
    

}
