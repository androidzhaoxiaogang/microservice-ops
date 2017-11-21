package com.yonyou.cloud.ops.mq.service;

import org.springframework.stereotype.Service;

import com.yonyou.cloud.common.service.EsBaseService;
import com.yonyou.cloud.ops.mq.common.MqOpsConstant;
import com.yonyou.cloud.ops.mq.entity.MqProducer;

@Service
public class MqProducerService extends EsBaseService<MqProducer>{
	
//	private Logger logger = LoggerFactory.getLogger(this.getClass());

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
	
	public void save (MqProducer producer) throws Exception{
//		List<MqProducer> producers = selectList(index, "msgKey:" + producer.getMsgKey() + " AND success:true");
//		if(producers.isEmpty()){
//			insert(index, producer);
//		}else{
//			logger.error("this message status is success,msgkey:{}", producer.getMsgKey());
//		}
		insert(MqOpsConstant.INDEX, producer);
	}
	
}
