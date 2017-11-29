/*
* Copyright 2016 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : marketing-dealer-open-api
*
* @File name : RestResultDto.java
*
* @Author : sangdeliang
*
* @Date : 2016年11月29日
*
----------------------------------------------------------------------------------
*     Date       Who       Version     Comments
* 1. 2016年11月29日    sangdeliang    1.0
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
* TODO description
* @date 2016年11月29日
*/

public class RestServiceResultDto {
    public final static int SUCCESS = 1;
    public final static int FAIL = 0;
    //0:失败 1:成功
    private int resultCode = SUCCESS;
    //返回的HTTP状态
    private int httpCode;
    //返回消息(成功，或者错误原因)
    private String resultMsg;
    //返回的JSON体内容(GET请求时候取得对象的集合)
    private String resultBody;
    /**
     * @return the resultCode
     */
    public int getResultCode() {
        return resultCode;
    }
    
    /**
     * @param resultCode the resultCode to set
     */
    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
    
    /**
     * @return the resultMsg
     */
    public String getResultMsg() {
        return resultMsg;
    }
    
    /**
     * @param resultMsg the resultMsg to set
     */
    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    
    /**
     * @return the httpCode
     */
    public int getHttpCode() {
        return httpCode;
    }

    
    /**
     * @param httpCode the httpCode to set
     */
    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    
    /**
     * @return the resultBody
     */
    public String getResultBody() {
        return resultBody;
    }

    
    /**
     * @param resultBody the resultBody to set
     */
    public void setResultBody(String resultBody) {
        this.resultBody = resultBody;
    }

    
    
}
