package com.yonyou.microservice.wechat.dto;

import java.util.Date;

public class EventWechatUnAttentionDTO {
    private Integer status;

    private Integer sourceType;

    private String authorizerAppid;
    
	private String deviceOpenId;

    private Date updateDate;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSourceType() {
		return sourceType;
	}

	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}

	public String getAuthorizerAppid() {
		return authorizerAppid;
	}

	public void setAuthorizerAppid(String authorizerAppid) {
		this.authorizerAppid = authorizerAppid;
	}

	public String getDeviceOpenId() {
		return deviceOpenId;
	}

	public void setDeviceOpenId(String deviceOpenId) {
		this.deviceOpenId = deviceOpenId;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
    
}
