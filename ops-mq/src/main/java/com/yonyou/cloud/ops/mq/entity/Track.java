package com.yonyou.cloud.ops.mq.entity;

public class Track {
	
	
	private String host;
	
	private String properties;
	

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "MqData [ host=" + host + ", properties=" + properties + "]";
	}

	
	
	
	
}
