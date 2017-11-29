/*
* Copyright 2016 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : marketing-dealer-open-api
*
* @File name : RestDemoUtil.java
*
* @Author : sangdeliang
*
* @Date : 2016年11月29日
*
----------------------------------------------------------------------------------
*     Date       Who       Version     Comments
* 1. 2016年11月29日    sangdeliang    1.0
*
*
*
*
----------------------------------------------------------------------------------
*/
	
package com.yonyou.microservice.wechat.util.copy;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.http.HttpHeaders;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yonyou.microservice.wechat.common.RestServiceConstant;
import com.yonyou.microservice.wechat.dto.rest.RestServiceDmsErrDto;
import com.yonyou.microservice.wechat.dto.rest.RestServiceParamDto;
import com.yonyou.microservice.wechat.dto.rest.RestServiceResultDto;
import com.yonyou.microservice.wechat.dto.rest.SystemSecurityUtil;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
*
* @author sangdeliang
* @ description OKHTTP发送消息工具类
* @date 2016年11月29日
*/

public class RestServiceUtil {
	private static Logger logger = Logger.getLogger(RestServiceUtil.class);
    public static final boolean SECURITY_TIME_STAMP_SWITCH = false;
    //发送的字符为UTF-8格式
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    //设置读取超时时间  默认5S
    public static final int REST_READ_TIMEOUT = 5000;
    //设置写的超时时间  默认5S
    public static final int REST_WRITE_TIMEOUT = 5000;
    //设置连接超时时间  默认5S
    public static final int REST_CONN_TIMEOUT = 5000;
    
    /**
     * 
    *
    * @author sangdeliang
    * @ description 发送GET请求，并且返回消息内容
    * @date 2016年12月5日
    * @param paramDto
    * @return
    * @throws Exception
     */
    public static RestServiceResultDto getMessageFromDms(RestServiceParamDto paramDto) throws Exception{
        //URL
        String url = paramDto.getUrl();
        //替换URL中{xxx}的参数
        url = buildUrlParams(url, paramDto.getUrlParams());
        
        //头信息MAP
        Map<String, String> headersParams = paramDto.getHeadersParams();
        
        //将MAP转换为HEADERS信息(并将一部分信息进行加密)
        Headers headers = buildHeaders(headersParams, url, "");
        
        //创建连接
        OkHttpClient client =  
                new OkHttpClient.Builder()  
                        .readTimeout(REST_READ_TIMEOUT,TimeUnit.MILLISECONDS)//设置读取超时时间  
                        .writeTimeout(REST_WRITE_TIMEOUT,TimeUnit.MILLISECONDS)//设置写的超时时间  
                        .connectTimeout(REST_CONN_TIMEOUT,TimeUnit.MILLISECONDS)//设置连接超时时间  
                        .build();  
        
        //设置URL,JSON内容，头信息
        Request request = new Request.Builder()
            .url(url)
            .headers(headers)
            .build();
        
        //返回内容
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (Exception e) {
        	logger.error(e.getMessage(),e);
            RestServiceResultDto resultDto = new RestServiceResultDto();
            resultDto.setResultCode(RestServiceResultDto.FAIL);
            resultDto.setHttpCode(404);
            resultDto.setResultMsg(e.getMessage());
            return resultDto;
        }
                

        //封装返回给视图层的对象
        RestServiceResultDto resultDto = new RestServiceResultDto();
        String responseBody = "";
        if (response != null) {
            responseBody = response.body().string(); 
            //发送成功
            if (response.isSuccessful()) {
                //响应方处理业务成功，返回201
                resultDto.setResultCode(RestServiceResultDto.SUCCESS);
                //HTTP CODE
                resultDto.setHttpCode(response.code());
                //成功或者失败原因
                resultDto.setResultMsg(RestServiceConstant.RESPONSE_HEADER_CONTENT_SUCCESS);
                //返回的JSON对象
                resultDto.setResultBody(responseBody);
            } else {
                //返送失败(如无法连接，断网，500等)
                resultDto.setResultCode(RestServiceResultDto.FAIL);
                resultDto.setHttpCode(response.code());
                resultDto.setResultMsg(responseBody);
                if (responseBody.indexOf("errorMsg") > -1) {
                    try {
                        RestServiceDmsErrDto errDto = (RestServiceDmsErrDto)jsonToObj(responseBody,RestServiceDmsErrDto.class) ;
                        resultDto.setResultMsg(errDto.getErrorMsg());
                    } catch(Exception e) {
                    	logger.error(e.getMessage(),e);
                    }
                }
                
                resultDto.setResultBody(responseBody);
            }
        }
        
        return resultDto;
    }
    
    /**
     * 
    *
    * @author sangdeliang
    * @ description 发送POST请求
    * @date 2016年12月5日
    * @param paramDto
    * @return
    * @throws Exception
     */
    public static RestServiceResultDto postMessageForDms(RestServiceParamDto paramDto) throws Exception{
        //URL
        String url = paramDto.getUrl();
        url = buildUrlParams(url, paramDto.getUrlParams());
        //消息内容
        String jsonContent = paramDto.getJson();
        //头信息MAP
        Map<String, String> headersParams = paramDto.getHeadersParams();
        //将MAP转换为HEADERS信息(并将一部分信息进行加密)
        Headers headers = buildHeaders(headersParams, url, jsonContent);
        
        //创建连接
        OkHttpClient client =  
                new OkHttpClient.Builder()  
                        .readTimeout(REST_READ_TIMEOUT,TimeUnit.MILLISECONDS)//设置读取超时时间  
                        .writeTimeout(REST_WRITE_TIMEOUT,TimeUnit.MILLISECONDS)//设置写的超时时间  
                        .connectTimeout(REST_CONN_TIMEOUT,TimeUnit.MILLISECONDS)//设置连接超时时间  
                        .build();  
        //建立发送消息体
        RequestBody body = RequestBody.create(JSON, jsonContent);
        
        //设置URL,JSON内容，头信息
        Request request = new Request.Builder()
            .url(url)
            .post(body)
            .headers(headers)
            .build();

        //返回内容
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (Exception e) {
        	logger.error(e.getMessage(),e);
            RestServiceResultDto resultDto = new RestServiceResultDto();
            resultDto.setResultCode(RestServiceResultDto.FAIL);
            resultDto.setHttpCode(404);
            resultDto.setResultMsg(e.getMessage());
            return resultDto;
        }
        
        //封装返回给视图层的对象
        RestServiceResultDto resultDto = new RestServiceResultDto();
        
        String responseBody = "";
        if (response != null) {
            responseBody = response.body().string(); 
          //发送成功
            if (response.isSuccessful()) {
                //响应方处理业务成功，返回201
                resultDto.setResultCode(RestServiceResultDto.SUCCESS);
                //HTTP CODE
                resultDto.setHttpCode(response.code());
                //成功或者失败原因
                resultDto.setResultMsg(RestServiceConstant.RESPONSE_HEADER_CONTENT_SUCCESS);
                //返回的JSON对象
                resultDto.setResultBody(responseBody);
            } else {
                //返送失败(如业务异常)
                resultDto.setResultCode(RestServiceResultDto.FAIL);
                resultDto.setHttpCode(response.code());
                resultDto.setResultMsg(responseBody);
                if (responseBody.indexOf("errorMsg") > -1) {
                    try {
                        RestServiceDmsErrDto errDto = (RestServiceDmsErrDto)jsonToObj(responseBody,RestServiceDmsErrDto.class) ;
                        resultDto.setResultMsg(errDto.getErrorMsg());
                    } catch(Exception e) {
                    	logger.error(e.getMessage(),e);
                    }
                }
                resultDto.setResultBody(responseBody);
            }
        }
        
        return resultDto;
    }
    
    /**
     * 
    *
    * @author sangdeliang
    * @ description 把MAP的类型转化为OKHTTP的HEADERS类型
    * @date 2016年11月29日U
    * @param headersParams
    * @return
     * @throws Exception 
     */
    private static Headers buildHeaders(Map<String, String> headersParams, String url, String jsonBody) throws Exception {  
        okhttp3.Headers.Builder headersbuilder=new okhttp3.Headers.Builder();  
        //循环遍历并解析
        if(headersParams != null && headersParams.size() > 0)  
        {  
            Iterator<String> iterator = headersParams.keySet().iterator();  
            while (iterator.hasNext()) {  
            	String key = "";  
            	if(iterator.next()!=null){
            		key = iterator.next().toString();  
            	}
                String value = headersParams.get(key);
                headersbuilder.add(key, value);  
            }  
        }  
        //在头信息中增加MD5加密串
        String urlPath = new URL(url).getPath();
        String decodeUrlStr = urlPath + jsonBody;
        String encodeMd5Str = encoderByMd5(SystemSecurityUtil.CRYPT_KEY, decodeUrlStr );
        headersbuilder.add(RestServiceConstant.REQUEST_URL_BODY_MD5_CODE, encodeMd5Str);
        
        Headers headers=headersbuilder.build();  
        return headers;  
    }  
    
    /**
     * 
    *
    * @author sangdeliang
    * @ description 替换URL中的{xxx}为XXX
    * @date 2016年12月5日
    * @param urlParams
    * @return
     */
    private static String buildUrlParams(String url, Map<String, String> urlParams) {
        //URL后缀
        String urlReplace = url;
        if(urlParams != null && !urlParams.isEmpty())  
        {  
            Iterator<String> iterator = urlParams.keySet().iterator();  
            while (iterator.hasNext()) {  
            	String key = "";  
            	if(iterator.next()!=null){
            		key = iterator.next().toString();  
            	}
                String value = urlParams.get(key);
                if (key != null && !"".equals(key)) {
                    urlReplace = urlReplace.replaceAll("\\{" + key + "\\}", value);
                }
            }  
        }  
        return urlReplace;
    }
    
    /**
     * 获得当前的分钟数,每天1440分钟
     * @return
     */
    public static long getNowMinute() {
        Calendar calendar = Calendar.getInstance();
        long thisTimeStamp =  calendar.getTimeInMillis();
        long minute = thisTimeStamp /1000 /60;
        return minute;
    }

    /**
     * 获得当前的天数，每天24 * 60 * 60  * 1000 毫秒
     * @return
     */
    public static long getNowDate() {
        Calendar calendar = Calendar.getInstance();
        long thisTimeStamp =  calendar.getTimeInMillis();
        long date = thisTimeStamp /1000 /60 /60 /24;
        return date;
    }
    
    /**
     * 
    *
    * @author sangdeliang
    * @ description 判断TOKEN时间戳是否有效
    * @date 2016年12月6日
    * @param headers
    * @return
     */
    public static boolean isTokenVolid(HttpHeaders headers) {
        try {
            //如果开关没有打开，则返回成功
            if (SECURITY_TIME_STAMP_SWITCH) {
                return true;
            }
            
            //获取时间戳数据(加密后的)
            String securityTimeStamp = headers.getFirst(RestServiceConstant.REQUEST_HEADER_TIME_STAMP);
            if (securityTimeStamp == null) {
                return false;
            }
            //解密
            String decodeTimeStr = SystemSecurityUtil.decrypt(securityTimeStamp);
            long decodeTimeLong = Long.parseLong(decodeTimeStr);
            long nowMinute = RestServiceUtil.getNowMinute();
            //时间戳TOKEN在60分钟之内有效
            if (decodeTimeLong < 0 || nowMinute - decodeTimeLong > 60) {
                return false;
            }
            return true;
        } catch (Exception e) {
        	logger.error(e.getMessage(),e);
            return false;
        }
    }
    
    /**
     * 将json转化为实体POJO
     * @param jsonStr
     * @param obj
     * @return
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
     */
    public static<T> Object jsonToObj(String jsonStr,Class<T> obj) throws JsonParseException, JsonMappingException, IOException {
    	ObjectMapper objectMapper = new ObjectMapper();
        T t = objectMapper.readValue(jsonStr,obj);
        return t;
    }
     
    /**
     * 将实体POJO转化为JSON
     * @param <T>
     * @param obj
     * @return
     * @throws JsonProcessingException 
     * @throws JSONException
     * @throws IOException
     */
    public static<T> String objectToJson(T obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper(); 
        String jsonStr =  mapper.writeValueAsString(obj);
        return jsonStr;
    }
    
    /**
     * 
    *
    * @author sangdeliang
    * @ description JSON转换为MAP
    * @date 2016年12月7日
    * @param json
    * @return
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
    * @throws Exception
     */
    @SuppressWarnings("unchecked")
	public Map<String , Object> jsonToMap(String json) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();  
        Map<String , Object> map = (Map<String , Object>)mapper.readValue(json, Map.class);
        return map;
    }
    
    public static String buildMd5Str(String url, String jsonBody) throws Exception {
        String md5String = url;
        if (jsonBody != null) {
            md5String += jsonBody;
        }
        return encoderByMd5(SystemSecurityUtil.CRYPT_KEY, md5String);
    }
    

    /**利用MD5进行加密
     * @param str  待加密的字符串
     * @return  加密后的字符串
     * @throws Exception 
     */
    /**
     * 
    * 根据盐生成密码
    * @author zhangxc
    * @date 2016年9月14日
    * @param salt
    * @param passwrod
    * @return
     * @throws UnsupportedEncodingException 
     * @throws NoSuchAlgorithmException 
     */
    public static String encoderByMd5(String salt,String content) throws Exception {
        //声明消息摘要对象
        MessageDigest md = MessageDigest.getInstance("MD5");
        //将盐数据传入消息摘要对象
        md.update(salt.getBytes("UTF-8"));
        //将口令的数据传给消息摘要对象
        md.update(content.getBytes("UTF-8"));
        return new BigInteger(1, md.digest()).toString(16).toUpperCase();
    }

}
