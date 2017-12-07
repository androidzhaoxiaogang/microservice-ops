package com.yonyou.dmc.service.task.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.quartz.CronExpression;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dexcoder.commons.pager.Pager;
import com.yonyou.dmc.service.task.entity.ScheduleEntity;
import com.yonyou.dmc.service.task.service.ScheduleJobService;

@Controller
@RequestMapping("/task")
public class ScheduleJobController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private ScheduleJobService scheduleJobService;

    /**
     * 任务列表
     *
     * @return
     */

    @RequestMapping("/index")
    public String list() {
    	logger.info("----------------task,index");
        return "/task/static/html/index.html";
    }
    
    
    @RequestMapping("/apilogs")
    public String logs() {
        return "/task/static/html/apilog.html";
    }
    
    @RequestMapping("/tasklogs")
    public String tasklogs() {
        return "/task/static/html/tasklog.html";
    }
    
    @ResponseBody
    @RequestMapping("apilogs.json")
    public Map<String, Object> getApiLogs(Integer page,Integer pageSize,String qry) throws Exception{
        Pager logpage = scheduleJobService.getAllLogs(page==null?1:page,pageSize==null?10:pageSize,qry);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", logpage);
        map.put("pages", logpage.getPages());
        return map;
    }
    
    @ResponseBody
    @RequestMapping("tasklogs.json")
    public Map<String, Object> tasklogs(Integer page,Integer pageSize,String taskName) throws Exception{
    	Map<String, Object> querymap = new HashMap<String, Object>();
    	querymap.put("taskName", taskName);
        Pager logpage = scheduleJobService.getAllTaskLogs(page==null?1:page,pageSize==null?10:pageSize,querymap);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", logpage);
        map.put("pages", logpage.getPages());
        return map;
    }

    @ResponseBody
    @RequestMapping("list.json")
    public Map<String, Object> getAllJobs(){
        List<ScheduleEntity> scheduleEntities = scheduleJobService.getAllScheduleJob();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", scheduleEntities);
    	logger.info("----------------task,list.json,"+scheduleEntities.size());
        return map;
    }
    @RequestMapping("add")
    public String add() {
        return "/task/static/html/add.html";
    }

    @RequestMapping(value="/save.json")
    @ResponseBody
    public Object create( ScheduleEntity scheduleEntity) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", -1);
        // 判断表达式
        boolean f = CronExpression.isValidExpression(scheduleEntity
                .getCronExpression());
        if (!f) {
            map.put("msg", "cron表达式有误，不能被解析！");
            return map;
        }
        try {
        	logger.info("scheduleEn====="+scheduleEntity.toString());
            scheduleEntity.setStatus("1");
            scheduleJobService.add(scheduleEntity);
            map.put("status", 0);
            map.put("msg","保存成功!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            map.put("msg", "找不到指定的类");
        } catch (SchedulerException e) {
            e.printStackTrace();
            if (e.getMessage().contains(
                    "because one already exists with this identification")) {
                map.put("msg", "任务组中存在同样的任务名");
            } else {
                map.put("msg", "未知原因,添加任务失败");
            }
        } catch (Exception e) {
            map.put("msg", "系统错误!");
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 暂停任务
     */

    @ResponseBody
    @RequestMapping("/stopJob")
    public Object stop(String jobName, String jobGroup) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", -1);
        try {
            scheduleJobService.stopJob(jobName, jobGroup);
            map.put("status", 0);
            map.put("msg","暂停成功!");
        } catch (SchedulerException e) {
            e.printStackTrace();
            map.put("msg", "系统错误,请联系管理员!");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(String jobName, String jobGroup) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", -1);
        try {
            scheduleJobService.delJob(jobName, jobGroup);
            map.put("status", 0);
            map.put("msg","删除成功!");
        } catch (SchedulerException e) {
            e.printStackTrace();
            map.put("msg", "系统错误,请联系管理员!");
        }
        return map;
    }

    /**
     * 修改表达式
     */

    @ResponseBody
    @RequestMapping("/update")
    public Object update(ScheduleEntity scheduleEntity) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", -1);
        // 验证cron表达式


        boolean f = CronExpression.isValidExpression(scheduleEntity
                .getCronExpression());
        if (!f) {
            map.put("msg", "cron表达式有误，不能被解析！");
            return map;
        }
        try {
            scheduleJobService.modifyTrigger(scheduleEntity.getJobName(),
                    scheduleEntity.getJobGroup(), scheduleEntity.getCronExpression());
            map.put("status", 0);
        } catch (SchedulerException e) {
            e.printStackTrace();
            map.put("msg", "系统错误,请联系管理员!");
        }
        return map;
    }

    /**
     * 立即运行一次
     */

    @ResponseBody
    @RequestMapping("/startNow")
    public Object stratNow(String jobName, String jobGroup) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", -1);
        try {
            scheduleJobService.startNowJob(jobName, jobGroup);
            map.put("status", 0);
        } catch (SchedulerException e) {
            e.printStackTrace();
            map.put("msg", "系统错误,请联系管理员!");
        }
        return map;
    }

    /**
     * 恢复
     */

    @ResponseBody
    @RequestMapping("/resume")
    public Object resume(String jobName, String jobGroup) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", -1);
        try {
            scheduleJobService.restartJob(jobName, jobGroup);
            map.put("status", 0);
            map.put("msg","恢复成功!");
        } catch (SchedulerException e) {
            e.printStackTrace();
            map.put("msg", "系统错误,请联系管理员!");
        }
        return map;
    }
    
    
    @RequestMapping("/call")
    @ResponseBody
    public Object call()  {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", "OK");
        return map;
    }

    /**
     * 获取所有trigger
     */
    public void getTriggers(HttpServletRequest request) {
        List<ScheduleEntity> scheduleEntities = scheduleJobService.getTriggersInfo();
        request.setAttribute("triggers", scheduleEntities);
    }
    
    
    
//    @ResponseBody
//    @RequestMapping("apilog/{logId}")
//    public String getLogDetail(@PathVariable(value="logId")String logId) throws Exception{
//        return scheduleJobService.getApiLogtextById(logId);
//    }

}
