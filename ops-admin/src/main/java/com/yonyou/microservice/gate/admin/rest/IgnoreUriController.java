package com.yonyou.microservice.gate.admin.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yonyou.cloud.common.controller.BaseController;
import com.yonyou.microservice.gate.admin.biz.IgnoreUriBiz;
import com.yonyou.microservice.gate.admin.entity.IgnoreUri;

/**
 * ${DESCRIPTION}
 *
 * @author joy
 * @create 2017-06-21 8:15
 */
@RestController
@RequestMapping("ignoreUri")
public class IgnoreUriController extends BaseController<IgnoreUriBiz, IgnoreUri> {

}
