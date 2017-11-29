/*
* Copyright 2017 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : marketing-common
*
* @File name : WcTemplateDetailDto.java
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
* 模板消息明细Dto
* @date 2017年1月12日
*/
public class WcTemplateDetailDto implements Serializable{

    private static final long serialVersionUID = -7037234832285467934L;
    
    @JsonProperty("template_id")
    private String templateId;
    private String title;
    
    @JsonProperty("primary_industry")
    private String primaryIndustry;
    
    @JsonProperty("deputy_industry")
    private String deputyIndustry;
    
    private String content;
    private String example;
    
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
    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * @return the primaryIndustry
     */
    public String getPrimaryIndustry() {
        return primaryIndustry;
    }
    
    /**
     * @param primaryIndustry the primaryIndustry to set
     */
    public void setPrimaryIndustry(String primaryIndustry) {
        this.primaryIndustry = primaryIndustry;
    }
    
    /**
     * @return the deputyIndustry
     */
    public String getDeputyIndustry() {
        return deputyIndustry;
    }
    
    /**
     * @param deputyIndustry the deputyIndustry to set
     */
    public void setDeputyIndustry(String deputyIndustry) {
        this.deputyIndustry = deputyIndustry;
    }
    
    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }
    
    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
    
    /**
     * @return the example
     */
    public String getExample() {
        return example;
    }
    
    /**
     * @param example the example to set
     */
    public void setExample(String example) {
        this.example = example;
    }
    
    

}
