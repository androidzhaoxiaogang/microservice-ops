package com.yonyou.dmc.service.task.job;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dexcoder.dal.JdbcDao;
import com.yonyou.dmc.service.task.common.CommonConstants;
import com.yonyou.dmc.service.task.msg.TaskJobSender;
import com.yonyou.dmc.service.task.utils.SpringUtil;


/**
 * 执行调度
 * 
 * @author BENJAMIN
 *
 */
public class ScheduledJobForMsg implements Job {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledJobForMsg.class);
    

    public ScheduledJobForMsg() {
    }
    
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    	long statrTime=System.currentTimeMillis();
    	JdbcDao jdbcDao=(JdbcDao) SpringUtil.getBean("jdbcDao");
    	TaskJobSender jobSender=(TaskJobSender) SpringUtil.getBean("taskJobSender");
    	 String out="";
    	 int returnFlag=0;  
    	 JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
    	 try {  
    		 logger.info("开始执行:"+dataMap.getString("url"));
    		 //out=HttpUtil.get(dataMap.getString("url"));
    		 jobSender.sendMessage(dataMap.getString("url"));
    		 returnFlag=1;
		} catch (Exception e) {
			logger.error("计划调用失败:",e);
		}
        long endTime=System.currentTimeMillis();
        String workTime=String.valueOf(endTime-statrTime);
        
        String localAddr="";
        try {
//        	if(!"".equals(out)){
//        		JSONObject ob=JSONUtil.parseObj(out);
//            	String resultCode=ob.getStr("result");
//            	if("OK".equals(resultCode))
//            		returnFlag=1;
//            }
        	localAddr=InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			logger.warn("IP获取失败:",e);
		}
        
		jdbcDao.updateForSql("INSERT INTO TS_SCHEDLED_LOG \n"
				+ "(JOB_GROUP ,\n"
				+ "SCHEDLED_NAME ,\n"
				+ "RETURN_FLAG ,\n"
				+ "URL_NAME,\n" 
				+ "CREATE_DATE,\n"
				+ "CREATE_BY ,\n"
				+ "RESPONSE_INFO,\n"
				+ "PC_IP,\n"
				+ "WORK_TIME \n"
				+ ") values (?,?,?,?,?,?,?,?,?)", 
				new Object[]{
						dataMap.getString("jobGroup"),
						dataMap.getString("jobName"),
						returnFlag,
						dataMap.get("url"),
					new Date(),
					CommonConstants.SERVICE_USER,
					out,
					localAddr,
					workTime
				});
		
    }
}
