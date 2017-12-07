package com.yonyou.dmc.service.task.entity;

/**
 * 执行类型
 */

 

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xiaoleilu.hutool.util.StrUtil;

/**
 * 
 * @author daniell
 *
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ExecuteType {

	executeUrl("http类型"),

	executeBean("消息类型"),

	UNKNOWN("未知");

	private String value;
	private String name;

	private ExecuteType(String name) {
		this.value = this.toString();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public static ExecuteType formatEnum(String key) {

		if (StrUtil.isBlank(key)) {
			return null;
		}
		try {
			return ExecuteType.valueOf(key);
		} catch (Exception e) {
			return UNKNOWN;
		}
	}
}
