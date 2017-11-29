/*
* Copyright 2016 YONYOU Corporation Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project         marketing

* @Package         com.yonyou.marketing.message.push.entrance

* @Author          LuZhen

* @FileName        PushEntranceConstant

* @Date            16/11/3

----------------------------------------------------------------------------------
*     Date          Who             Version         Comments
* 1. 16/11/3        LuZhen          1.0             Create Source
*
----------------------------------------------------------------------------------
*/
package com.yonyou.microservice.wechat.common;

public class MessagePushConstant {

    //public static final String FACTORY="MESSAGE.FACTORY";

    public static final String QUEUE="MESSAGE.PUSH";

    public static final String QUEUE_TEST="MESSAGE.PUSH.TEST";

    public static final String WECHAT_QUEUE="WECHAT.PUSH";

    public static final String WECHAT_QUEUE_TEST="WECHAT.PUSH.TEST";

    public static final String PROVIDER_DEMO="0";

    public static final String PROVIDER_APP="1";

    public static final String PROVIDER_WEBCHAT="2";

    public static final String PROVIDER_SMS="3";

    public static final String PROVIDER_POOL="providerPool";

    public static final String PROVIDER_THREAD="PUSH-THREAD";

    public static final String PROVIDER_THREAD_CALLBACK="PUSH-THREAD-CALLBACK";

    public static final String IOS="IOS";

    public static final String CUSTOMER="CUSTOMER";

    public static final String PUBLIC="PUBLIC";

    public static final String ANDROID="ANDROID";

    public static final String ALL ="ALL";

    public static final String DEMO ="TEST";

    public static final String WX_MSG_PROP_THUMB="MEDIA_THUMB_ID";//缩略图 视频、音乐

    public static final String WX_MSG_PROP_DESC="DESCRIPTION";//描述信息 视频、音乐、

    public static final String WX_MSG_PROP_URL="URL";//公众号模板url

    public static final String WX_MSG_PROP_COLOR="COLOR";//公众号模板颜色

    public static final String IOS_MESSAGE_ENCODE = "utf-8";

    public static final Integer IOS_MESSAGE_LENGTH_MAX = 1800;

    public static final Integer MESSAGE_MAX_RETRY_TIMES =3;


    //public static final String PROVIDER_POOL_PATH="classpath:pool.properties";


    //消息类型 涵盖了app与webchat的各种类型
    public enum MESSAGE_CONTENT_TYPE {
        TEXT(0),IMAGE(1),VOICE(2),VIDEO(3),NEWS(4);

        private final Integer type;

        MESSAGE_CONTENT_TYPE(Integer type) {
            this.type = type;
        }

        public String toString() {
            return type.toString();
        }
    }



    //推送渠道
    public enum PUSH_CHANNEL {

        APP(PROVIDER_APP),WEBCHAT(PROVIDER_WEBCHAT),SMS(PROVIDER_SMS), TEST(PROVIDER_DEMO);

        private final String type;

        PUSH_CHANNEL(String type) {
            this.type = type;
        }

        public String toString() {
            return type;
        }
    }

    //APP平台
    public enum PUSH_PLATFORM {

        APP_IOS(IOS),APP_ANDROID(ANDROID),APP_ALL(ALL),WC_CUSTOMER(CUSTOMER),WC_PUBLIC(PUBLIC),TEST(DEMO);

        private final String type;

        PUSH_PLATFORM(String type) {
            this.type = type;
        }

        public String toString() {
            return type;
        }
    }

    public enum RECEIVER_TYPE {

        DETAIL(0),GROUP(1),ALL(2);

        private final Integer type;

        RECEIVER_TYPE(Integer type) {
            this.type = type;
        }

        public String toString() {
            return type.toString();
        }
    }

}
