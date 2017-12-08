package com.yonyou.cloud.ops.mq.dto;

import java.util.List;

import com.yonyou.cloud.ops.mq.entity.MqConsumeDetailInfo;

public class MqConsumerDto {
	
	private String host;
	
	private String msgKey;
	
	private String msg;
	
	private String data;
	
	private String success;
	
	private Long occurTime;	
	
	private String queueName;
	
	private String appName;
	
	private String consumerId;
	
	private Integer failTimes;
	
	private Long successTime;
	
	private List<MqConsumeDetailInfo> consumeDetailInfos;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getMsgKey() {
		return msgKey;
	}

	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public Long getOccurTime() {
		return occurTime;
	}

	public void setOccurTime(Long occurTime) {
		this.occurTime = occurTime;
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}

	public Integer getFailTimes() {
		return failTimes;
	}

	public void setFailTimes(Integer failTimes) {
		this.failTimes = failTimes;
	}

	public Long getSuccessTime() {
		return successTime;
	}

	public void setSuccessTime(Long successTime) {
		this.successTime = successTime;
	}

	public List<MqConsumeDetailInfo> getConsumeDetailInfos() {
		return consumeDetailInfos;
	}

	public void setConsumeDetailInfos(List<MqConsumeDetailInfo> consumeDetailInfos) {
		this.consumeDetailInfos = consumeDetailInfos;
	}

}
