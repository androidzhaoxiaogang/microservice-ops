package com.yonyou.microservice.gate.admin.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yonyou.cloud.common.controller.BaseController;
import com.yonyou.microservice.gate.admin.biz.AuthProviderBiz;
import com.yonyou.microservice.gate.admin.entity.AuthProvider;

/**
 * ${DESCRIPTION}
 *
 * @author joy
 * @create 2017-06-21 8:15
 */
@RestController
@RequestMapping("authProvider")
public class AuthProviderController extends BaseController<AuthProviderBiz, AuthProvider> {

}
