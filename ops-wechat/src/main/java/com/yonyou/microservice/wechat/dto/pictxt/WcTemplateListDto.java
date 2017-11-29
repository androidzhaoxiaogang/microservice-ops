/*
* Copyright 2017 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : marketing-common
*
* @File name : WcTemplateListDto.java
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
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
*
* @author LiuJun
* 模板消息列表Dto
* @date 2017年1月12日
*/
public class WcTemplateListDto implements Serializable{

    private static final long serialVersionUID = 3865018330074994304L;
    
    @JsonProperty("template_list")
    private List<WcTemplateDetailDto> templatelist;

    
    /**
     * @return the templatelist
     */
    public List<WcTemplateDetailDto> getTemplatelist() {
        return templatelist;
    }

    
    /**
     * @param templatelist the templatelist to set
     */
    public void setTemplatelist(List<WcTemplateDetailDto> templatelist) {
        this.templatelist = templatelist;
    }
    
    

}
