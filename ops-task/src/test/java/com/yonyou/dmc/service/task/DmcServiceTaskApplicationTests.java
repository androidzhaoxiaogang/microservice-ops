package com.yonyou.dmc.service.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yonyou.dmc.service.task.msg.TaskJobSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DmcServiceTaskApplicationTests {

	@Autowired
	TaskJobSender taskJobSender;
	
	
	@Test
	public void contextLoads() {
		
		taskJobSender.sendMessage("123");
	}

}
