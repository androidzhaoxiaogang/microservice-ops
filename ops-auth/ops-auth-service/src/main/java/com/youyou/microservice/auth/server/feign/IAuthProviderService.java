package com.youyou.microservice.auth.server.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yonyou.microservice.gate.common.vo.user.AuthProviderInfo;
import com.youyou.microservice.auth.server.configuration.FeignConfiguration;

@FeignClient(value = "back-admin",configuration = {})
public interface IAuthProviderService {
  @RequestMapping(value = "/api/authProvider/all", method = RequestMethod.GET)
  public List<AuthProviderInfo> getAuthMapping();
}
