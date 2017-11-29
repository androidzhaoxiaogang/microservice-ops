/*
* Copyright 2016 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : JMC_APP
*
* @File name : TmNewsActivityWechatPO.java
*
* @Author : Administrator
*
* @Date : 2016年11月30日
*
----------------------------------------------------------------------------------
*     Date       Who       Version     Comments
* 1. 2016年11月30日    Administrator    1.0
*
*
*
*
----------------------------------------------------------------------------------
*/
	
package com.yonyou.microservice.wechat.dto;

import java.util.Date;
import java.util.List;


/**
 *
 * @author Administrator
 * @ description 新闻资讯推送给微信端的PO
 * @date 2016年11月30日
 */
public class TmNewsActivityWechatDto {

    private static final long serialVersionUID = 1L;
    //nviId
    private Long nviId;
    //tagsId
    private Long tagsId;
    //类型 0：新闻资讯 1：营销活动
    private Integer type;
    //标题
    private String title;
    //标题图片URL
    private String titleImageUrl;
    //标题图片字节流
    private String titleImageStream;
    //是否热点
    private Integer isHot;
    //热点图片URL
    private String hotImageUrl;
    //热点图片字节流
    private String hotImageStream;
    //开始时间
    private Date startTime;
    //结束时间
    private Date endTime;
    //状态 0：草稿 1：发布
    private int status;
    //发布时间
    private Date publishTime;
    //内容
    private String content;
    
    //经销商编号
    private String dealerCode;
    private List<String> openIdList;
    
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
     * @return the nviId
     */
    public Long getNviId() {
        return nviId;
    }
    
    /**
     * @param nviId the nviId to set
     */
    public void setNviId(Long nviId) {
        this.nviId = nviId;
    }
    
    /**
     * @return the tagsId
     */
    public Long getTagsId() {
        return tagsId;
    }
    
    /**
     * @param tagsId the tagsId to set
     */
    public void setTagsId(Long tagsId) {
        this.tagsId = tagsId;
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
     * @return the titleImageUrl
     */
    public String getTitleImageUrl() {
        return titleImageUrl;
    }
    
    /**
     * @param titleImageUrl the titleImageUrl to set
     */
    public void setTitleImageUrl(String titleImageUrl) {
        this.titleImageUrl = titleImageUrl;
    }
    
    /**
     * @return the titleImageStream
     */
    public String getTitleImageStream() {
        return titleImageStream;
    }
    
    /**
     * @param titleImageStream the titleImageStream to set
     */
    public void setTitleImageStream(String titleImageStream) {
        this.titleImageStream = titleImageStream;
    }
    
    /**
     * @return the isHot
     */
    public Integer getIsHot() {
        return isHot;
    }
    
    /**
     * @param isHot the isHot to set
     */
    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }
    
    /**
     * @return the hotImageUrl
     */
    public String getHotImageUrl() {
        return hotImageUrl;
    }
    
    /**
     * @param hotImageUrl the hotImageUrl to set
     */
    public void setHotImageUrl(String hotImageUrl) {
        this.hotImageUrl = hotImageUrl;
    }
    
    /**
     * @return the hotImageStream
     */
    public String getHotImageStream() {
        return hotImageStream;
    }
    
    /**
     * @param hotImageStream the hotImageStream to set
     */
    public void setHotImageStream(String hotImageStream) {
        this.hotImageStream = hotImageStream;
    }
    
    /**
     * @return the startTime
     */
    public Date getStartTime() {
        return startTime;
    }
    
    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    /**
     * @return the endTime
     */
    public Date getEndTime() {
        return endTime;
    }
    
    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    
    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }
    
    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }
    
    /**
     * @return the publishTime
     */
    public Date getPublishTime() {
        return publishTime;
    }
    
    /**
     * @param publishTime the publishTime to set
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
    
    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }



    
    /**
     * @return the dealerCode
     */
    public String getDealerCode() {
        return dealerCode;
    }



    
    /**
     * @param dealerCode the dealerCode to set
     */
    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }



	public List<String> getOpenIdList() {
		return openIdList;
	}



	public void setOpenIdList(List<String> openIdList) {
		this.openIdList = openIdList;
	}
    
    
}
