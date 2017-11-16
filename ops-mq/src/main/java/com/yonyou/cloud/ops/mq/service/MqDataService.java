package com.yonyou.cloud.ops.mq.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonyou.cloud.common.beans.PageResultResponse;
import com.yonyou.cloud.ops.mq.dao.MqDataApi;
import com.yonyou.cloud.ops.mq.entity.MqData;

@Service
public class MqDataService {

	@Autowired
	MqDataApi mqDataApi;
	
	public PageResultResponse<MqData> pageQuery(String querStr,String tableName,Integer pageNum,Integer pageSize,String orderBy,String orderType){
		return  mqDataApi.pageQueryMqData(pageNum, pageSize, "demo_mq", tableName, querStr, orderBy, orderType);
	}
	
	public List<MqData> queryList(String querStr,String tableName){
		return  mqDataApi.getMqDataList("demo_mq", tableName, querStr);
	}
	
}
