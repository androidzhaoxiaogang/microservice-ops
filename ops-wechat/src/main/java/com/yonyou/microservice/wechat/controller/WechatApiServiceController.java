package com.yonyou.microservice.wechat.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yonyou.microservice.wechat.common.ApiVersionConsts;
import com.yonyou.microservice.wechat.service.TokenService;


@RestController
@RequestMapping(value = ApiVersionConsts.BASE_PATH+ApiVersionConsts.VERSION+"/wechatApiService" )
public class WechatApiServiceController {
	@Autowired
	private TokenService tokenService;
    @Autowired
    private RabbitTemplate rabbitTemplate;
//    @Autowired
//    private ListeningExecutorService executorService;
//    @Autowired
//    private BaseService mqInterface;
	
	@RequestMapping(value = "/getOpenid/{code}", method = RequestMethod.GET,consumes = "application/json;UTF-8")
	public String getOpenidByCode(@PathVariable("code") String code) {
		return tokenService.getOpenidByCode(code);
	}
	@RequestMapping(value = "/getToken", method = RequestMethod.GET,consumes = "application/json;UTF-8")
	public String getToken() {
		return tokenService.getAccessToken();
	}

	@RequestMapping(value = "/testsend", method = RequestMethod.GET)
	public void testsend() throws Exception {
//		EventPointsChangedDTO o=new EventPointsChangedDTO();
//		o.setAfterPoints(100l);
//		o.setBeforePoints(1000l);
//		o.setChangePoints(900l);
//		o.setUserId(1512);
//		o.setReason("buy car");
//		BizEvent event=new BizEvent();
//		event.setEventBizType(EventBizType.COMMON);
//		event.setEventBizStep(EventBizStep.COMMON_POINTS_CHANGED);
//		event.setEventKey("CD110000111");
//		event.setEventData(MapConverUtil.PO2Map(o));
//		PointChangeEventHandler test=new PointChangeEventHandler();
//		test.executorService=executorService;
//		test.handleing(event);
		//mqInterface.sendEvent2MQ("exchange2", "1", "1", "2017-03-03", "1", JSON.toJSON(event).toString());
		
//        WeChatMessageProtocol messageProtocol = getDemoWXTemplate();
//        this.rabbitTemplate.convertAndSend(MessagePushConstant.WECHAT_QUEUE, messageProtocol);
	}
	
}
