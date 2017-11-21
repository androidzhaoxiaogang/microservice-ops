package com.yonyou.microservice.gate.common.msg.auth;

import com.yonyou.microservice.gate.common.constant.RestCodeConstants;
import com.yonyou.microservice.gate.common.msg.BaseResponse;

/**
 * Created by ace on 2017/8/23.
 */
public class TokenErrorResponse extends BaseResponse {
    public TokenErrorResponse(String message) {
        super(RestCodeConstants.TOKEN_ERROR_CODE, message);
    }
}
