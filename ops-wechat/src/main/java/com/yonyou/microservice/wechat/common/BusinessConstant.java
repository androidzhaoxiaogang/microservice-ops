/*
* Copyright 2016 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : marketing-common
*
* @File name : BusinessConstant.java
*
* @Author : LiuJun
*
* @Date : 2016年11月10日
*
----------------------------------------------------------------------------------
*     Date       Who       Version     Comments
* 1. 2016年11月10日    LiuJun    1.0
*
*
*
*
----------------------------------------------------------------------------------
*/
	
package com.yonyou.microservice.wechat.common;


/**
*
* @author LiuJun
* 公共的业务常量定义
* @date 2016年11月10日
*/
public class BusinessConstant {
    /**
     * 来源类型10011001-微信,10011002-APP
     */
    public static final int SOURCE_TYPE_WECHAT = 10011001;
    public static final int SOURCE_TYPE_APP = 10011002;
    
    //潜在用户状态 10011001-关注 10011002-取消关注
    public static final int POTENTIAL_USER_STATUS_SUBSCRIBE = 10011001;
    public static final int POTENTIAL_USER_STATUS_CANCEL = 10011002;
    
    //车主默认密码
    public static final String CAROWNER_DEFAULT_PASS = "123456";
    
    //车辆与车主关系表状态0：启用1：禁用(删除)
    public static final int OWNER_CAR_RELATION_STATUS_NORMAL = 0;
    public static final int OWNER_CAR_RELATION_STATUS_DELETE = 1;
    /*
     * 分页
     */
    public static final int PAGE_SIZE = 10;
    public static final int CURRENT_PAGE = 1;
    
    public static final String EMPTY_STRING = "";
    
    public static final String SYSTEM_ID = "YONYOU_MK";
    
    public static final String MAINTAIN_WARING = "[满]";
    
    /**
     * 微信模板消息类别
     */
    //测试模板
    public static final String WECHAT_TEMPLATE_TYPE_TEST = "OPENTM201331503";
    
    //试驾预约已确认通知
    public static final String WECHAT_TEMPLATE_TYPE_TESTDRIVE_CONFIRMED_NOTIFICATION = "TM00629";
    
    //试驾已完成
    public static final String WECHAT_TEMPLATE_TYPE_TESTDRIVE_FINISHED= "TM00628";
    
    //保养预约已确认通知
    public static final String WECHAT_TEMPLATE_TYPE_MAINTENANCE_CONFIRMED_NOTIFICATION = "TM00627";
    
    //报价提醒
    public static final String WECHAT_TEMPLATE_TYPE_MAINTENANCE_ALERT= "OPENTM401181167";
    
    
    //发布给公众号模板列表-后期有新的可直接追加
    private static final String[] WECHAT_TEMPALTES = {"TM00629","TM00627","OPENTM401181167","TM00628"};
    

    
    /**
     * 潜客用户操作类型
     */
    public static final String POTENTIALUSER_OPERATETYPE_SUBSCRIBE = "SUBSCRIBE";

}
