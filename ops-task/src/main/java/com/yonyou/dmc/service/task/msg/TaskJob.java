package com.yonyou.dmc.service.task.msg;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface TaskJob {

	String REVEIVE = "reveive_job";
	String SEND = "send_job";
    
    @Output(TaskJob.SEND)
	MessageChannel sendJob();
    
    @Input(TaskJob.REVEIVE)
	SubscribableChannel receiveJob();
    
    

}