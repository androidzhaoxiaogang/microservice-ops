package com.yonyou.cloud.ops.mq.dto;

import java.util.List;

import com.yonyou.cloud.ops.mq.entity.MqProducer;

public class MqMessageResponseDto {
	
	private String host;
	
	private String msgKey;
	
	private String msg;
	
	private String data;
	
	private String status;
	
	private String success;
	
	private Long occurTime;	
	
	private String exchangeName;
	
	private String routingKey;
	
	private String sender;
	
	private Integer consumeFailTimes;
	
	private Integer produceFailTimes;
	
	private Long produceSuccessTime;
	
	private Long consumeSuccessTime;
	
	private List<MqProducer> producers;
	
	private List<MqConsumerDto> consumers;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Integer getConsumeFailTimes() {
		return consumeFailTimes;
	}

	public void setConsumeFailTimes(Integer consumeFailTimes) {
		this.consumeFailTimes = consumeFailTimes;
	}

	public Integer getProduceFailTimes() {
		return produceFailTimes;
	}

	public void setProduceFailTimes(Integer produceFailTimes) {
		this.produceFailTimes = produceFailTimes;
	}

	public Long getProduceSuccessTime() {
		return produceSuccessTime;
	}

	public void setProduceSuccessTime(Long produceSuccessTime) {
		this.produceSuccessTime = produceSuccessTime;
	}

	public Long getConsumeSuccessTime() {
		return consumeSuccessTime;
	}

	public void setConsumeSuccessTime(Long consumeSuccessTime) {
		this.consumeSuccessTime = consumeSuccessTime;
	}

	public List<MqProducer> getProducers() {
		return producers;
	}

	public void setProducers(List<MqProducer> producers) {
		this.producers = producers;
	}

	public List<MqConsumerDto> getConsumers() {
		return consumers;
	}

	public void setConsumers(List<MqConsumerDto> consumers) {
		this.consumers = consumers;
	}

	public String getExchangeName() {
		return exchangeName;
	}

	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}

	public String getRoutingKey() {
		return routingKey;
	}

	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

}
