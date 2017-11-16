package com.yonyou.cloud.ops.mq.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.lucene.queryparser.flexible.core.builders.QueryBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.Page;
import com.yonyou.cloud.common.beans.PageResultResponse;
import com.yonyou.cloud.ops.mq.entity.MqData;

@Component
public class MqDataApi {

	@Autowired
	private TransportClient client;

	/**
	 * 分页查询
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param dbName
	 * @param tableName
	 * @param queryString
	 * @param orderBy
	 * @param orderType
	 * @return
	 */
	public PageResultResponse<MqData> pageQueryMqData(Integer pageNum,Integer pageSize,String dbName,String tableName,String queryString,String orderBy,String orderType){
		
			SearchResponse searchResponse  = client.prepareSearch(dbName)
				.setTypes(tableName)
				.setQuery(queryString==null||queryString.equals("")?QueryBuilders.matchAllQuery():QueryBuilders.queryStringQuery(queryString))
				.setSearchType(SearchType.QUERY_THEN_FETCH)  
		        .setFrom(pageSize*(pageNum-1)).setSize(pageSize)//分页  
//		        .addSort("@timestamp", SortOrder.DESC)//排序 
		        .addSort(orderBy==null||orderBy.equals("")?"@timestamp":orderBy, orderType==null||orderType.equals("desc")?SortOrder.DESC:SortOrder.ASC)
		        .get();  
				
				SearchHits hits = searchResponse.getHits();  
		        long total = hits.getTotalHits();  
		        SearchHit[] searchHits = hits.getHits();  
		        
		        List<MqData> l = new ArrayList<>();
		        for(int i = 0;i<searchHits.length;i++){
		        	SearchHit s = searchHits[i];
		        	s.getSource().get("properties");
		        	
		        	MqData data = new MqData();
		        	data.setHost(String.valueOf(s.getSource().get("host")));
		        	data.setMsgKey(fromStr(String.valueOf(s.getSource().get("properties"))).get("column1"));
		        	data.setProperties(String.valueOf(s.getSource().get("properties")));
		        	l.add(data);
		        	
		        }
		        return new PageResultResponse<MqData>(total, l);
	}
	
	
	public List<MqData> getMqDataList(String dbName,String tableName,String queryString){
		
		SearchResponse searchResponse  = client.prepareSearch(dbName)
			.setTypes(tableName)
			.setQuery(queryString==null||queryString.equals("")?QueryBuilders.matchAllQuery():QueryBuilders.queryStringQuery(queryString))
			.setSearchType(SearchType.QUERY_THEN_FETCH)  
			.addSort("@timestamp", SortOrder.DESC)//排序 
	        .get();  
			
			SearchHits hits = searchResponse.getHits();  
	        SearchHit[] searchHits = hits.getHits();  
	        
	        List<MqData> l = new ArrayList<>();
	        for(int i = 0;i<searchHits.length;i++){
	        	SearchHit s = searchHits[i];
	        	s.getSource().get("properties");
	        	
	        	MqData data = new MqData();
	        	data.setHost(String.valueOf(s.getSource().get("host")));
	        	data.setMsgKey(fromStr(String.valueOf(s.getSource().get("properties"))).get("column1"));
	        	data.setProperties(String.valueOf(s.getSource().get("properties")));
	        	l.add(data);
	        	
	        }
	        return l;
	}
	
	public Map<String,String> fromStr(String str){
		Map<String, String> strMap = new HashMap<String, String>();  
		String[] strs = str.replace("{", "").replace("}", "").split(",");
		for(String string : strs){
			
			String[] ss = string.trim().split("=");
			strMap.put(ss[0], ss[1]);
		}
		System.out.println(strMap);
		return strMap;
		
	}

}
