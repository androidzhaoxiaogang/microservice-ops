///*
//* Copyright 2016 YONYOU Corporation Ltd. All Rights Reserved.
//*
//* This software is published under the terms of the YONYOU Software
//* License version 1.0, a copy of which has been included with this
//* distribution in the LICENSE.txt file.
//*
//* @Project         marketing
//
//* @Package         com.yonyou.marketing.message.push.common
//
//* @Author          LuZhen
//
//* @FileName        PushCommonUtils
//
//* @Date            16/11/9
//
//----------------------------------------------------------------------------------
//*     Date          Who             Version         Comments
//* 1. 16/11/9        LuZhen          1.0             Create Source
//*
//----------------------------------------------------------------------------------
//*/
//package com.yonyou.microservice.wechat.util;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//
//public class PushCommonUtils {
//
//    /**
//     * 判断string是否为空
//     * @param str   str
//     * @return boolean
//     */
//    public static boolean isNull(String str){
//        return str==null||str.equals("");
//    }
//
//    /**
//     * 判断list是否为空
//     * @param list  list
//     * @return boolean
//     */
//    public static boolean isNull(List<?> list){
//        return list==null||list.isEmpty();
//    }
//
//    /**
//     * 判断map是否为空
//     * @param map  map
//     * @return boolean
//     */
//    public static boolean isNull(Map<?,?>  map){
//        return map==null||map.isEmpty();
//    }
//
//    /**
//     * 获取主机名称
//     * @return  string
//     */
//    public static String getHostName(){
//        try {
//            return InetAddress.getLocalHost().getHostName();
//        } catch (UnknownHostException e) {
//            return "";
//        }
//    }
//
//    /**
//     * 获取UUID
//     * @return  String
//     *
//     */
//    public static String getUUID(){
//        return UUID.randomUUID().toString();
//    }
//
//}
