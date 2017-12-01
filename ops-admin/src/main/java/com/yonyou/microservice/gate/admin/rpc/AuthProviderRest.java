package com.yonyou.microservice.gate.admin.rpc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yonyou.microservice.gate.admin.entity.AuthProvider;
import com.yonyou.microservice.gate.admin.rpc.service.AuthProviderService;
import com.yonyou.microservice.gate.common.vo.user.AuthProviderInfo;

/**
 * ${DESCRIPTION}
 *
 * @author joy
 * @create 2017-06-21 8:15
 */
@RestController
@RequestMapping("api")
public class AuthProviderRest {
    @Autowired
    private AuthProviderService authProviderService;

    @RequestMapping(value = "/authProvider/all",method = RequestMethod.GET, produces="application/json")
    public  @ResponseBody List<AuthProviderInfo> getAuthProviders() {
    	
        return authProviderService.getAuthProviders();
    }

}
