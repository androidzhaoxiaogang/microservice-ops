package com.yonyou.microservice.gate.common.msg.auth;

import com.yonyou.cloud.common.beans.ResultBean;
import com.yonyou.microservice.gate.common.constant.RestCodeConstants;

/**
 * Created by ace on 2017/8/23.
 */
public class TokenErrorResponse extends ResultBean {
    public TokenErrorResponse(String message) {
        super(RestCodeConstants.TOKEN_ERROR_CODE, message);
    }
}
