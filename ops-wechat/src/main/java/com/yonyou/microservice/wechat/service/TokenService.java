package com.yonyou.microservice.wechat.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xiaoleilu.hutool.http.HttpUtil;
import com.yonyou.microservice.wechat.common.WechatDict;
import com.yonyou.microservice.wechat.entity.AccessToken;
import com.yonyou.microservice.wechat.util.EncoderHandler;

import net.sf.json.JSONObject;

@Service
public class TokenService {

	private Logger logger=Logger.getLogger(TokenService.class);
	/**
	 * 根据微信传递过来的code获取openid
	 */
	public String getOpenidByCode( String code){
		if (code!=null) {
			String getPpenIdUrl = getOpenIdRequestUrl(code);
			String sendGetResponse = HttpUtil.get(getPpenIdUrl);
			JSONObject fromObject = JSONObject.fromObject(sendGetResponse);
			String openid = (String) fromObject.get("openid");
			logger.info("------------call getOpenidByCode,url="+getPpenIdUrl);
			logger.info("------------call getOpenidByCode,openid="+fromObject.toString());
			return openid;
		}
		return "";
	}

	/**
	 * 读取token
	 */
	//@Cacheable(value = "wechatAccessToken",key="#wechatAccessToken + 'wechatAccessToken'")//,keyGenerator = "wechatAccessTokenGenerator"
	public String getAccessToken(){
		logger.info("----------------get wechatAccessToken");
		String tmp=AccessToken.getAccessToken();
		if(tmp==null || "".equals(tmp)){
			tmp=genAccessToken();
		}
		return tmp;
	}
	/**
	 * 产生token，存入缓存
	 */
	//@CachePut(value = "wechatAccessToken",key="#wechatAccessToken + 'wechatAccessToken'")//,keyGenerator = "wechatKeyGenerator"
	public String genAccessToken() {
		logger.info("----------------gen wechatAccessToken");
		String appid = WechatDict.appid;
		String secret = WechatDict.appsecret;
		if (StringUtils.isEmpty(appid) || StringUtils.isEmpty(secret))
			return "";
		String reqUrl = WechatDict.getAccessTokenUrl;
		reqUrl = reqUrl.replace("APPID", appid).replace("APPSECRET", secret);
		System.out.println(reqUrl);
		
		String sendGetRequest = HttpUtil.get(reqUrl);
		JSONObject fromObject = JSONObject.fromObject(sendGetRequest);
		AccessToken.setAccessToken(fromObject.get("access_token")
				.toString());
		AccessToken.setExpiresIn(fromObject.get("expires_in")
				.toString());
		//reqUrl = WechatDict.getticketUrl;
		//reqUrl = reqUrl.replace("ACCESS_TOKEN", AccessToken.getAccessToken());
        //sendGetRequest = HttpClientUtil.sendGetRequest(reqUrl); 
        //fromObject = JSONObject.fromObject(sendGetRequest);
        //AccessToken.setTicket(fromObject.get("ticket").toString());
        return AccessToken.getAccessToken();
        
	}
	
	/**
	 * jssdk签名
	 * @param url
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	public Map<String, Object> sign(String url) throws Exception {
        Map<String, Object> ret = new HashMap<String, Object>();
        String jsapi_ticket = AccessToken.getTicket();
        String nonce_str = UUID.randomUUID().toString();
        String timestamp = System.currentTimeMillis() / 1000 + "";
        String bigStr;
        String signature = "";
        // 注意这里参数名必须全部小写，且必须有序
        bigStr = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonce_str + "&timestamp=" + timestamp + "&url=" + url;
        System.out.println(bigStr);
        signature = EncoderHandler.encode("SHA1", bigStr).toLowerCase();
        System.out.println(signature);
        ret.put("appId", WechatDict.appid);
        ret.put("url", url);
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);
        return ret;
    }


	/**
	 * 获取网页授权code的url
	 * @return
	 */
	public static String getCodeRequestUrl(String url) {
		String getCodeUrl = WechatDict.getCodeUrl;
		getCodeUrl = getCodeUrl.replace("APPID", urlEnodeUTF8(WechatDict.appid));
		getCodeUrl = getCodeUrl.replace("REDIRECT_URI", urlEnodeUTF8(url));
		getCodeUrl = getCodeUrl.replace("SCOPE", "snsapi_base");
		return getCodeUrl;
	}
	
	/**
	 * 得到根据授权的code获取openid的url
	 * @param code
	 * @return
	 */
	public static String getOpenIdRequestUrl(String code) {
		String url = WechatDict.getOpenIdUrl;
		url = url.replace("APPID", WechatDict.appid);
		url = url.replace("SECRET", WechatDict.appsecret);
		url = url.replace("CODE", code);
		return url;
	}
	
	/**
	 * 刷新网页授权的access_token
	 * @return
	 */
	public static String getRefreshTokenRequestUrl(String refreshToken) {
		String url = WechatDict.getRefreshTokenUrl;
		url = url.replace("APPID", WechatDict.appid);
		url = url.replace("SECRET", WechatDict.appsecret);
		url = url.replace("REFRESH_TOKEN", refreshToken);
		return url;
	}

	public static String urlEnodeUTF8(String str) {
		String result = str;
		try {
			result = URLEncoder.encode(str, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
