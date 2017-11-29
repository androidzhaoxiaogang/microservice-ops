package com.yonyou.microservice.wechat.dto;

import java.util.Map;

import com.yonyou.microservice.wechat.eventenum.EventConstant.EventBizStep;
import com.yonyou.microservice.wechat.eventenum.EventConstant.EventBizType;

/**
 * 业务事件定义
 * 
 * @author BENJAMIN
 *
 */
public class BizEvent {
	

	public BizEvent(String eventKey, EventBizType eventBizType, EventBizStep eventBizStep,
			Map<String, Object> eventData) {
		super();
		this.eventKey = eventKey;
		this.eventBizType = eventBizType;
		this.eventBizStep = eventBizStep;
		this.eventData = eventData;
	}
	
	public BizEvent() {
		super();
	}

	/**
	 * 事件唯一key
	 */
	private String eventKey;
	
	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public EventBizType getEventBizType() {
		return eventBizType;
	}

	public void setEventBizType(EventBizType eventBizType) {
		this.eventBizType = eventBizType;
	}

	public EventBizStep getEventBizStep() {
		return eventBizStep;
	}

	public void setEventBizStep(EventBizStep eventBizStep) {
		this.eventBizStep = eventBizStep;
	}

	/**
	 * 业务场景
	 */
	private EventBizType eventBizType;
	
	/**
	 * 业务节点
	 */
	private EventBizStep eventBizStep;
	
	
	/**
	 * 业务数据，用于基础服务进行后续业务
	 */
	private Map<String, Object> eventData;

	public Map<String, Object> getEventData() {
		return eventData;
	}

	public void setEventData(Map<String, Object> eventData) {
		this.eventData = eventData;
	}



	
}
