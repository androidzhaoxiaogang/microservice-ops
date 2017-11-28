package com.yonyou.microservice.gate.admin.rpc;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yonyou.microservice.auth.client.annotation.IgnoreUserToken;
import com.yonyou.microservice.gate.admin.biz.GateLogBiz;
import com.yonyou.microservice.gate.admin.entity.GateLog;
import com.yonyou.microservice.gate.common.vo.log.LogInfo;

/**
 * ${DESCRIPTION}
 *
 * @author joy
 * @create 2017-07-01 14:39
 */
@RequestMapping("api")
@RestController
@IgnoreUserToken
public class LogRest {
	@Autowired
	private GateLogBiz gateLogBiz;

	@RequestMapping(value = "/log/save", method = RequestMethod.POST)
	public @ResponseBody void saveLog(@RequestBody LogInfo info) {
		GateLog log = new GateLog();
		BeanUtils.copyProperties(info, log);
		gateLogBiz.insertSelective(log);
	}
}
