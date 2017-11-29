package com.yonyou.microservice.wechat.mq;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yonyou.cloud.mom.client.MqSender;
import com.yonyou.cloud.mom.core.dto.ProducerDto;
import com.yonyou.cloud.mom.core.store.StoreStatusEnum;
import com.yonyou.cloud.mom.core.store.callback.ProducerStoreDBCallback;
import com.yonyou.cloud.mom.core.store.callback.exception.StoreDBCallbackException;

@Service
@Transactional
public class MsgProducerCallBack implements ProducerStoreDBCallback {
	Logger log=LoggerFactory.getLogger(MsgProducerCallBack.class);
	
//	@Autowired
//	MsgDao msgDao;

	@Override
	public void saveMsgData(String msgKey, String data, String exchange, String routerKey,String bizClassName)
			throws StoreDBCallbackException {
//			MsgEntity msg = new MsgEntity();
//			msg.setMsgKey(msgKey);
//			msg.setExchange(exchange);
//			msg.setRouterKey(routerKey);
//			msg.setStatus(StoreStatusEnum.PRODUCER_INIT.getValue());
//			msg.setRetryCount(0);
//			msg.setCreateTime(new Date().getTime());
//			msg.setBizClassName(bizClassName);
//			msg.setMsgContent(data);
//			msgDao.save(msg);
	}
	
	
	@Override
	public void update2success(String msgKey) throws StoreDBCallbackException {
		
//			log.info("消息发送成功" + msgKey);
//			MsgEntity msg=msgDao.findOne(msgKey);
//			msg.setStatus(StoreStatusEnum.PRODUCER_SUCCESS.getValue());
//			msgDao.save(msg);
	}

	@Override
	public void update2faild(String msgKey, String infoMsg, Long costTime,String exchange, String routerKey,String data,String bizClassName) throws StoreDBCallbackException {
//		System.out.println("进入消息发送失败的逻辑" + msgKey);
//		MsgEntity msg = new MsgEntity();
//		msg.setMsgKey(msgKey);
//		msg.setStatus(StoreStatusEnum.PRODUCER_FAILD.getValue());
//		msg.setInfoMsg(infoMsg);
//		msg.setUpdateTime(new Date().getTime());
//		msg.setBizClassName(bizClassName);
//		msg.setExchange(exchange);
//		msg.setRouterKey(routerKey);
//		msg.setMsgContent(data);
//		msgDao.save(msg);
	}
	
  
	
	  @Override
	  public List<ProducerDto> selectResendList(Integer status){
//		  
//		  log.info("扫描需要重新发送的消息" + status);
//		  
//		  List<ProducerDto> producerdtolist=new ArrayList<>();
//		  List<MsgEntity> list= msgDao.findbystatus(status);
//		  for(MsgEntity msg:list) {
//			 ProducerDto dto= new ProducerDto();
//			 dto.setExchange(msg.getExchange());
//			 dto.setMsgKey(msg.getMsgKey());
//			 dto.setRouterKey(msg.getRouterKey());
//			 dto.setMsgContent(msg.getMsgContent());
//			 dto.setBizClassName(msg.getBizClassName());
//			 dto.setMsgContent(msg.getMsgContent());
//			  producerdtolist.add(dto);
//		  }
//		  return producerdtolist;
		  return null;
	  }

}
