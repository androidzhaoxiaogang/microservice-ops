/*
* Copyright 2016 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : marketing-service-wechat
*
* @File name : DealerWechatPublistDao.java
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
	
package com.yonyou.microservice.wechat.dao;

import java.util.List;

import com.yonyou.microservice.wechat.dto.WechatLocalSendLogDto;


/**
*
* @author sangdeliang
* @ description 经销商微信信息推送DAO
* @date 2016年12月20日
*/

//@OracleDb
public interface WechatLocalPublistDao {
    /**
     * 
    *
    * @author sangdeliang
    * @ description 记录微信发送的结果日志
    * @date 2016年12月20日
    * @param logDto
     */
    public void wechatSaveResultLog(WechatLocalSendLogDto logDto);
    
    /**
     * 
    *
    * @author sangdeliang
    * @ description 获得需要批量推送的用户OPEN ID
    * @date 2016年12月20日
    * @return
     */
    public List<String> getWechatSendOpenIdList(String dealerCode);
    
    /**
     * 
    * 更新图片的URL
    * @author sangdeliang
    * TODO description
    * @date 2016年12月26日
     */
    public void modifyWechatImageUrl( String picUrl, Long navId);
}
