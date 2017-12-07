package com.yonyou.dmc.service.task.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dexcoder.commons.pager.Pager;
import com.dexcoder.dal.JdbcDao;
import com.dexcoder.dal.spring.page.PageControl;
import com.xiaoleilu.hutool.util.StrUtil;
import com.yonyou.dmc.service.task.entity.ExecuteType;
import com.yonyou.dmc.service.task.entity.ScheduleEntity;
import com.yonyou.dmc.service.task.job.ScheduledJob;
import com.yonyou.dmc.service.task.job.ScheduledJobForMsg;

@Service
public class ScheduleJobService {
    @Autowired
    private Scheduler scheduler;

   // @Autowired
    //ScheduleDao scheduleDao;
    @Autowired
    JdbcDao jdbcDao;

    /**
     * 添加定时任务
     *
     * @param ScheduleJob
     * @throws ClassNotFoundException
     * @throws SchedulerException
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void add(ScheduleEntity scheduleEntity) throws ClassNotFoundException,
            SchedulerException {
    	JobDetail jobDetail;
    	if(scheduleEntity.getExecuteType().equals(ExecuteType.executeBean)){
         jobDetail = JobBuilder.newJob(ScheduledJob.class)
                .withIdentity(scheduleEntity.getJobName(), scheduleEntity.getJobGroup())
                .usingJobData("url", scheduleEntity.getBeanName())
                .usingJobData("jobGroup", scheduleEntity.getJobGroup())
                .usingJobData("jobName", scheduleEntity.getJobName())
                .build();
        
    	}else{
    	 jobDetail = JobBuilder.newJob(ScheduledJobForMsg.class)
                    .withIdentity(scheduleEntity.getJobName(), scheduleEntity.getJobGroup())
                    .usingJobData("url", scheduleEntity.getUrl())
                    .usingJobData("jobGroup", scheduleEntity.getJobGroup())
                    .usingJobData("jobName", scheduleEntity.getJobName())
                    .build();
    	}
        jobDetail.getJobDataMap().put("scheduleEntity", scheduleEntity);

        
        // 表达式调度构建器（可判断创建SimpleScheduleBuilder）


        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
                .cronSchedule(scheduleEntity.getCronExpression());

        // 按新的cronExpression表达式构建一个新的trigger


        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(scheduleEntity.getJobName(), scheduleEntity.getJobGroup())
                .withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    /**
     * 获取所有JobDetail
     *
     * @return 结果集合
     */
    public List<JobDetail> getJobs() {
        try {
            GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
            Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
            List<JobDetail> jobDetails = new ArrayList<JobDetail>();
            for (JobKey key : jobKeys) {
                jobDetails.add(scheduler.getJobDetail(key));
            }
            return jobDetails;
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取所有计划中的任务
     *
     * @return 结果集合
     */
    public List<ScheduleEntity> getAllScheduleJob() {
        List<ScheduleEntity> scheduleEntityList = new ArrayList<ScheduleEntity>();
        GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
        try {
            Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
            for (JobKey jobKey : jobKeys) {
                List<? extends Trigger> triggers = scheduler
                        .getTriggersOfJob(jobKey);
                for (Trigger trigger : triggers) {
                    ScheduleEntity scheduleEntity = new ScheduleEntity();
                    scheduleEntity.setJobName(jobKey.getName());
                    scheduleEntity.setJobGroup(jobKey.getGroup());
                    Trigger.TriggerState triggerState = scheduler
                            .getTriggerState(trigger.getKey());
                    scheduleEntity.setStatus(triggerState.name());
                    // 获取要执行的定时任务类名


                    JobDetail jobDetail = scheduler.getJobDetail(jobKey);
                    //获取class及method
                    JobDataMap dataMap = jobDetail.getJobDataMap();
                    //scheduleEntity.setClassName(dataMap.getString("className"));
                    //scheduleEntity.setMethodName(dataMap.getString("methodName"));
                    scheduleEntity.setUrl(dataMap.getString("url"));
                    //scheduleEntity.setClassName(jobDetail.getJobClass().getName());
                    // 判断trigger

                    if (trigger instanceof SimpleTrigger) {
                        SimpleTrigger simple = (SimpleTrigger) trigger;
                        scheduleEntity.setCronExpression("重复次数:"
                                + (simple.getRepeatCount() == -1 ? "无限"
                                : simple.getRepeatCount()) + ",重复间隔:"
                                + (simple.getRepeatInterval() / 1000L));
                        scheduleEntity.setDescription(simple.getDescription());
                    }
                    if (trigger instanceof CronTrigger) {
                        CronTrigger cron = (CronTrigger) trigger;
                        scheduleEntity.setCronExpression(cron.getCronExpression());
                        scheduleEntity
                                .setDescription(cron.getDescription() == null ? ("触发器:" + trigger
                                        .getKey()) : cron.getDescription());
                    }
                    scheduleEntityList.add(scheduleEntity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduleEntityList;
    }

    /**
     * 获取所有运行中的任务
     *
     * @return 结果集合
     */
    public List<ScheduleEntity> getAllRuningScheduleJob() {
        List<ScheduleEntity> scheduleEntityList = null;
        try {
            List<JobExecutionContext> executingJobs = scheduler
                    .getCurrentlyExecutingJobs();
            scheduleEntityList = new ArrayList<ScheduleEntity>(executingJobs.size());
            for (JobExecutionContext executingJob : executingJobs) {
                ScheduleEntity scheduleEntity = new ScheduleEntity();
                JobDetail jobDetail = executingJob.getJobDetail();
                JobKey jobKey = jobDetail.getKey();
                Trigger trigger = executingJob.getTrigger();
                scheduleEntity.setJobName(jobKey.getName());
                scheduleEntity.setJobGroup(jobKey.getGroup());
                // scheduleEntity.setDescription("触发器:" + trigger.getKey());


                Trigger.TriggerState triggerState = scheduler
                        .getTriggerState(trigger.getKey());
                scheduleEntity.setStatus(triggerState.name());
                // 获取要执行的定时任务类名


                //scheduleEntity.setClassName(jobDetail.getJobClass().getName());
                scheduleEntity.setUrl(jobDetail.getJobClass().getName());
                // 判断trigger


                if (trigger instanceof SimpleTrigger) {
                    SimpleTrigger simple = (SimpleTrigger) trigger;
                    scheduleEntity.setCronExpression("重复次数:"
                            + (simple.getRepeatCount() == -1 ? "无限" : simple
                            .getRepeatCount()) + ",重复间隔:"
                            + (simple.getRepeatInterval() / 1000L));
                    scheduleEntity.setDescription(simple.getDescription());
                }
                if (trigger instanceof CronTrigger) {
                    CronTrigger cron = (CronTrigger) trigger;
                    scheduleEntity.setCronExpression(cron.getCronExpression());
                    scheduleEntity.setDescription(cron.getDescription());
                }
                scheduleEntityList.add(scheduleEntity);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return scheduleEntityList;
    }

    /**
     * 获取所有的触发器
     *
     * @return 结果集合
     */
    public List<ScheduleEntity> getTriggersInfo() {
        try {
            GroupMatcher<TriggerKey> matcher = GroupMatcher.anyTriggerGroup();
            Set<TriggerKey> Keys = scheduler.getTriggerKeys(matcher);
            List<ScheduleEntity> triggers = new ArrayList<ScheduleEntity>();

            for (TriggerKey key : Keys) {
                Trigger trigger = scheduler.getTrigger(key);
                ScheduleEntity scheduleEntity = new ScheduleEntity();
                scheduleEntity.setJobName(trigger.getJobKey().getName());
                scheduleEntity.setJobGroup(trigger.getJobKey().getGroup());
                scheduleEntity.setStatus(scheduler.getTriggerState(key) + "");
                if (trigger instanceof SimpleTrigger) {
                    SimpleTrigger simple = (SimpleTrigger) trigger;
                    scheduleEntity.setCronExpression("重复次数:"
                            + (simple.getRepeatCount() == -1 ? "无限" : simple
                            .getRepeatCount()) + ",重复间隔:"
                            + (simple.getRepeatInterval() / 1000L));
                    scheduleEntity.setDescription(simple.getDescription());
                }
                if (trigger instanceof CronTrigger) {
                    CronTrigger cron = (CronTrigger) trigger;
                    scheduleEntity.setCronExpression(cron.getCronExpression());
                    scheduleEntity.setDescription(cron.getDescription());
                }
                triggers.add(scheduleEntity);
            }
            return triggers;
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 暂停任务
     *
     * @param name  任务名
     * @param group 任务组
     * @throws SchedulerException
     */
    public void stopJob(String name, String group) throws SchedulerException {
        JobKey key = new JobKey(name, group);
        scheduler.pauseJob(key);
    }

    /**
     * 恢复任务
     *
     * @param name  任务名
     * @param group 任务组
     * @throws SchedulerException
     */
    public void restartJob(String name, String group) throws SchedulerException {
        JobKey key = new JobKey(name, group);
        scheduler.resumeJob(key);
    }

    /**
     * 立马执行一次任务
     *
     * @param name  任务名
     * @param group 任务组
     * @throws SchedulerException
     */
    public void startNowJob(String name, String group) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(name, group);
        scheduler.triggerJob(jobKey);
    }

    /**
     * 删除任务
     *
     * @param name  任务名
     * @param group 任务组
     * @throws SchedulerException
     */
    public void delJob(String name, String group) throws SchedulerException {
        JobKey key = new JobKey(name, group);
        scheduler.deleteJob(key);
    }

    /**
     * 修改触发器时间
     *
     * @param name  任务名
     * @param group 任务组
     * @param cron  cron表达式
     * @throws SchedulerException
     */
    public void modifyTrigger(String name, String group, String cron) throws SchedulerException {
        TriggerKey key = TriggerKey.triggerKey(name, group);
        // Trigger trigger = scheduler.getTrigger(key);


        CronTrigger newTrigger = (CronTrigger) TriggerBuilder.newTrigger()
                .withIdentity(key)
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .build();
        scheduler.rescheduleJob(key, newTrigger);
    }

    /**
     * 暂停调度器
     *
     * @throws SchedulerException
     */
    public void stopScheduler() throws SchedulerException {
        if (!scheduler.isInStandbyMode()) {
            scheduler.standby();
        }
    }
    
    /**
     * 获取logs
     * 
     * @return
     * @throws Exception
     */
    public Pager getAllLogs(int currindex,int size,String qry) throws Exception {
      PageControl.performPage(currindex, size);
      if(!(qry==null||"".equals(qry))){
    	  String param="%"+qry+"%";
    	  jdbcDao.queryListForSql("select t.* from TS_DATA_COLLECT_LOG t where t.action_class_name like ? order  by dlog_id desc",new Object[]{param});
      }else{
    	  jdbcDao.queryListForSql("select t.* from TS_DATA_COLLECT_LOG t order  by dlog_id desc");
      }
     
      return PageControl.getPager();
    	
    }
    
    /**
     * 获取logs
     * 
     * @return
     * @throws Exception
     */
    public Pager getAllTaskLogs(int currindex,int size,Map queryMap) throws Exception {
     
      List qList = new LinkedList<Object>();
      StringBuilder s = new StringBuilder("select * from TS_SCHEDLED_LOG where 1=1\n");
      
      if(!StrUtil.isBlank((String)queryMap.get("taskName"))){
    	  s.append(" and SCHEDLED_NAME like ? \n");
    	  qList.add("%"+queryMap.get("taskName")+"%");
      }
      s.append("order by id desc");
      
      
      PageControl.performPage(currindex, size);
      jdbcDao.queryListForSql(s.toString(),qList.toArray());
      return PageControl.getPager();
    	
    }
    
    
//    /**
//     * 根据logId 获取log详情
//     * 
//     * @return
//     * @throws Exception
//     */
//    public Map<String,Object> getApiLogInfoById(String logId) throws Exception{
//    	return jdbcDao.querySingleResultForSql("select * from TS_DATA_COLLECT_LOG where dlog_id =?",new Object[]{logId});
//    }
//    
//    @Value("${ftpUsername:appadmin}")
//    private String ftpUsername;
//    @Value("${ftpPassword:admin}")
//    private String ftpPassword;
//    
//    public String getApiLogtextById(String LogId) throws Exception{
//    	Map<String,Object> logDetail = getApiLogInfoById(LogId);
//    	SFtpUtil sf = new SFtpUtil();
//    	String host = (String)logDetail.get("PC_IP");
//		String fileInput = (String)logDetail.get("INPUT_FILE");
//		String fileOutput = (String)logDetail.get("OUTPUT_FILE");
//		//201608242-4884.log
//		ChannelSftp sftp = sf.connect(host, 22, ftpUsername, ftpPassword);
//		
//		String input = "<h1>input=</h1>"+sf.readFile(fileInput, sftp).replace(";", "<br/>") +"<br/>";
//		String output= "<h1>output=</h1>"+sf.readFile(fileOutput, sftp).replace(";", "<br/>");
//		sftp.disconnect();
//		
//    	return input+output;
//    	
//    }
}
