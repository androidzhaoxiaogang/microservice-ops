package com.yonyou.dmc.service.task.entity;

public class JobMsg {
	
	private String msgId;
	
	private String jobBean;
	
	private Long sendTime;
	
	private Long finishTime;
	
	private String status;
	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getJobBean() {
		return jobBean;
	}

	public void setJobBean(String jobBean) {
		this.jobBean = jobBean;
	}

	public Long getSendTime() {
		return sendTime;
	}

	public void setSendTime(Long sendTime) {
		this.sendTime = sendTime;
	}

	public Long getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Long finishTime) {
		this.finishTime = finishTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
 
	@Override
	public String toString() {
		return "JobMsg [msgId=" + msgId + ", jobBean=" + jobBean + ", sendTime=" + sendTime + ", finishTime="
				+ finishTime + ", status=" + status + "]";
	}
	
	

}
