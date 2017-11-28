package com.yonyou.microservice.gate.common.msg.auth;

import com.yonyou.cloud.common.beans.ResultBean;
import com.yonyou.microservice.gate.common.constant.RestCodeConstants;

/**
 * Created by ace on 2017/8/25.
 */
public class TokenForbiddenResponse  extends ResultBean {
    public TokenForbiddenResponse(String message) {
        super(RestCodeConstants.TOKEN_FORBIDDEN_CODE, message);
    }
}
