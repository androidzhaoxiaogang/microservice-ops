package com.yonyou.cloud.zuul.db.support;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.RoutesRefreshedEvent;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yonyou.cloud.zuul.db.route.StoreProxyRouteLocator;

@RestController
public class RefreshController {
	private Logger logger=Logger.getLogger(RefreshController.class);
	@Autowired
	ApplicationEventPublisher publisher;

	@Autowired
	RouteLocator routeLocator;
	@Autowired
	StoreProxyRouteLocator locator;

	@RequestMapping("/routes/refresh")
	public String refresh(){
//        RoutesRefreshedEvent routesRefreshedEvent = new RoutesRefreshedEvent(routeLocator);
//        publisher.publishEvent(routesRefreshedEvent);
		locator.forceRefresh();
		return "ok";
	}

}
