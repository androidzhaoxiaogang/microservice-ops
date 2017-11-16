package com.yonyou.cloud.ops.mq.entity;

public class MqData {
	
	private String msgKey;
	
	private String host;
	
	private String properties;

	public String getMsgKey() {
		return msgKey;
	}

	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
	}

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
		return "MqData [msgKey=" + msgKey + ", host=" + host + ", properties=" + properties + "]";
	}

	
	
	
	
}
