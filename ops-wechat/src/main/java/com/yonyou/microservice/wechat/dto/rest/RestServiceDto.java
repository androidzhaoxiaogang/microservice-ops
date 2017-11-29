/*
* Copyright 2016 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : marketing-common
*
* @File name : DealerSeriesDtl.java
*
* @Author : sangdeliang
*
* @Date : 2016年11月24日
*
----------------------------------------------------------------------------------
*     Date       Who       Version     Comments
* 1. 2016年11月24日    sangdeliang    1.0
*
*
*
*
----------------------------------------------------------------------------------
*/
	
package com.yonyou.microservice.wechat.dto.rest;


/**
*
* @author sangdeliang
* @ description 车系DTO
* @date 2016年11月24日
*/

public class RestServiceDto {
    //测试车系编号
    private String seriesCode;
    //测试车系名称
    private String seriesName;
    
    /**
     * @return the seriesCode
     */
    public String getSeriesCode() {
        return seriesCode;
    }
    
    /**
     * @param seriesCode the seriesCode to set
     */
    public void setSeriesCode(String seriesCode) {
        this.seriesCode = seriesCode;
    }
    
    /**
     * @return the seriesName
     */
    public String getSeriesName() {
        return seriesName;
    }
    
    /**
     * @param seriesName the seriesName to set
     */
    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }
    
}
