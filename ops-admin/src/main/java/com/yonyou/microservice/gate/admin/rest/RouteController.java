package com.yonyou.microservice.gate.admin.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yonyou.microservice.gate.admin.biz.RouteBiz;
import com.yonyou.microservice.gate.admin.entity.Route;
import com.yonyou.microservice.gate.common.rest.BaseController;

@RestController
@RequestMapping("routes")
public class RouteController extends BaseController<RouteBiz,Route> {

}
