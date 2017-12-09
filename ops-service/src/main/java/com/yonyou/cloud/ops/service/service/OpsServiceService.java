package com.yonyou.cloud.ops.service.service;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yonyou.cloud.common.beans.PageResultResponse;
import com.yonyou.cloud.common.service.BaseService;
import com.yonyou.cloud.common.service.utils.PageQuery;
import com.yonyou.cloud.ops.service.entity.EurekaApplications;
import com.yonyou.cloud.ops.service.entity.InstanceInfo;

import tk.mybatis.mapper.common.Mapper;

@Service
public class OpsServiceService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EurekaApi eurekaApi;

	public EurekaApplications getAll() {
		EurekaApplications applications = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			applications = mapper.readValue(eurekaApi.getAll(), EurekaApplications.class);
		} catch (JsonParseException e) {
			logger.warn("get eureka instanceList faild", e);
		} catch (JsonMappingException e) {
			logger.warn("get eureka instanceList faild", e);
		} catch (IOException e) {
			logger.warn("get eureka instanceList faild", e);
		}

		return applications;
	}

}
