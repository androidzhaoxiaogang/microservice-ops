package com.yonyou.cloud.zuul.db.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="gate_routes")
public class RouteEntity {

	@Id
	private String id;          
	private String path;          
	private String serviceId;          
	private String url;          
	private Boolean stripPrefix;          
	private Boolean retryable;
	
	public RouteEntity() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean getStripPrefix() {
		return stripPrefix;
	}

	public void setStripPrefix(boolean stripPrefix) {
		this.stripPrefix = stripPrefix;
	}

	public Boolean getRetryable() {
		return retryable;
	}

	public void setRetryable(Boolean retryable) {
		this.retryable = retryable;
	}

	

}
