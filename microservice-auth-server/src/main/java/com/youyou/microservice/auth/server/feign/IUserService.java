package com.youyou.microservice.auth.server.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yonyou.microservice.gate.common.vo.authority.PermissionInfo;
import com.yonyou.microservice.gate.common.vo.user.UserInfo;
import com.youyou.microservice.auth.server.configuration.FeignConfiguration;


/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-06-21 8:11
 */
@FeignClient(value = "ace-admin",configuration = FeignConfiguration.class)
public interface IUserService {
  @RequestMapping(value = "/api/user/username/{username}", method = RequestMethod.GET)
  public UserInfo getUserByUsername(@PathVariable("username") String username);
  @RequestMapping(value = "/api/user/un/{username}/permissions", method = RequestMethod.GET)
  public List<PermissionInfo> getPermissionByUsername(@PathVariable("username") String username);
  @RequestMapping(value = "/api/permissions", method = RequestMethod.GET)
  List<PermissionInfo> getAllPermissionInfo();
}
