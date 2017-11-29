/*
* Copyright 2016 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : marketing-common
*
* @File name : RestServiceErrDto.java
*
* @Author : sangdeliang
*
* @Date : 2016年12月12日
*
----------------------------------------------------------------------------------
*     Date       Who       Version     Comments
* 1. 2016年12月12日    sangdeliang    1.0
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
* @ description DMS返回的错误信息DTO
* @date 2016年12月12日
*/

public class RestServiceDmsErrDto {
    private String errorMsg;

    
    /**
     * @return the errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    
    /**
     * @param errorMsg the errorMsg to set
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    
    
}
