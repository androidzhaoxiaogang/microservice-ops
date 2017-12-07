package com.yonyou.dmc.service.task.msg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.xiaoleilu.hutool.date.DateUtil;
import com.xiaoleilu.hutool.util.RandomUtil;
import com.yonyou.dmc.service.task.entity.JobMsg;

 

@Service
@EnableBinding(TaskJob.class)
public class TaskJobSender {  
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
  
    @Autowired  
    private TaskJob taskJob;  
  
    // 发送消息  
    public String sendMessage(String jobBean){  
    	logger.info("发送任务消息到队列中");
        try{  
        	JobMsg msg = new JobMsg();
        	String msgId = RandomUtil.randomUUID();
        	
        	msg.setMsgId(msgId);
        	//改造了url也可以存spring bean的name
        	msg.setJobBean(jobBean);
        	msg.setSendTime(DateUtil.current(false));
        	logger.info("JobMsg ==== "+msg);
        	taskJob.sendJob().send(MessageBuilder.withPayload(msg).build());  
        	logger.info("任务发送完毕");
        	return msgId;
        }catch (Exception e){  
            throw e ;
        }  
    }  
}  