/*
* Copyright 2016 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : marketing-service-wechat
*
* @File name : WebPageAuthUserInfo.java
*
* @Author : LiuJun
*
* @Date : 2016年12月8日
*
----------------------------------------------------------------------------------
*     Date       Who       Version     Comments
* 1. 2016年12月8日    LiuJun    1.0
*
*
*
*
----------------------------------------------------------------------------------
*/
	
package com.yonyou.microservice.wechat.dto;

import java.io.Serializable;

/**
*
* @author LiuJun
* 网页授权-用户信息
* @date 2016年12月8日
*/
public class WebPageAuthUserInfoDto implements Serializable{

    private static final long serialVersionUID = -8482842071811248429L;
    
    private String openid;//  用户的唯一标识
    private String nickname;//    用户昵称
    private String sex;// 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
    private String province;//    用户个人资料填写的省份
    private String city;//    普通用户个人资料填写的城市
    private String country;// 国家，如中国为CN
    private String headimgurl;//  用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
    private String[] privilege;//   用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
    private String unionid;// 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。详见：获取用户个人信息（UnionID机制）
    
    
    private String authorizerAppid;//授权方APPID
    private String dealerCode;
    
    private String errcode;
    private String errmsg;
    
    /**
     * @return the openid
     */
    public String getOpenid() {
        return openid;
    }
    
    /**
     * @param openid the openid to set
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }
    
    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }
    
    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }
    
    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }
    
    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }
    
    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }
    
    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }
    
    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }
    
    /**
     * @return the headimgurl
     */
    public String getHeadimgurl() {
        return headimgurl;
    }
    
    /**
     * @param headimgurl the headimgurl to set
     */
    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }
    
    
    /**
     * @return the privilege
     */
    public String[] getPrivilege() {
        return privilege;
    }

    
    /**
     * @param privilege the privilege to set
     */
    public void setPrivilege(String[] privilege) {
        this.privilege = privilege;
    }

    /**
     * @return the unionid
     */
    public String getUnionid() {
        return unionid;
    }
    
    /**
     * @param unionid the unionid to set
     */
    public void setUnionid(String unionid) {
        this.unionid = unionid;
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
