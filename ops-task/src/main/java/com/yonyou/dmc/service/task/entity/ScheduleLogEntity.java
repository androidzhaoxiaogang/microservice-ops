package com.yonyou.dmc.service.task.entity;

import java.util.Date;

public class ScheduleLogEntity {
	public Long lonId;
	public String schedledNam;
	public Integer returnFlag;
	public String urlName;
	public Date createDate;
	public Integer createBy;
	public String responseInfo;
	public String workTime;
	
	public Long getLonId() {
		return lonId;
	}
	public void setLonId(Long lonId) {
		this.lonId = lonId;
	}
	public String getSchedledNam() {
		return schedledNam;
	}
	public void setSchedledNam(String schedledNam) {
		this.schedledNam = schedledNam;
	}
	
	public Integer getReturnFlag() {
		return returnFlag;
	}
	public void setReturnFlag(Integer returnFlag) {
		this.returnFlag = returnFlag;
	}
	public String getUrlName() {
		return urlName;
	}
	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Integer getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	public String getResponseInfo() {
		return responseInfo;
	}
	public void setResponseInfo(String responseInfo) {
		this.responseInfo = responseInfo;
	}
	public String getWorkTime() {
		return workTime;
	}
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	
	
	
}
