package com.yonyou.microservice.gate.admin.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yonyou.microservice.gate.admin.biz.FilterBiz;
import com.yonyou.microservice.gate.admin.entity.Filter;
import com.yonyou.microservice.gate.common.rest.BaseController;

@RestController
@RequestMapping("filters")
public class FilterController extends BaseController<FilterBiz,Filter> {

}
