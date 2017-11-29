/*
* Copyright 2016 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : marketing-common
*
* @File name : WechatSendService.java
*
* @Author : sangdeliang
*
* @Date : 2016年12月19日
*
----------------------------------------------------------------------------------
*     Date       Who       Version     Comments
* 1. 2016年12月19日    sangdeliang    1.0
*
*
*
*
----------------------------------------------------------------------------------
*/
	
package com.yonyou.microservice.wechat.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.xiaoleilu.hutool.http.HttpUtil;
import com.yonyou.cloud.common.http.HttpFileUtil;
import com.yonyou.microservice.wechat.common.WechatDict;
import com.yonyou.microservice.wechat.dao.TtWoMassSendMapper;
import com.yonyou.microservice.wechat.dao.WechatLocalPublistDao;
import com.yonyou.microservice.wechat.dto.TmNewsActivityWechatDto;
import com.yonyou.microservice.wechat.dto.WechatLocalSendLogDto;
import com.yonyou.microservice.wechat.dto.pictxt.PicTxtSendDto;
import com.yonyou.microservice.wechat.dto.pictxt.WcArticlesParamDto;
import com.yonyou.microservice.wechat.dto.pictxt.WcArticlesParamDto.Article;
import com.yonyou.microservice.wechat.dto.pictxt.WcArticlesResultDto;
import com.yonyou.microservice.wechat.dto.pictxt.WcBatchSendParamDto;
import com.yonyou.microservice.wechat.dto.rest.RestServiceResultDto;
import com.yonyou.microservice.wechat.entity.TtWoMassSend;
import com.yonyou.microservice.wechat.exception.WechatException;
import com.yonyou.microservice.wechat.util.RestServiceUtil;
import com.yonyou.microservice.wechat.util.WechatSendUtil;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
*
* @author sangdeliang
* @ description 微信发送消息业务
* @date 2016年12月19日
*/
@Service
public class WechatLocalMassPublishService {
    private Logger logger=Logger.getLogger(WechatLocalMassPublishService.class);
    @Autowired
    private WechatLocalPublistDao wechatLocalPublistDao;
    @Autowired
    private TtWoMassSendMapper ttWoMassSendMapper;

	@Value("${image.src.ip}")
	private String srcIp;
	@Value("${image.tgt.ip}")
	private String tgtIp;
    
    public Map<String, Object> treatWechatMessages(String accessToken) {
    	//以下生成各个活动素材的mediaId
    	List<TtWoMassSend> lists=ttWoMassSendMapper.selectUnSendWithDistinctObjectId();
    	for(TtWoMassSend o:lists){
    		sendPicture(o.getTitleImageUrl(),o.getObjectId().toString(),accessToken);
    	}
        //以下根据openId生成活动组合模板，一个模板下有多个openId和objectid，picTxtDtos为组合模板集合
    	List<TtWoMassSend> listd=ttWoMassSendMapper.selectUnSend();
    	String curOpenid="";
    	List<PicTxtSendDto> picTxtDtos=new ArrayList<>();
    	PicTxtSendDto picTxtSendDto=null;//picTxtSendDto存储一个openid下多个objectId
    	for(TtWoMassSend o:listd){
            if(!curOpenid.equals(o.getOpenId())){
            	curOpenid=o.getOpenId();
            	if(picTxtSendDto!=null && !existsAndUpdateComposite(picTxtDtos,picTxtSendDto))
            		picTxtDtos.add(picTxtSendDto);
            	picTxtSendDto=new PicTxtSendDto();
                picTxtSendDto.getOpenIds().add(o.getOpenId());
                picTxtSendDto.getObjectIds().add(o.getObjectId());
            }
    	}
    	if(picTxtSendDto!=null && !existsAndUpdateComposite(picTxtDtos,picTxtSendDto))
    		picTxtDtos.add(picTxtSendDto);
    	//上传活动组合的素材到微信，并群发给相关用户
    	sendPicAndTextMessages(picTxtDtos,listd,accessToken);
        return null;
    }
    private boolean existsAndUpdateComposite(List<PicTxtSendDto> picTxtDtos,PicTxtSendDto picTxtSendDto){
    	if(picTxtSendDto==null)
    		return false;
    	for(PicTxtSendDto o :picTxtDtos){
    		if(o.getObjectIds().toString().equals(picTxtSendDto.getObjectIds().toString())){
    			o.getOpenIds().add(picTxtSendDto.getOpenIds().get(0));
    			return true;
    		}
    		
    	}
    	return false;
    }

    public void sendPicture(String fileUrl,String objectId,String accessToken) throws WechatException{
    	logger.info("---srcIp="+srcIp+",tgtIp="+tgtIp);
        String url = WechatDict.WECHAT_URL_MEDIA_UPLOAD;
        url = url.replaceAll(WechatDict.WE_CHAT_REPLACESTR_ACCESS_TOKEN, "=" + accessToken);
        fileUrl= fileUrl.replace(srcIp, tgtIp);
        String upLoadingUrl = url.replaceAll(WechatDict.WE_CHAT_REPLACESTR_TYPE, "=image");
        try {
            logger.info("getMediaUpLoadingUrl-upLoadingUrl="+upLoadingUrl);
            String resultBody = HttpFileUtil.postMedia(upLoadingUrl, fileUrl);
            
            logger.info("uploadMultiFile() response=" + resultBody);
            if (resultBody.contains("errcode") && resultBody.contains("errmsg")) {
            	logger.info("---uploadMultiFile() error");
                //上传图片业务异常，记录LOG到数据库，后续可以重处理
                String logStr = resultBody.length() > WechatLocalSendLogDto.LOG_WORD_MAX? resultBody.substring(WechatLocalSendLogDto.LOG_WORD_MIN, WechatLocalSendLogDto.LOG_WORD_MAX): resultBody;
                WechatLocalSendLogDto logDto = new WechatLocalSendLogDto(WechatLocalSendLogDto.TYPE_UPLOAD_PIC, "",  WechatLocalSendLogDto.SUCCESS_NO, logStr);
                wechatLocalPublistDao.wechatSaveResultLog(logDto);
                return;
            }
            
            //生成图文信息
            WcArticlesResultDto articleResultDto = (WcArticlesResultDto)RestServiceUtil.jsonToObj(resultBody,WcArticlesResultDto.class) ;
            String mediaId = articleResultDto.getMediaId();
            Map<String,String> map=new HashMap<>();
            map.put("mediaId", mediaId);
            map.put("objectId", objectId);
            ttWoMassSendMapper.updateMediaId(map);
            logger.info("--WcArticlesResultDto.mediaId="+mediaId);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            throw new WechatException();
        }
    }
    private TtWoMassSend getMassSend(List<TtWoMassSend> unSends, Long objectId){
    	for(TtWoMassSend o:unSends){
    		if(o.getObjectId()==objectId){
    			return o;
    		}
    	}
    	return null;
    }
    private String getContidion(PicTxtSendDto dto){
		String condition="";
		for(Long id:dto.getObjectIds()){//遍历一个组合下所有的objectid
			condition=condition+"(object_id="+id.toString()+" and (";
    		for(String s:dto.getOpenIds()){
    			condition=condition+"open_id='"+s+"' or ";
    		}
    		condition=condition.substring(0, condition.length()-4);
    		condition=condition+") ) or ";
		}
		condition=condition.substring(0, condition.length()-4);
		return condition;
    }
    public void sendPicAndTextMessages(List<PicTxtSendDto> picTxtDtos,List<TtWoMassSend> unSends, String accessToken) {
        //替换URL中的变量ACCESS_TOKEN
    	for(PicTxtSendDto item :picTxtDtos){ //PicTxtSendDto一个对象代表一个组合，内含objectId列表、openId列表
            //批量发送图文信息给用户
            WcArticlesParamDto articleParamDto = new WcArticlesParamDto();
            List<Article> articleList = new ArrayList<>();
            articleParamDto.setArticles(articleList);
            String mediaIds="";
    		for(Long id:item.getObjectIds()){//遍历一个组合下所有的objectid
    			TtWoMassSend ms=this.getMassSend(unSends, id);
    			String mediaId=ms.getMediaId();
    			String url=ms.getContentUrl();
    			url= url.replace(srcIp, tgtIp);
                String content=HttpUtil.get(url, "");
    			mediaIds=mediaIds+mediaId;
    			Article articleDto  = articleParamDto.generateArticle();
                articleDto.setAuthor("三菱汽车");
                articleDto.setContent(content);
                articleDto.setContentSourceUrl(ms.getContentSourceUrl());
                //文章简要说明
                
                String digest = "";
                articleDto.setDigest(digest);
                articleDto.setShowCoverPic(1);
                articleDto.setThumbMediaId(mediaId);
                articleDto.setTitle(ms.getTitle());
                articleList.add(articleDto);
    		}
    		//上传组合好的推送材料，取得picTxtMediaId，用于群发用户
    		String picTextMediaId = "";
            try {
                //上传图文消息素材
                picTextMediaId = postPicTextInfo(articleParamDto, accessToken);
                Map<String,String> map=new HashMap<>();
                map.put("condition", this.getContidion(item));
                map.put("picTxtId", picTextMediaId);
                ttWoMassSendMapper.updatePicTextMediaId(map);

            } catch (Exception e) {
                logger.info(e);
                logger.info(e.getMessage());
                //上传图片业务异常，记录LOG到数据库，后续可以重处理
                String errMsg = e.getMessage().length() > WechatLocalSendLogDto.LOG_WORD_MAX? 
                    e.getMessage().substring(WechatLocalSendLogDto.LOG_WORD_MIN, WechatLocalSendLogDto.LOG_WORD_MAX): e.getMessage();
                WechatLocalSendLogDto logDto = new WechatLocalSendLogDto(WechatLocalSendLogDto.TYPE_UPLOAD_PIC_AND_TEXT, "",  WechatLocalSendLogDto.SUCCESS_NO, errMsg);
                wechatLocalPublistDao.wechatSaveResultLog(logDto);
                return ;
            }
            try {
                //群发
                WcBatchSendParamDto batchParamDto = new WcBatchSendParamDto();
                batchParamDto.setMsgtype(WechatDict.WE_CHAT_PICTEXT_BATCH_TYPE);
                batchParamDto.getMpnews().setMediaId(picTextMediaId);
                List<String> toUserList=new ArrayList<>();
                //遍历当前组合下的所有openid
        		for(String id:item.getOpenIds()){
                	toUserList.add(id);
        		}
                String logStr = "";
                if (toUserList.size() >= 2) {
                    //发送用户数不为空
                    batchParamDto.setTouser(toUserList);
                    RestServiceResultDto resultDto = postBatchInfo(batchParamDto, accessToken);
                    logStr = resultDto.getResultBody();
                } else {
                    //发送用户数为空
                    logStr = "to_openuserid list is empty or atleast 2";
                }
                logStr = logStr.length() > WechatLocalSendLogDto.LOG_WORD_MAX? logStr.substring(WechatLocalSendLogDto.LOG_WORD_MIN, WechatLocalSendLogDto.LOG_WORD_MAX): logStr;

                WechatLocalSendLogDto logDto = new WechatLocalSendLogDto(WechatLocalSendLogDto.TYPE_BATCH_SEND_OPENUSER, mediaIds + "," +picTextMediaId,  WechatLocalSendLogDto.SUCCESS_YES,logStr);
                wechatLocalPublistDao.wechatSaveResultLog(logDto);
                
            } catch (Exception e) {
                logger.info(e);
                logger.info(e.getMessage());
                //上传图片业务异常，记录LOG到数据库，后续可以重处理
                String errMsg = e.getMessage().length() > WechatLocalSendLogDto.LOG_WORD_MAX? 
                    e.getMessage().substring(WechatLocalSendLogDto.LOG_WORD_MIN, WechatLocalSendLogDto.LOG_WORD_MAX): e.getMessage();
                WechatLocalSendLogDto logDto = new WechatLocalSendLogDto(WechatLocalSendLogDto.TYPE_BATCH_SEND_OPENUSER, "",  WechatLocalSendLogDto.SUCCESS_NO,errMsg);
                wechatLocalPublistDao.wechatSaveResultLog(logDto);
                return ;
            }
    	}
    }
    
    
    /**
     * 
    *
    * @author sangdeliang
    * @ description 上传图片到微信服务器并发送
    * @date 2016年12月19日
    * @param url
    * @param file
     */
    public Map<String, Object> sendPicAndTextMessages(byte[] fileBytes, TmNewsActivityWechatDto activityDto, String accessToken) {
        //替换URL中的变量ACCESS_TOKEN
        String url = WechatDict.WECHAT_URL_MEDIA_UPLOAD;
        url = url.replaceAll(WechatDict.WE_CHAT_REPLACESTR_ACCESS_TOKEN, "=" + accessToken);
        url = url.replaceAll(WechatDict.WE_CHAT_REPLACESTR_TYPE, "=image");
        RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), fileBytes);
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM) 
                .addFormDataPart("image", "tempJpg.jpg", fileBody)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        final okhttp3.OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
        OkHttpClient okHttpClient  = httpBuilder
                //设置超时
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e){
                logger.info(e.getMessage());
                logger.info(e);
                //上传图片系统异常，记录LOG到数据库，后续可以重处理
                String errMsg = e.getMessage().length() > WechatLocalSendLogDto.LOG_WORD_MAX? 
                    e.getMessage().substring(WechatLocalSendLogDto.LOG_WORD_MIN, WechatLocalSendLogDto.LOG_WORD_MAX): e.getMessage();
                WechatLocalSendLogDto logDto = new WechatLocalSendLogDto(WechatLocalSendLogDto.TYPE_UPLOAD_PIC, "",  WechatLocalSendLogDto.SUCCESS_NO, 
                                                               errMsg);
                wechatLocalPublistDao.wechatSaveResultLog(logDto);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String resultBody = response.body().string();
                logger.info("uploadMultiFile() response=" + resultBody);
                if (resultBody.contains("errcode") && resultBody.contains("errmsg")) {
                	logger.info("---uploadMultiFile() error");
                    //上传图片业务异常，记录LOG到数据库，后续可以重处理
                    String logStr = resultBody.length() > WechatLocalSendLogDto.LOG_WORD_MAX? resultBody.substring(WechatLocalSendLogDto.LOG_WORD_MIN, WechatLocalSendLogDto.LOG_WORD_MAX): resultBody;
                    WechatLocalSendLogDto logDto = new WechatLocalSendLogDto(WechatLocalSendLogDto.TYPE_UPLOAD_PIC, "",  WechatLocalSendLogDto.SUCCESS_NO, logStr);
                    wechatLocalPublistDao.wechatSaveResultLog(logDto);
                    return;
                }
                
                //生成图文信息
                WcArticlesResultDto articleResultDto;
                String mediaId ="";
				try {
					articleResultDto = (WcArticlesResultDto)RestServiceUtil.jsonToObj(resultBody,WcArticlesResultDto.class);
					mediaId = articleResultDto.getMediaId();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
                
                logger.info("--WcArticlesResultDto.mediaId="+mediaId);
                //批量发送图文信息给用户
                WcArticlesParamDto articleParamDto = new WcArticlesParamDto();
                List<Article> articleList = new ArrayList<>();
                Article articleDto  = articleParamDto.generateArticle();
                articleDto.setAuthor("三菱汽车");
                String content = activityDto.getContent();
                articleDto.setContent(content);
                articleDto.setContentSourceUrl("");
                //文章简要说明
                String digest = "";
                if (content.length() > 20) {
                    digest = content.substring(0, 20);
                }
                articleDto.setDigest(digest);
                articleDto.setShowCoverPic(1);
                articleDto.setThumbMediaId(mediaId);
                articleDto.setTitle(articleDto.getTitle());
                articleList.add(articleDto);
                articleParamDto.setArticles(articleList);
                
                String picTextMediaId = "";
                try {
                    //上传图文消息素材
                    picTextMediaId = postPicTextInfo(articleParamDto, accessToken);

                } catch (Exception e) {
                    logger.info(e);
                    logger.info(e.getMessage());
                    //上传图片业务异常，记录LOG到数据库，后续可以重处理
                    String errMsg = e.getMessage().length() > WechatLocalSendLogDto.LOG_WORD_MAX? 
                        e.getMessage().substring(WechatLocalSendLogDto.LOG_WORD_MIN, WechatLocalSendLogDto.LOG_WORD_MAX): e.getMessage();
                    WechatLocalSendLogDto logDto = new WechatLocalSendLogDto(WechatLocalSendLogDto.TYPE_UPLOAD_PIC_AND_TEXT, "",  WechatLocalSendLogDto.SUCCESS_NO, errMsg);
                    wechatLocalPublistDao.wechatSaveResultLog(logDto);
                    return;
                }
                
                try {
                    //群发
                    WcBatchSendParamDto batchParamDto = new WcBatchSendParamDto();
                    batchParamDto.setMsgtype(WechatDict.WE_CHAT_PICTEXT_BATCH_TYPE);
                    batchParamDto.getMpnews().setMediaId(picTextMediaId);
                    List<String> toUserList=new ArrayList<>();
                    for(String u:activityDto.getOpenIdList()){
                    	toUserList.add(u);
                    }
                    String logStr = "";
                    if (toUserList.size() >= 2) {
                        //发送用户数不为空
                        batchParamDto.setTouser(toUserList);
                        RestServiceResultDto resultDto = postBatchInfo(batchParamDto, accessToken);
                        logStr = resultDto.getResultBody();
                    } else {
                        //发送用户数为空
                        logStr = "to_openuserid list is empty or atleast 2";
                    }
                    logStr = logStr.length() > WechatLocalSendLogDto.LOG_WORD_MAX? logStr.substring(WechatLocalSendLogDto.LOG_WORD_MIN, WechatLocalSendLogDto.LOG_WORD_MAX): logStr;

                    WechatLocalSendLogDto logDto = new WechatLocalSendLogDto(WechatLocalSendLogDto.TYPE_BATCH_SEND_OPENUSER, mediaId + "," +picTextMediaId,  WechatLocalSendLogDto.SUCCESS_YES,logStr);
                    wechatLocalPublistDao.wechatSaveResultLog(logDto);
                    
                } catch (Exception e) {
                    logger.info(e);
                    logger.info(e.getMessage());
                    //上传图片业务异常，记录LOG到数据库，后续可以重处理
                    String errMsg = e.getMessage().length() > WechatLocalSendLogDto.LOG_WORD_MAX? 
                        e.getMessage().substring(WechatLocalSendLogDto.LOG_WORD_MIN, WechatLocalSendLogDto.LOG_WORD_MAX): e.getMessage();
                    WechatLocalSendLogDto logDto = new WechatLocalSendLogDto(WechatLocalSendLogDto.TYPE_BATCH_SEND_OPENUSER, "",  WechatLocalSendLogDto.SUCCESS_NO,errMsg);
                    wechatLocalPublistDao.wechatSaveResultLog(logDto);
                    return;
                }

            }
        });
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("STATUS", "1");
        resultMap.put("MESSAGE", "已经推送给微信，等待微信发送");
        return resultMap;
    }
    
    /**
     * 
    *
    * @author sangdeliang
    * @ description 发送图文消息到微信服务器 ，上传图文消息素材
    * @date 2016年12月19日
    * @param articlesParamDto
    * @return
    * @throws Exception
     */
    public String postPicTextInfo(WcArticlesParamDto articlesParamDto, String accessToken) {
        //替换URL中的变量ACCESS_TOKEN
        String url = WechatDict.WECHAT_URL_PIC_TEXT_CREATE;
        url = url.replaceAll(WechatDict.WE_CHAT_REPLACESTR_ACCESS_TOKEN, "=" + accessToken);
        try {
            String jsonBody = RestServiceUtil.objectToJson(articlesParamDto);
            logger.info("群发数据 =" + jsonBody);
            RestServiceResultDto resultDto = WechatSendUtil.postMessageForWechat(url, jsonBody);
            if (resultDto != null) {
                String resultBody = resultDto.getResultBody();
                logger.info("群发返回结果 response=" + resultBody);
                if (resultBody.contains("errcode") && resultBody.contains("errmsg")) {
                    logger.info("postPicTextInfo error:" + resultBody);
                }
                WcArticlesResultDto articleResDto = (WcArticlesResultDto)RestServiceUtil.jsonToObj(resultBody,WcArticlesResultDto.class) ;
                String picTextMediaid = articleResDto.getMediaId();
                return picTextMediaid;
            }
            logger.info("群发数据 失败" + jsonBody);
            return "";
        } catch (Exception e) {
            logger.info(e);
            logger.info(e.getMessage());
            return "";
        }
    }
    
    /**
     * 
    *
    * @author sangdeliang
    * @ description 批量推送图文信息给关注用户
    * @date 2016年12月20日
    * @param batchParamDto
    * @throws Exception
     */
    public RestServiceResultDto postBatchInfo(WcBatchSendParamDto batchParamDto, String accessToken) {
      //替换URL中的变量ACCESS_TOKEN
        String url = WechatDict.WECHAT_URL_PIC_TEXT_BATCH_SEND;
        url = url.replaceAll(WechatDict.WE_CHAT_REPLACESTR_ACCESS_TOKEN, "=" + accessToken);
        
        RestServiceResultDto resultDto = null;
        try {
            String jsonBody = RestServiceUtil.objectToJson(batchParamDto);
            resultDto = WechatSendUtil.postMessageForWechat(url, jsonBody);
            if (resultDto != null) {
                String resultBody = resultDto.getResultBody();
                logger.info("uploadMultiFile() response=" + resultBody);
            } else {
            	logger.info("批量发送失败 resultDto = NULL");
            }
        } catch (Exception e) {
            logger.info(e);
        }
        return resultDto;
    }

    
    public void sendPicture(byte[] fileBytes, String objectId, String accessToken){
    	//替换URL中的变量ACCESS_TOKEN
        String url = WechatDict.WECHAT_URL_MEDIA_UPLOAD;
        url = url.replaceAll(WechatDict.WE_CHAT_REPLACESTR_ACCESS_TOKEN, "=" + accessToken);
        url = url.replaceAll(WechatDict.WE_CHAT_REPLACESTR_TYPE, "=image");
        RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), fileBytes);
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM) 
                .addFormDataPart("image", "tempJpg.jpg", fileBody)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        final okhttp3.OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
        OkHttpClient okHttpClient  = httpBuilder
                //设置超时
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e){
                logger.info(e.getMessage());
                logger.info(e);
                //上传图片系统异常，记录LOG到数据库，后续可以重处理
                String errMsg = e.getMessage().length() > WechatLocalSendLogDto.LOG_WORD_MAX? 
                    e.getMessage().substring(WechatLocalSendLogDto.LOG_WORD_MIN, WechatLocalSendLogDto.LOG_WORD_MAX): e.getMessage();
                WechatLocalSendLogDto logDto = new WechatLocalSendLogDto(WechatLocalSendLogDto.TYPE_UPLOAD_PIC, "",  WechatLocalSendLogDto.SUCCESS_NO, 
                                                               errMsg);
                wechatLocalPublistDao.wechatSaveResultLog(logDto);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String resultBody = response.body().string();
                logger.info("uploadMultiFile() response=" + resultBody);
                if (resultBody.contains("errcode") && resultBody.contains("errmsg")) {
                	logger.info("---uploadMultiFile() error");
                    //上传图片业务异常，记录LOG到数据库，后续可以重处理
                    String logStr = resultBody.length() > WechatLocalSendLogDto.LOG_WORD_MAX? resultBody.substring(WechatLocalSendLogDto.LOG_WORD_MIN, WechatLocalSendLogDto.LOG_WORD_MAX): resultBody;
                    WechatLocalSendLogDto logDto = new WechatLocalSendLogDto(WechatLocalSendLogDto.TYPE_UPLOAD_PIC, "",  WechatLocalSendLogDto.SUCCESS_NO, logStr);
                    wechatLocalPublistDao.wechatSaveResultLog(logDto);
                    return;
                }
                
                //生成图文信息
                String mediaId =((Double)(Math.random()*1000)).toString();
                Map<String,String> map=new HashMap<>();
                map.put("mediaId", mediaId);
                map.put("objectId", objectId);
                ttWoMassSendMapper.updateMediaId(map);
                logger.info("--WcArticlesResultDto.mediaId="+mediaId);

            }
        });
    } 
    
}
