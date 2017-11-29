package com.yonyou.microservice.wechat.util;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
*
* @author BENJAMIN
* 发送消息到MQ的共用方法
*/
@FeignClient(name="service-mqcenter")
public interface MqInterface {
    
    @RequestMapping(value="/message/exchange",method = RequestMethod.POST)
    public String sendEvent2MQ(
    		@RequestParam("channel") String channel,
    		@RequestParam("appid") String appid,
    		@RequestParam("sign") String sign,
    		@RequestParam("occurtime") String occurtime,
    		@RequestParam("nonce") String nonce,
    		@RequestBody String body) throws Exception;
  
}
