package com.yonyou.microservice.wechat.dto.pictxt;

import java.util.ArrayList;
import java.util.List;

public class PicTxtSendDto {
	private List<Long> objectIds=new ArrayList();
	private List<String> openIds=new ArrayList();
	public List<Long> getObjectIds() {
		return objectIds;
	}
	public void setObjectIds(List<Long> objectIds) {
		this.objectIds = objectIds;
	}
	public List<String> getOpenIds() {
		return openIds;
	}
	public void setOpenIds(List<String> openIds) {
		this.openIds = openIds;
	}
	
}
