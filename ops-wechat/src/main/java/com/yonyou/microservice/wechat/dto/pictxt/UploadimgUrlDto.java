/*
* Copyright 2016 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : marketing-common
*
* @File name : UploadimgUrlDto.java
*
* @Author : LiuJun
*
* @Date : 2016年12月26日
*
----------------------------------------------------------------------------------
*     Date       Who       Version     Comments
* 1. 2016年12月26日    LiuJun    1.0
*
*
*
*
----------------------------------------------------------------------------------
*/
	
package com.yonyou.microservice.wechat.dto.pictxt;

import java.io.Serializable;

/**
*
* @author LiuJun
* 上传图片urldto
* @date 2016年12月26日
*/
public class UploadimgUrlDto implements Serializable{

    private static final long serialVersionUID = -8345349017936244794L;
    
    private String url;
    
    private String errcode;
    private String errmsg;
    
    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }
    
    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
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
    
    


}
