package com.yonyou.microservice.gate.admin.entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "gate_routes")
public class Route {
    @Id
	private Integer id;          
	private String path;          
	private String serviceId;          
	private String url;          
	private String stripPrefix;          
	private String retryable;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getStripPrefix() {
		return stripPrefix;
	}

	public void setStripPrefix(String stripPrefix) {
		this.stripPrefix = stripPrefix;
	}

	public String getRetryable() {
		return retryable;
	}

	public void setRetryable(String retryable) {
		this.retryable = retryable;
	}

}
