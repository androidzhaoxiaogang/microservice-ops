package com.youyou.microservice.auth.server.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "gate_auth_provider")
public class AuthProvider {
    @Id
	private int id;
    
    @Column(name="src_url")
	private String srcUrl;
    
    @Column(name="auth_service")
	private String authService;
    
    @Column(name="accept_type")
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
