package com.yonyou.dmc.service.task.entity;

import java.io.Serializable;

/**
 * 定时任务实体
 * 
 * @author yang
 */
public class ScheduleEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String jobName; // 任务名

	private String jobGroup; // 任务组

	private String cronExpression; // cron表达式

	private String status; // 状态

	private String description; // 描述

	private String url;// 执行的接口url
	
	private ExecuteType executeType;//任务类型
	
	private String beanName;//执行类的名称

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ScheduleEntity() {
		super();
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public ExecuteType getExecuteType() {
		return executeType;
	}

	public void setExecuteType(ExecuteType executeType) {
		this.executeType = executeType;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	@Override
	public String toString() {
		return "ScheduleEntity [jobName=" + jobName + ", jobGroup=" + jobGroup + ", cronExpression=" + cronExpression
				+ ", status=" + status + ", description=" + description + ", url=" + url +", executeType=" +executeType+", beanName= " +beanName+"]";
	}
}