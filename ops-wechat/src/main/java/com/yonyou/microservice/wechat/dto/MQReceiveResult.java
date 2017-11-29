package com.yonyou.microservice.wechat.dto;

public class MQReceiveResult {
	private String result;
	
	private String message;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
