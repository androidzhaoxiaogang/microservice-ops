package com.yonyou.microservice.wechat.util;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.yonyou.microservice.wechat.common.CookieConstant;


public class CookieUtil {
	private static Logger logger=Logger.getLogger(CookieUtil.class);

	public static void writeOpenid(String value, HttpServletResponse response){
		String oxid=value+",,"+new Date().toString();
		try {
			reponseCookies(CookieConstant.WECHAT_COOKIE_OPENID,
					oxid,
			    	    response);
		} catch (Exception e) {
			logger.info("---存储cookie openid出错："+e.getMessage());
			e.printStackTrace();
		}
	}
	public static String getOpenid(HttpServletRequest request){
		String value="";
		try {
			value = getCookiesByKey(request,CookieConstant.WECHAT_COOKIE_OPENID);
			int i=value.indexOf(",,");
			if(i>=0){
		    	return value.substring(0, i);
			}else{
				return value;
			}
		} catch (Exception e) {
			logger.info("---取得cookie中的openid出错："+value+","+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

    private static void reponseCookies(String key, String value, HttpServletResponse response) throws Exception {
        Cookie cookies = new Cookie(key,CookieSecurityUtil.encrypt(value));
		cookies.setMaxAge(6*60*60);//6小时有效期
        cookies.setPath("/");
        response.addCookie(cookies);
    }

    private static String getCookiesByKey(HttpServletRequest request,String key) throws Exception {
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                if(key.equals(cookie.getName())) {
                     return CookieSecurityUtil.decrypt(cookie.getValue());
                }
            }
        }
        return null;
    }
}
