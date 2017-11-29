package com.yonyou.microservice.wechat.dao;

import java.util.List;
import java.util.Map;

import com.yonyou.microservice.wechat.entity.TtWoMassSend;

import tk.mybatis.mapper.common.Mapper;

//@OracleDb
public interface TtWoMassSendMapper extends Mapper<TtWoMassSend> {
	//void updateMediaId(String navId,String mediaId);
	
	//读取未发送的去重的ObjectId
	List<TtWoMassSend> selectUnSendWithDistinctObjectId();
	
	//读取未发送的消息
	List<TtWoMassSend> selectUnSend();
	
	//根据objectId更新mediaId
	void updateMediaId(Map<String,String> map);
	
	//根据objectId更新picTextMediaId
	void updatePicTextMediaId(Map<String,String> map);
}