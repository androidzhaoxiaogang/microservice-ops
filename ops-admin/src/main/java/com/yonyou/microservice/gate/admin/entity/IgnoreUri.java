package com.yonyou.microservice.gate.admin.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "gate_ignore_uri")
public class IgnoreUri {
    @Id
	private int id;
    
	private String uri;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}


}
