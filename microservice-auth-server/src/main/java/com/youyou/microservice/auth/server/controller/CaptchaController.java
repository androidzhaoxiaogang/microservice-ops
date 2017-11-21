package com.youyou.microservice.auth.server.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.youyou.microservice.auth.server.service.AuthService;
import com.youyou.microservice.auth.server.util.user.JwtAuthenticationRequest;
import com.youyou.microservice.auth.server.util.user.JwtAuthenticationResponse;


@RestController
@RequestMapping("captcha")
public class CaptchaController {
	private static Logger logger=Logger.getLogger(CaptchaController.class);

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "jwt/token", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest) throws Exception {
    	logger.info("--CaptchaController,data="+JSONObject.toJSONString(authenticationRequest));

    	if("".equals(authenticationRequest.getCaptcha())){
    		return ResponseEntity.ok("password can't be null");
    	}
        final String token = authService.loginPhone(authenticationRequest.getUsername(), authenticationRequest.getCaptcha());
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

}
