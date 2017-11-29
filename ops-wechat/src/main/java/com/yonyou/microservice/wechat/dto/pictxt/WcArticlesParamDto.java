/*
* Copyright 2016 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
*
* This software is published under the terms of the YONYOU Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : marketing-common
*
* @File name : WcArticlesParamDto.java
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
	
package com.yonyou.microservice.wechat.dto.pictxt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
*
* @author sangdeliang
* @ description 图文消息DTO
* @date 2016年12月19日
*/

public class WcArticlesParamDto  implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -2261179275520498756L;
    /**
     * 图文对象 图文消息，一个图文消息支持1到8条图文 
     */
    private List<Article> articles = new ArrayList<Article>();

    /**
     * @return the articles
     */
    public List<Article> getArticles() {
        return articles;
    }

    /**
     * @param articles the articles to set
     */
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Article generateArticle() {
        return new Article();
    }
    
    public class Article  implements Serializable{
        /**
         * 
         */
        private static final long serialVersionUID = -4828174220376137513L;
        /**
         * 图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得 
         */
        @JsonProperty("thumb_media_id") 
        private String thumbMediaId;
        /**
         * 图文消息的作者 
         */
        private String author;
        /**
         * 图文消息的标题 
         */
        private String title;
        /**
         * 在图文消息页面点击“阅读原文”后的页面 
         */
        @JsonProperty("content_source_url") 
        private String contentSourceUrl;
        /**
         * 图文消息页面的内容，支持HTML标签。具备微信支付权限的公众号，可以使用a标签，其他公众号不能使用 
         */
        private String content;
        /**
         *      图文消息的描述 
         */
        private String digest;
        /**
         *  是否显示封面，1为显示，0为不显示 
         */
        @JsonProperty("show_cover_pic") 
        private int showCoverPic = 1;
        
        /**
         * @return the thumbMediaId
         */
        @JsonIgnore
        public String getThumbMediaId() {
            return thumbMediaId;
        }
        
        /**
         * @param thumbMediaId the thumbMediaId to set
         */
        @JsonIgnore
        public void setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
        }
        
        /**
         * @return the author
         */
        public String getAuthor() {
            return author;
        }
        
        /**
         * @param author the author to set
         */
        public void setAuthor(String author) {
            this.author = author;
        }
        
        /**
         * @return the title
         */
        public String getTitle() {
            return title;
        }
        
        /**
         * @param title the title to set
         */
        public void setTitle(String title) {
            this.title = title;
        }
        
        /**
         * @return the contentSourceUrl
         */
        @JsonIgnore
        public String getContentSourceUrl() {
            return contentSourceUrl;
        }
        
        /**
         * @param contentSourceUrl the contentSourceUrl to set
         */
        @JsonIgnore
        public void setContentSourceUrl(String contentSourceUrl) {
            this.contentSourceUrl = contentSourceUrl;
        }
        
        /**
         * @return the content
         */
        public String getContent() {
            return content;
        }
        
        /**
         * @param content the content to set
         */
        public void setContent(String content) {
            this.content = content;
        }
        
        /**
         * @return the digest
         */
        public String getDigest() {
            return digest;
        }
        
        /**
         * @param digest the digest to set
         */
        public void setDigest(String digest) {
            this.digest = digest;
        }
        
        /**
         * @return the showCoverPic
         */
        @JsonIgnore
        public int getShowCoverPic() {
            return showCoverPic;
        }
        
        /**
         * @param showCoverPic the showCoverPic to set
         */
        @JsonIgnore
        public void setShowCoverPic(int showCoverPic) {
            this.showCoverPic = showCoverPic;
        }
        
        
    }
}
