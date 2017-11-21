package com.yonyou.cloud.ops.mq.common;

public enum MqMessageType {
	SEND(100,"生产者"), CONSUMER(200,"生产者");

	private Integer code;
	private String name;

	private MqMessageType(Integer code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Integer getCode() {
		return code;
	}
	
	public static MqMessageType of(String type){
		try {
			MqMessageType result = MqMessageType.valueOf(type);
			return result;
		} catch (Exception e) {
		}
		return null;
	}

}
