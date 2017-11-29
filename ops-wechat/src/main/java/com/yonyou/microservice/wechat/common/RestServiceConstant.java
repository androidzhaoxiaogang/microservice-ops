/*
* Copyright 2016 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : marketing-dealer-open-api
*
* @File name : RestServiceConstant.java
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
	
package com.yonyou.microservice.wechat.common;


/**
*
* @author sangdeliang
* @ description REST常量
* @date 2016年11月29日
*/

public class RestServiceConstant {
    
    //REST放置的内容
    public static final String REST_BUSINESS_MSG = "REST_BUSINESS_MSG";
    //REST成/失败返回HTTP CODE
    public static final String REST_BUSINESS_HTTP_CODE = "REST_BUSINESS_HTTP_CODE";
    public static final int HTTP_SUCCESS_CODE = 201;
    public static final int HTTP_FAIL_CODE = 404;
    
    //REST处理成功/失败
    public static final String REST_BUSINESS_STATUS = "REST_BUSINESS_STATUS";
    public static final int REST_BUSINESS_SUCCESS = 1;
    public static final int REST_BUSINESS_FAEL = 0;
    
    //REST返回的OBJECT对象
    public static final String REST_BUSINESS_OBJECT = "REST_BUSINESS_OBJECT";
    
    //RESPONSE HEADERS存放的返回内容
    public static final String RESPONSE_HEADER_CONTENT = "RESPONSE_HEADER_CONTENT";
    //RESPONSE HEADERS存放的返回内容成功
    public static final String RESPONSE_HEADER_CONTENT_SUCCESS = "SUCCESS";
    public static final String REQUEST_HEAD_TIME_VALID_FAILED = "REQUEST_HEAD_TIME_VALID_FAILED";
    //REQUEST信息中加密微信ID,经销商CODE
    public static final String REQUEST_HEADER_WECHAT_ID = "WE_CHAT_ID";
    public static final String REQUEST_HEADER_DEALER_CODE = "DEALER_CODE";
    public static final String REQUEST_HEADER_TIME_STAMP = "SECURE_TIME_STAMP";
    public static final String REQUEST_URL_BODY_MD5_CODE = "SECURE_MD5_CODE";
    public static final String REST_CHECK_SECURITY_TIME_FAILED = "REST_CHECK_SECURITY_TIME_FAILED";
}
