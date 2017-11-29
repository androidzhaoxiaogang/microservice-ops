package com.yonyou.microservice.gate.common.exception;

import com.yonyou.cloud.common.exception.BizException;

public class GateException extends BizException{

	/**
	 * 客户被禁止
	 */
	public static final BizException CLIENT_FORBIDDEN_EXCEPTION = new BizException(90090001, "Client is Forbidden!");

	/**
	 * 微服务不存在，或secret为空
	 */
	public static final BizException CLIENT_INVALID_EXCEPTION = new BizException(90090002, "Client not found or Client secret is error!");

	/**
	 * token错误
	 */
	public static final BizException TOKEN_ERROR_EXCEPTION = new BizException(90090003, "token is error");

	/**
	 * 用户无效
	 */
	public static final BizException USER_INVALID_EXCEPTION = new BizException(90090004, "user is invalid");
}
