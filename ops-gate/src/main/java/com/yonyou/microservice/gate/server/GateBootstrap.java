package com.yonyou.microservice.gate.server;


import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.Controller;

import com.yonyou.cloud.zuul.db.api.EnableZuulProxyStore;
import com.yonyou.microservice.auth.client.EnableAceAuthClient;
import com.yonyou.microservice.filter.annotation.EnableGroovyFilter;
import com.yonyou.microservice.gate.ratelimit.EnableAceGateRateLimit;
import com.yonyou.microservice.gate.ratelimit.config.IUserPrincipal;
import com.yonyou.microservice.gate.ratelimit.config.properties.RateLimitProperties;
import com.yonyou.microservice.gate.server.config.UserPrincipal;
import com.yonyou.microservice.gate.server.utils.DBLog;

/**
 * Created by Ace on 2017/6/2.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients({"com.yonyou.microservice.auth.client.feign","com.yonyou.microservice.gate.server.feign"})
@EnableZuulProxyStore
@ComponentScan(basePackages = {"com.yonyou.cloud.zuul.db","com.yonyou.microservice.gate.server"})
@EnableScheduling
@EnableAceAuthClient
@EnableAceGateRateLimit
@RestController
@EnableGroovyFilter
public class GateBootstrap {
	@Autowired
	private RateLimitProperties p;

    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
    	return "ok";
    }
    public static void main(String[] args) throws ParseException {
//    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//    	Date date1=df.parse("2017-11-27 15:35:28");
//    	Date date2=df.parse("2017-11-27 15:35:29");
//    	long l1=date1.getTime();
//    	long l2=date2.getTime();
//    	if(l1<l2){
//    		System.out.println("--------");
//    	}
//    	RequestMappingInfo info=new RequestMappingInfo(null,null);
//    	info.equals(GateBootstrap.class);
        DBLog.getInstance().start();
        SpringApplication.run(GateBootstrap.class, args);
    }

    @Bean
    @Primary
    IUserPrincipal userPrincipal(){
        return new UserPrincipal();
    }
}
 class TestController implements Controller{//implements Controller

	@Override
	public ModelAndView handleRequest(HttpServletRequest p0, HttpServletResponse p1) throws Exception {
		System.out.println("--x");
		Map<String, String> map=new HashMap();
		map.put("ab", "value");
		
		p1.getOutputStream().write(map.toString().getBytes());
		return null;
	}
	
}
