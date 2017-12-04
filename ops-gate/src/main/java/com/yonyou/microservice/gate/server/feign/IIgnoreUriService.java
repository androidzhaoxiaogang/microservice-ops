package com.yonyou.microservice.gate.server.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yonyou.microservice.gate.common.vo.authority.IgnoreUriInfo;
import com.yonyou.microservice.gate.server.config.ZuulConfig;


/**
 * ${DESCRIPTION}
 *
 * @author joy
 * @create 2017-06-21 8:11
 */
@FeignClient(value = "back-admin",configuration = {ZuulConfig.class})
@RequestMapping("api")
public interface IIgnoreUriService {
  @RequestMapping(value = "/ignoreUri/all", method = RequestMethod.GET)
  List<IgnoreUriInfo> getIgnoreUris();

}
