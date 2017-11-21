package com.yonyou.cloud.ops.mq.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.yonyou.cloud.common.service.EsBaseService;
import com.yonyou.cloud.ops.mq.common.MqOpsConstant;
import com.yonyou.cloud.ops.mq.entity.MqConsumeDetailInfo;
import com.yonyou.cloud.ops.mq.entity.MqConsumer;

@Service
public class MqConsumeDetailInfoService extends EsBaseService<MqConsumeDetailInfo>{
	
//	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public void save(MqConsumer mqConsumer) throws Exception{
		MqConsumeDetailInfo mqConsumeDetailInfo = new MqConsumeDetailInfo();
		BeanUtils.copyProperties(mqConsumer, mqConsumeDetailInfo);
//		List<MqConsumeDetailInfo> consumeDetails = selectList(MqOpsConstant.INDEX, "msgKey:" + mqConsumeDetailInfo.getMsgKey() + " AND success:true");
//		if(consumeDetails.isEmpty()){
//			insert(MqOpsConstant.INDEX, mqConsumeDetailInfo);
//		}else{
//			logger.error("this message status is success,msgkey:{}", mqConsumeDetailInfo.getMsgKey());
//		}
		insert(MqOpsConstant.INDEX, mqConsumeDetailInfo);
	}
}
