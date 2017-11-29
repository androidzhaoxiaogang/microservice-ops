/*
* Copyright 2016 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : marketing-common
*
* @File name : WechatSendUtil.java
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

package com.yonyou.microservice.wechat.util.copy;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.yonyou.microservice.wechat.common.RestServiceConstant;
import com.yonyou.microservice.wechat.dto.rest.RestServiceResultDto;

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
 * @date 2016年12月19日
 */

public class WechatSendUtil {
	private static Logger logger = Logger.getLogger(WechatSendUtil.class);
	// 发送的字符为UTF-8格式
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	// 设置读取超时时间 默认5S
	public static final int REST_READ_TIMEOUT = 10000;
	// 设置写的超时时间 默认5S
	public static final int REST_WRITE_TIMEOUT = 10000;
	// 设置连接超时时间 默认5S
	public static final int REST_CONN_TIMEOUT = 5000;

	public static RestServiceResultDto getMessageFromWechat(String url) {

		// 创建连接
		OkHttpClient client = new OkHttpClient.Builder().readTimeout(REST_READ_TIMEOUT, TimeUnit.MILLISECONDS)// 设置读取超时时间
				.writeTimeout(REST_WRITE_TIMEOUT, TimeUnit.MILLISECONDS)// 设置写的超时时间
				.connectTimeout(REST_CONN_TIMEOUT, TimeUnit.MILLISECONDS)// 设置连接超时时间
				.build();

		// 设置URL,JSON内容，头信息
		Request request = new Request.Builder().url(url).build();

		// 返回内容
		Response response = null;
		try {
			response = client.newCall(request).execute();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			RestServiceResultDto resultDto = new RestServiceResultDto();
			resultDto.setResultCode(RestServiceResultDto.FAIL);
			resultDto.setHttpCode(404);
			resultDto.setResultMsg(e.getMessage());
			resultDto.setResultBody(e.getMessage());
			return resultDto;
		}

		RestServiceResultDto resultDto = new RestServiceResultDto();
		// 封装返回给视图层的对象
		try {

			String responseBody = "";
			if (response != null) {
				responseBody = response.body().string();
				// 发送成功
				if (response.isSuccessful()) {
					// 响应方处理业务成功，返回201
					resultDto.setResultCode(RestServiceResultDto.SUCCESS);
					// HTTP CODE
					resultDto.setHttpCode(response.code());
					// 成功或者失败原因
					resultDto.setResultMsg(RestServiceConstant.RESPONSE_HEADER_CONTENT_SUCCESS);
					// 返回的JSON对象
					resultDto.setResultBody(responseBody);
				} else {
					// 返送失败(如无法连接，断网，500等)
					resultDto.setResultCode(RestServiceResultDto.FAIL);
					resultDto.setHttpCode(response.code());
					resultDto.setResultMsg(responseBody);
					resultDto.setResultBody(responseBody);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return resultDto;
	}

	/**
	 * 
	 *
	 * @author sangdeliang @ description 发送POST请求
	 * @date 2016年12月5日
	 * @param paramDto
	 * @return
	 * @throws Exception
	 */
	public static RestServiceResultDto postMessageForWechat(String url, String jsonBody) throws Exception {

		// 创建连接
		OkHttpClient client = new OkHttpClient.Builder().readTimeout(REST_READ_TIMEOUT, TimeUnit.MILLISECONDS)// 设置读取超时时间
				.writeTimeout(REST_WRITE_TIMEOUT, TimeUnit.MILLISECONDS)// 设置写的超时时间
				.connectTimeout(REST_CONN_TIMEOUT, TimeUnit.MILLISECONDS)// 设置连接超时时间
				.build();
		// 建立发送消息体
		RequestBody body = RequestBody.create(JSON, jsonBody);

		// 设置URL,JSON内容，头信息
		Request request = new Request.Builder().url(url).post(body).build();

		// 返回内容
		Response response = null;
		try {
			response = client.newCall(request).execute();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			RestServiceResultDto resultDto = new RestServiceResultDto();
			resultDto.setResultCode(RestServiceResultDto.FAIL);
			resultDto.setHttpCode(404);
			resultDto.setResultMsg(e.getMessage());
			resultDto.setResultBody(e.getMessage());
			return resultDto;
		}

		// 封装返回给视图层的对象
		RestServiceResultDto resultDto = new RestServiceResultDto();
		try {
			String responseBody = "";
			if (response != null) {
				responseBody = response.body().string();
				// 发送成功
				if (response.isSuccessful()) {
					// 响应方处理业务成功，返回201
					resultDto.setResultCode(RestServiceResultDto.SUCCESS);
					// HTTP CODE
					resultDto.setHttpCode(response.code());
					// 成功或者失败原因
					resultDto.setResultMsg(RestServiceConstant.RESPONSE_HEADER_CONTENT_SUCCESS);
					// 返回的JSON对象
					resultDto.setResultBody(responseBody);
				} else {
					// 返送失败(如业务异常)
					resultDto.setResultCode(RestServiceResultDto.FAIL);
					resultDto.setHttpCode(response.code());
					resultDto.setResultMsg(responseBody);
					resultDto.setResultBody(responseBody);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return resultDto;
	}

	/**
	 * 
	 *
	 * @author sangdeliang @ description 上传图文信息
	 * @date 2016年12月19日
	 * @param url
	 * @param file
	 */
	public static void uploadMultiFile(String url, File file) {
		RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
		RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
				.addFormDataPart("image", file.getName(), fileBody).build();
		Request request = new Request.Builder().url(url).post(requestBody).build();

		final okhttp3.OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
		OkHttpClient okHttpClient = httpBuilder
				// 设置超时
				.connectTimeout(10, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS).build();

		okHttpClient.newCall(request).enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				logger.error(e.getMessage(), e);
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {

			}
		});

	}

}
