package com.yonyou.cloud.ops.service;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yonyou.cloud.ops.service.entity.EurekaApplications;
import com.yonyou.cloud.ops.service.service.EurekaApi;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpsServiceApplicationTests {
	
	@Autowired
	DiscoveryClient client;
	
	@Autowired
	EurekaApi eurekaApi;

	@Test
	public void contextLoads() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();  
		System.out.println(client.getServices());
		System.out.println(eurekaApi.getAll());
		EurekaApplications apps= mapper.readValue(eurekaApi.getAll(), EurekaApplications.class);
		System.out.println(apps);
	}

}
