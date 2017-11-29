/*
* Copyright 2017 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : marketing-service-dealer
*
* @File name : WoTemplatePO.java
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
	
package com.yonyou.microservice.wechat.entity;

import java.util.Date;

/**
*
* @author LiuJun
* 经销商公账号模板PO
* @date 2017年1月12日
*/
public class DealerWoTemplate {
    
    private Long woTemplateId;

    private String authorizerAppid;

    private String templateId;

    private String templateNum;

    private String title;

    private String primaryIndustry;

    private String deputyIndustry;

    private String content;

    private String example;

    private Date createDate;

    private Date updateDate;

    private Long createBy;

    private Long updateBy;

    
    /**
     * @return the woTemplateId
     */
    public Long getWoTemplateId() {
        return woTemplateId;
    }

    
    /**
     * @param woTemplateId the woTemplateId to set
     */
    public void setWoTemplateId(Long woTemplateId) {
        this.woTemplateId = woTemplateId;
    }

    
    /**
     * @return the authorizerAppid
     */
    public String getAuthorizerAppid() {
        return authorizerAppid;
    }

    
    /**
     * @param authorizerAppid the authorizerAppid to set
     */
    public void setAuthorizerAppid(String authorizerAppid) {
        this.authorizerAppid = authorizerAppid;
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

    
    /**
     * @return the templateNum
     */
    public String getTemplateNum() {
        return templateNum;
    }

    
    /**
     * @param templateNum the templateNum to set
     */
    public void setTemplateNum(String templateNum) {
        this.templateNum = templateNum;
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

    
    /**
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    
    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    
    /**
     * @return the updateDate
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    
    /**
     * @param updateDate the updateDate to set
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    
    /**
     * @return the createBy
     */
    public Long getCreateBy() {
        return createBy;
    }

    
    /**
     * @param createBy the createBy to set
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    
    /**
     * @return the updateBy
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    
    /**
     * @param updateBy the updateBy to set
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }
    
    

}
