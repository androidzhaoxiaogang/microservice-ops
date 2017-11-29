/*
* Copyright 2016 Yonyou Auto Information Technology（Shanghai） Co. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : marketing-wechat-open-api
*
* @File name : WechatMessageHandleUtils.java
*
* @Author : LiuJun
*
* @Date : 2016年10月20日
*
----------------------------------------------------------------------------------
*     Date       Who       Version     Comments
* 1. 2016年10月20日    LiuJun    1.0
*
*
*
*
----------------------------------------------------------------------------------
*/

package com.yonyou.microservice.wechat.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import com.xiaoleilu.hutool.exceptions.UtilException;
import com.yonyou.microservice.wechat.common.WechatDict;


/*
*
* @author LiuJun
* 微信消息处理工具类
* @date 2016年10月20日
*/
public class WechatMessageHandleUtils {
    

    /*
     * @author LiuJun 将接收微信消息转化为map
     * @date 2016年10月20日
     * @param request
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> reqMsgToMap(HttpServletRequest request) throws UtilException {
        String xml = parseMsgToXml(request);
        try {
            Map<String, String> maps = new HashMap<>();
            Document document = DocumentHelper.parseText(xml);
            Element root = document.getRootElement();
            List<Element> eles = root.elements();
            for (Element e : eles) {
                maps.put(e.getName(), e.getTextTrim());
            }
            return maps;
        } catch (Exception e) {
            throw new UtilException(e.getMessage(), e);
        }
    }
    
    
    /**
    *
    * @author LiuJun
    * xml转map
    * @date 2016年12月6日
    * @param xml
    * @return
    * @throws UtilException
    */
    @SuppressWarnings("unchecked")
    public static Map<String, String> xmlToMap(String xml) throws UtilException {
        try {
            Map<String, String> maps = new HashMap<>();
            Document document = DocumentHelper.parseText(xml);
            Element root = document.getRootElement();
            List<Element> eles = root.elements();
            for (Element e : eles) {
                maps.put(e.getName(), e.getTextTrim());
            }
            return maps;
        } catch (Exception e) {
            throw new UtilException(e.getMessage(), e);
        }
    }

    /*
     * @author LiuJun map转xml
     * @date 2016年10月20日
     * @param map
     * @return
     * @throws UtilException
     */
    public static String mapToXml(Map<String, Object> map) throws UtilException, IOException {
        XMLWriter xw = null;
        StringWriter sw = null;
        try {
            Document d = DocumentHelper.createDocument();
            Element root = d.addElement("xml");
            Set<String> keys = map.keySet();
            for (String key : keys) {
                Object o = map.get(key);
                if (o instanceof String) {
                    String t = (String) o;
                    root.addElement(key).addCDATA(t);
                }
            }
            sw = new StringWriter();
            xw = new XMLWriter(sw);
            xw.setEscapeText(false);
            xw.write(d);
            return sw.toString();

        } catch (Exception e) {
            throw new UtilException(e.getMessage(), e);
        }finally {
            
            if(xw!=null){
            	xw.close();
            }
            if(sw!=null){
            	sw.close();
            }
        }

    }
    
    
    /**
    *
    * @author LiuJun
    * 图文消息map转xml
    * @date 2016年12月26日
    * @param map
    * @return
    * @throws UtilException
     * @throws IOException 
    */
    public static String imageTextMapToXml(Map<String, Object> map) throws UtilException, IOException {
        XMLWriter xw = null;
        StringWriter sw = null;
        try {
            Document d = DocumentHelper.createDocument();
            Element root = d.addElement("xml");
            Set<String> keys = map.keySet();
            for (String key : keys) {
                Object o = map.get(key);
                if (o instanceof String) {
                    String val = (String) o;
                    if(WechatDict.XML_HEADING_NO_CONTENT.equals(val)){
                        root.addElement(key);
                    }else{
                        root.addElement(key).addCDATA(val);
                    }
                }
            }
            sw = new StringWriter();
            xw = new XMLWriter(sw);
            xw.setEscapeText(false);
            xw.write(d);
            return sw.toString();

        } catch (Exception e) {
            throw new UtilException(e.getMessage(), e);
        }finally {
            
        	if(xw!=null){
            	xw.close();
            }
            if(sw!=null){
            	sw.close();
            }
        }

    }


    /*
     * @author LiuJun 消息解xmlTODO 
     * @date 2016年10月20日
     * @param request
     * @return
     * @throws UtilException
     */
    private static String parseMsgToXml(HttpServletRequest request) throws UtilException {
        try {
        	InputStreamReader is = new InputStreamReader(request.getInputStream());
            BufferedReader br = new BufferedReader(is);
            String str = null;
            StringBuffer sb = new StringBuffer();
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            br.close();
            is.close();
            return sb.toString();
        } catch (Exception e) {
            throw new UtilException(e.getMessage(), e);
        }

    }

    /*
    *
    * @author LiuJun
    * 回复文本消息
    * @date 2016年10月20日
    * @param msgMap
    * @param content
    * @return
    * @throws UtilException
    */
    public static Map<String, Object> replyTextMsg(Map<String, String> msgMap, String content) throws UtilException {
        Map<String, Object> tm = new HashMap<String, Object>();
        tm.put(WechatDict.MSG_STRUCT_TOUSERNAME, msgMap.get(WechatDict.MSG_STRUCT_FROMUSERNAME));
        tm.put(WechatDict.MSG_STRUCT_FROMUSERNAME, msgMap.get(WechatDict.MSG_STRUCT_TOUSERNAME));
        tm.put(WechatDict.MSG_STRUCT_CREATETIME, System.currentTimeMillis() + "");
        tm.put(WechatDict.MSG_STRUCT_MSGTYPE, WechatDict.MSG_STRUCT_MSGTYPE_TEXT);
        tm.put(WechatDict.MSG_STRUCT_CONTENT, content);
        return tm;
    }
    
    
    /*
    *
    * @author LiuJun
    * 回复语音消息
    * @date 2016年10月20日
    * @param msgMap
    * @param mediaId
    * @return
    * @throws UtilException
    */
    public static Map<String, Object> replyVoiceMsg(Map<String, String> msgMap, String mediaId) throws UtilException {
        Map<String, Object> tm = new HashMap<String, Object>();
        return tm;
    }

}
