package com.yonyou.microservice.gate.common.exception.auth;


import com.yonyou.microservice.gate.common.constant.CommonConstants;
import com.yonyou.microservice.gate.common.exception.BaseException;

/**
 * Created by ace on 2017/9/10.
 */
public class UserInvalidException extends BaseException {
    public UserInvalidException(String message) {
        super(message, CommonConstants.EX_USER_INVALID_CODE);
    }
}
