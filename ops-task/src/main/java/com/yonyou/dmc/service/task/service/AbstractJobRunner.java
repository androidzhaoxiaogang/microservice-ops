package com.yonyou.dmc.service.task.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yonyou.dmc.service.task.entity.JobMsg;

public abstract class AbstractJobRunner {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public void jobRun(JobMsg job) {
		logger.info("接收到消息，调用业务执行的方法 "+job.getJobBean());
		try {
			this.execute(job);
		} catch (Exception e) {
			logger.error("任务执行失败",e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info("任务执行完毕");
	}
	
	public abstract void execute(JobMsg job) throws Exception;

}
