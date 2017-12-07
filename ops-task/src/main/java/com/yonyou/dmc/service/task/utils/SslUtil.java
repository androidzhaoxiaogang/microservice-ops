package com.yonyou.dmc.service.task.utils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

public class SslUtil {
	 public final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {  
		  
         public boolean verify(String hostname, SSLSession session) {  
             return true;  
         }  
     };  
	
	public static void trustAllHosts(){
		try {  
		TrustManager[] trustAllCerts = new TrustManager[] {new MyX509TrustManager()};
		
	        SSLContext sc = SSLContext.getInstance("TLS");  
	        sc.init(null, trustAllCerts, new java.security.SecureRandom());  
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	}
}
