package com.yonyou.microservice.wechat.entity;

/**
 * 微信accessToken类
 *
 */
public class AccessToken  {

	private static String accessToken; // 获取到的凭证
	private static String expiresIn; // 凭证有效时间，单位：秒
	private static String ticket; // jsapi_ticket
	String errcode;//全局返回码
	String errmsg;//说明
	
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	

	public static String getAccessToken() {
		return accessToken;
	}

	public static void setAccessToken(String accessToken) {
		AccessToken.accessToken = accessToken;
	}

	public static String getExpiresIn() {
		return expiresIn;
	}

	public static void setExpiresIn(String expiresIn) {
		AccessToken.expiresIn = expiresIn;
	}

	public static String getTicket() {
		return ticket;
	}

	public static void setTicket(String ticket) {
		AccessToken.ticket = ticket;
	}
	
}
