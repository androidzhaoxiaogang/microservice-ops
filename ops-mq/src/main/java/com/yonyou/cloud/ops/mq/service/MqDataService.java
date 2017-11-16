package com.yonyou.cloud.ops.mq.service;

import org.springframework.stereotype.Service;

import com.yonyou.cloud.common.service.EsBaseService;
import com.yonyou.cloud.ops.mq.entity.Track;

@Service
public class MqDataService extends EsBaseService<Track>{

//	@Autowired
//	MqDataApi mqDataApi;
//	
//	public PageResultResponse<MqData> pageQuery(String querStr,String tableName,Integer pageNum,Integer pageSize,String orderBy,String orderType){
//		return  mqDataApi.pageQueryMqData(pageNum, pageSize, "demo_mq", tableName, querStr, orderBy, orderType);
//	}
//	
//	public List<MqData> queryList(String querStr,String tableName){
//		return  mqDataApi.getMqDataList("demo_mq", tableName, querStr);
//	}
	
}
