package com.yonyou.dmc.service.task.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtil {
	private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	
	

	/**
	 * post方式请求
	 * @param url			请求地址
	 * @param jsonBody	参数内容格式为: {"name":"你好"}
	 * @return
	 */
	public static String post(String url, String jsonBody) {
		return post(url,jsonBody,"application/json;charset=utf-8");
	}
	public static String post(String url, String data,String ContentType) {
		String result ="";
		// 创建默认的httpClient实例
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httppost
		HttpPost httpPost = new HttpPost(url);
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10*1000).setConnectTimeout(10*1000).build();
		httpPost.setConfig(requestConfig);
		// 创建参数队列
		try {
			StringEntity input = new StringEntity(data, "UTF-8");
			input.setContentType(ContentType);
			httpPost.setEntity(input);
			CloseableHttpResponse response = httpclient.execute(httpPost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					result = EntityUtils.toString(entity, "UTF-8");
				}
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			logger.error("异常" + e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			logger.error("异常" + e.getMessage(), e);
		} catch (IOException e) {
			logger.error("异常" + e.getMessage(), e);
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				logger.error("异常" + e.getMessage(), e);
			}
		}
		return result;
	}

    public static String postContainSsl(String urlPath,String data){
		return postContainSsl(urlPath,data,"application/json;charset=utf-8",null);
    }

    public static String postContainSsl(String urlPath,String data,
   		 Map<String,String> headers){
		return postContainSsl(urlPath,data,"application/json;charset=utf-8",headers);
    }
//    
//    public static String postContainSsl(String urlPath,String data,String ContentType){
//		logger.debug("url:"+urlPath);
//				SslUtil.trustAllHosts();
//				String result="";
//				StringBuffer sb=new StringBuffer();
//				HttpURLConnection connection = null;
//				try {
//					URL url=new URL(urlPath);
//		            if (url.getProtocol().toLowerCase().equals("https")) {  
//		            	HttpsURLConnection httpConn = (HttpsURLConnection)url.openConnection();  
//		            	httpConn.setHostnameVerifier(SslUtil.DO_NOT_VERIFY);  
//		                connection = httpConn;  
//		            } else {  
//		            	connection = (HttpURLConnection)url.openConnection();  
//		            }  
//				    //设置参数
//		            connection.setReadTimeout(30*1000);
//		            connection.setConnectTimeout(30*1000);
//		            connection.setDoOutput(true);   //需要输出
//		            connection.setDoInput(true);   //需要输入
//		            connection.setUseCaches(false);  //不允许缓存
//		            connection.setRequestMethod("POST");   //设置POST方式连接
//				    //设置请求属性
//		            connection.setRequestProperty("Content-Type", ContentType);
//		            connection.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
//		            connection.setRequestProperty("Charset", "UTF-8");
//				    //连接,也可以不用明文connect，使用下面的httpConn.getOutputStream()会自动connect
//		            
//		            connection.connect();
//				    //建立输入流，向指向的URL传入参数
//		         // 创建参数队列  
//				    DataOutputStream dos=new DataOutputStream(connection.getOutputStream());
//				    dos.write(data.getBytes());
//				    //dos.writeBytes(data);
//				    dos.flush();
//				    dos.close();
//
//				    //获得响应状态
//				    int resultCode=connection.getResponseCode();
//				    if(HttpURLConnection.HTTP_OK==resultCode){
//				      int i=1;
//				      String readLine=new String();
//				      BufferedReader responseReader=new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
//				      while((readLine=responseReader.readLine())!=null){
//				    	  sb.append(readLine);
//				    	  if(i>1) sb.append(readLine).append("\n");
//				    	  i=2;
//				      }
//				      result=sb.toString();
//				      responseReader.close();
//				    }else{
//				    	result="远程调用失败："+urlPath+"，错误编码:"+resultCode;
//				    }
//				} catch (Exception e) {
//			    	result="远程调用失败："+urlPath+"，错误信息:"+e.getMessage();
//					logger.error("error:"+e.getMessage());
//				}finally{
//					if(connection!=null)
//						connection.disconnect();
//				}
//				logger.debug("返回参数:"+result);
//				return result;
//	}
    public static String postContainSsl(String urlPath,String data,String ContentType,
    		 Map<String,String> headers){
		logger.debug("url:"+urlPath);
				SslUtil.trustAllHosts();
				String result="";
				StringBuffer sb=new StringBuffer();
				HttpURLConnection connection = null;
				try {
					URL url=new URL(urlPath);
		            if (url.getProtocol().toLowerCase().equals("https")) {  
		            	HttpsURLConnection httpConn = (HttpsURLConnection)url.openConnection();  
		            	httpConn.setHostnameVerifier(SslUtil.DO_NOT_VERIFY);  
		                connection = httpConn;  
		            } else {  
		            	connection = (HttpURLConnection)url.openConnection();  
		            }  
		            for (Map.Entry<String, String> entry : headers.entrySet()) {
		            	connection.setRequestProperty(entry.getKey(), entry.getValue());
		            }
		            
				    //设置参数
		            connection.setReadTimeout(30*1000);
		            connection.setConnectTimeout(30*1000);
		            connection.setDoOutput(true);   //需要输出
		            connection.setDoInput(true);   //需要输入
		            connection.setUseCaches(false);  //不允许缓存
		            connection.setRequestMethod("POST");   //设置POST方式连接
				    //设置请求属性
		            connection.setRequestProperty("Content-Type", ContentType);
		            connection.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
		            connection.setRequestProperty("Charset", "UTF-8");
				    //连接,也可以不用明文connect，使用下面的httpConn.getOutputStream()会自动connect
		            
		            connection.connect();
				    //建立输入流，向指向的URL传入参数
		         // 创建参数队列  
				    DataOutputStream dos=new DataOutputStream(connection.getOutputStream());
				    dos.write(data.getBytes());
				    //dos.writeBytes(data);
				    dos.flush();
				    dos.close();

				    //获得响应状态
				    int resultCode=connection.getResponseCode();
				    if(HttpURLConnection.HTTP_OK==resultCode){
				      int i=1;
				      String readLine=new String();
				      BufferedReader responseReader=new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
				      while((readLine=responseReader.readLine())!=null){
				    	  sb.append(readLine);
				    	  if(i>1) sb.append(readLine).append("\n");
				    	  i=2;
				      }
				      result=sb.toString();
				      responseReader.close();
				    }else{
				    	result="远程调用失败："+urlPath+"，错误编码:"+resultCode;
				    }
				} catch (Exception e) {
			    	result="远程调用失败："+urlPath+"，错误信息:"+e.getMessage();
					logger.error("error:"+e.getMessage());
				}finally{
					if(connection!=null)
						connection.disconnect();
				}
				logger.debug("返回参数:"+result);
				return result;
	}
    
	/**
	 * post方式请求
	 * @param url			请求地址
	 * @param params		系统参数
	 * @return
	 */
	public static String post(String url, Map<String, String> params) {
		logger.debug("url:"+url);
		String result = null;
		// 创建默认的httpClient实例.  
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httppost  
		HttpPost httpPost = new HttpPost(url);
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10*1000).setConnectTimeout(10*1000).build();
		httpPost.setConfig(requestConfig);
		// 创建参数队列  
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		Iterator<Entry<String, String>> entryKeyIterator = params.entrySet().iterator();
		while (entryKeyIterator.hasNext()) {
			Entry<String, String> e = entryKeyIterator.next();
			formparams.add(new BasicNameValuePair(e.getKey(), e.getValue()));
		}
		UrlEncodedFormEntity uefEntity;
		try {
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httpPost.setEntity(uefEntity);
			CloseableHttpResponse response = httpclient.execute(httpPost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					result = EntityUtils.toString(entity, "UTF-8");
				}
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			logger.error("异常" + e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			logger.error("异常" + e.getMessage(), e);
		} catch (IOException e) {
			logger.error("异常" + e.getMessage(), e);
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				logger.error("异常" + e.getMessage(), e);
			}
		}
		return result;
	}
	
	
	 /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
    	logger.info("get请求开始");
        String result = "";
        BufferedReader in = null;
        HttpURLConnection connection = null;
        try {  
        	SslUtil.trustAllHosts();
        	String urlNameString = url+param;
        	logger.debug("请求url:"+urlNameString);
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接  
            if (realUrl.getProtocol().toLowerCase().equals("https")) {  
            	HttpsURLConnection https = (HttpsURLConnection)realUrl.openConnection();  
                https.setHostnameVerifier(SslUtil.DO_NOT_VERIFY);  
                connection = https;  
            } else {  
            	connection = (HttpURLConnection)realUrl.openConnection();  
            }  
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setConnectTimeout(10*1000);
            connection.setReadTimeout(10*1000);
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段

            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
        	logger.error("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        logger.debug("返回参数:"+result);
        return result;
    }

    public static byte[] sendGetPicture(String url, String param) {
    	logger.info("get请求开始");
        byte[] result = null;
        BufferedReader in = null;
        HttpURLConnection connection = null;
        try {  
        	SslUtil.trustAllHosts();
        	String urlNameString = url+param;
        	logger.debug("请求url:"+urlNameString);
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接  
            if (realUrl.getProtocol().toLowerCase().equals("https")) {  
            	HttpsURLConnection https = (HttpsURLConnection)realUrl.openConnection();  
                https.setHostnameVerifier(SslUtil.DO_NOT_VERIFY);  
                connection = https;  
            } else {  
            	connection = (HttpURLConnection)realUrl.openConnection();  
            }  
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setConnectTimeout(10*1000);
            connection.setReadTimeout(10*1000);
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段

            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            InputStream is=connection.getInputStream();
            
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            int len = 0;  
            byte[] buffer = new byte[1024];  
            //将输入流写入到我们定义好的文件中  
            while ((len = is.read(buffer)) != -1) {  
            	output.write(buffer, 0, len);  
            } 
            result=output.toByteArray();
        } catch (Exception e) {
        	logger.error("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        logger.debug("返回参数:"+result);
        return result;
    }
    
    /**
     * get请求的参数转换 
     * @param param  
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String urlEncode(String param,String code) throws UnsupportedEncodingException{
		StringBuffer sb=new StringBuffer();
		String[] arr=param.split("&");
		for(int i=0;i<arr.length;i++){
			String[] arr2=arr[i].split("=");
			if(arr2.length>1){
				sb.append(arr2[0]);
				String a=URLEncoder.encode(arr2[1], code);
				sb.append("=");
				sb.append(a);
				if(i<arr.length-1){
					sb.append("&");
				}
			}		
		}
		return sb.toString();
	}
    
    public static String doPostSsl(String urlPath,Map<String,String> map){
		logger.debug("url:"+urlPath);
				SslUtil.trustAllHosts();
				String result="";
				StringBuffer sb=new StringBuffer();
				HttpURLConnection connection = null;
				try {
					URL url=new URL(urlPath);
		            if (url.getProtocol().toLowerCase().equals("https")) {  
		            	HttpsURLConnection httpConn = (HttpsURLConnection)url.openConnection();  
		            	httpConn.setHostnameVerifier(SslUtil.DO_NOT_VERIFY);  
		                connection = httpConn;  
		            } else {  
		            	connection = (HttpURLConnection)url.openConnection();  
		            }  
				    //设置参数
		            connection.setDoOutput(true);   //需要输出
		            connection.setDoInput(true);   //需要输入
		            connection.setUseCaches(false);  //不允许缓存
		            connection.setRequestMethod("POST");   //设置POST方式连接
				    //设置请求属性
		            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		            connection.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
		            connection.setRequestProperty("Charset", "UTF-8");
				    //连接,也可以不用明文connect，使用下面的httpConn.getOutputStream()会自动connect
		            
		            connection.connect();
				    //建立输入流，向指向的URL传入参数
		         // 创建参数队列  
		            String param=getParams("post",map);
				    DataOutputStream dos=new DataOutputStream(connection.getOutputStream());
				    dos.writeBytes(param);
				    dos.flush();
				    dos.close();
				    //获得响应状态
				    int resultCode=connection.getResponseCode();
				    if(HttpURLConnection.HTTP_OK==resultCode){
				      
				      String readLine=new String();
				      BufferedReader responseReader=new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
				      while((readLine=responseReader.readLine())!=null){
				        sb.append(readLine).append("\n");
				      }
				      result=sb.toString();
				      responseReader.close();
				    }
				} catch (Exception e) {
					logger.error("error:"+e.getMessage());
				}
				logger.debug("返回参数:"+result);
				return result;
		  }

		public static String getParams(String method,Map<String, String> paramValues)  
	    {  
	        String params="";  
	        Set<String> key = paramValues.keySet();  
	        String beginLetter="";  
	        if (method.equalsIgnoreCase("get"))  
	        {  
	            beginLetter="?";  
	        }  
	  
	        for (Iterator<String> it = key.iterator(); it.hasNext();) {  
	            String s = (String) it.next();  
	            if (params.equals(""))  
	            {  
	                params += beginLetter + s + "=" + paramValues.get(s);  
	            }  
	            else  
	            {  
	                params += "&" + s + "=" + paramValues.get(s);  
	            }  
	        }  
	        return params;  
	    }  
    
   
}