package com.yonyou.microservice.gate.common.vo.user;

import java.io.Serializable;

public class AuthProviderInfo implements Serializable{

	private int id;
	private String srcUrl;
	private String authService;
	private String acceptType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSrcUrl() {
		return srcUrl;
	}
	public void setSrcUrl(String srcUrl) {
		this.srcUrl = srcUrl;
	}
	public String getAuthService() {
		return authService;
	}
	public void setAuthService(String authService) {
		this.authService = authService;
	}
	public String getAcceptType() {
		return acceptType;
	}
	public void setAcceptType(String acceptType) {
		this.acceptType = acceptType;
	}
	
}
