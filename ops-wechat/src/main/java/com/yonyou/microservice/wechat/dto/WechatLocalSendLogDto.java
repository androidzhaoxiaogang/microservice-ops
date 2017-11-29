/*
* Copyright 2016 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : marketing-service-wechat
*
* @File name : WechatSendLogDto.java
*
* @Author : sangdeliang
*
* @Date : 2016年12月20日
*
----------------------------------------------------------------------------------
*     Date       Who       Version     Comments
* 1. 2016年12月20日    sangdeliang    1.0
*
*
*
*
----------------------------------------------------------------------------------
*/
	
package com.yonyou.microservice.wechat.dto;

import java.util.Date;

/**
*
* @author sangdeliang
* @ description 微信发送记录日志
* @date 2016年12月20日
*/

public class WechatLocalSendLogDto {
    
    //主键ID
    private Long tlWechatSendId;
    //类型 1:上传图片信息 2:上传图文信息 3:批量发送 4:上传关注图片信息
    private Integer type;
    //备注
    private String remark;
    //是否成功 是否成功 1:成功  0:失败'
    private int isSuccess;
    //错误信息
    private String errorInfo;
    private Date createDate;
    private Long createBy;
    private Date updateDate;
    private Long updateBy;
    
    public WechatLocalSendLogDto(){
        super();
    };
    
    public WechatLocalSendLogDto(Integer type, String remark, Integer isSuccess, String errorInfo) {
        this.type = type;
        this.remark = remark;
        this.isSuccess = isSuccess;
        this.errorInfo = errorInfo;
    }
    /**
     * @return the tlWechatSendId
     */
    public Long getTlWechatSendId() {
        return tlWechatSendId;
    }
    
    /**
     * @param tlWechatSendId the tlWechatSendId to set
     */
    public void setTlWechatSendId(Long tlWechatSendId) {
        this.tlWechatSendId = tlWechatSendId;
    }
    
    /**
     * @return the type
     */
    public Integer getType() {
        return type;
    }
    
    /**
     * @param type the type to set
     */
    public void setType(Integer type) {
        this.type = type;
    }
    
    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }
    
    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    /**
     * @return the isSuccess
     */
    public int getIsSuccess() {
        return isSuccess;
    }
    
    /**
     * @param isSuccess the isSuccess to set
     */
    public void setIsSuccess(int isSuccess) {
        this.isSuccess = isSuccess;
    }
    
    /**
     * @return the errorInfo
     */
    public String getErrorInfo() {
        return errorInfo;
    }
    
    /**
     * @param errorInfo the errorInfo to set
     */
    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
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

    //上传图片
    public static final int TYPE_UPLOAD_PIC = 1;
    //上传图文信息
    public static final int TYPE_UPLOAD_PIC_AND_TEXT = 2;
    //批量发送给关注号
    public static final int TYPE_BATCH_SEND_OPENUSER = 3;
    //上传给关注用户的图片
    public static final int TYPE_UPLOAD_CARE_PIC = 4;
    //成功
    public static final int SUCCESS_YES = 1;
    //失败
    public static final int SUCCESS_NO = 0;
    //数据库错误信息最大保存1999个字符，最小0个
    public static final int LOG_WORD_MIN = 0;
    public static final int LOG_WORD_MAX = 666;
}
