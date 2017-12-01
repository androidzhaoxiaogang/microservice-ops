package com.youyou.microservice.auth.server.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.xiaoleilu.hutool.json.JSONObject;
import com.yonyou.cloud.common.jwt.JWTInfo;
import com.yonyou.cloud.common.vo.user.UserInfo;
import com.yonyou.microservice.gate.common.vo.user.AuthProviderInfo;
import com.youyou.microservice.auth.server.util.user.JwtTokenUtil;

public class DynController implements Controller{
	private static Logger logger=Logger.getLogger(DynController.class);
	public static final String ACCEPT_USER="user";
	public static final String ACCEPT_USER_PASSWORD="userAndPassword";
	private List<AuthProviderInfo> providers;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private RestTemplate restTemplate;

	private AuthProviderInfo getService(String name){
		for(AuthProviderInfo i:providers){
			if(name.contains(i.getSrcUrl())){
				return i;
			}
		}
		return null;
	}
	private String getBody(HttpServletRequest request) {

			BufferedReader br;
			String str, wholeStr = "";
			try {
				br = request.getReader();
				while((str = br.readLine()) != null){
				wholeStr += str;
				}
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
			return wholeStr;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest p0, HttpServletResponse p1) throws Exception {
		logger.info("--DynController.handleRequest");
		String uri=p0.getRequestURI();
		logger.info("--DynController,uri="+uri);
		AuthProviderInfo pInfo=this.getService(uri);
		if(pInfo!=null && !"".equals(pInfo.getAuthService())){
			logger.info("--DynController,service="+pInfo.getAuthService());
			String body=this.getBody(p0);
			JSONObject rBody=new JSONObject(body);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<String>(body, headers);
			ResponseEntity<UserInfo> r=restTemplate.exchange(pInfo.getAuthService(), HttpMethod.POST, entity, UserInfo.class);
			JSONObject sk=new JSONObject(r.getBody());
	        String token = "token=";
			if(pInfo.getAcceptType().equals(ACCEPT_USER)){
		        if (encoder.matches((String)rBody.get("password"), r.getBody().getPassword())) {
		            token = token+jwtTokenUtil.generateToken(new JWTInfo(r.getBody().getUsername(), r.getBody().getId() + "", r.getBody().getName()));
		        }
			}
			p1.getOutputStream().write(token.getBytes());
		}
		return null;
	}

	public List<AuthProviderInfo> getProviders() {
		return providers;
	}

	public void setProviders(List<AuthProviderInfo> providers) {
		this.providers = providers;
	}

}
