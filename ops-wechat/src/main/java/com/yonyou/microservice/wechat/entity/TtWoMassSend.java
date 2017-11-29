package com.yonyou.microservice.wechat.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "TT_WO_MASS_SEND")
public class TtWoMassSend {
    @Column(name = "WO_MASS_SEND_ID")
    @GeneratedValue(generator = "JDBC")
    private Long woMassSendId;

    @Column(name = "OPEN_ID")
    private String openId;

    @Column(name = "AUTHORIZER_APPID")
    private String authorizerAppid;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "TITLE_IMAGE_URL")
    private String titleImageUrl;

    @Column(name = "WECHAT_TITLE_IMAGE_URL")
    private String wechatTitleImageUrl;

    @Column(name = "CONTENT_URL")
    private String contentUrl;

    @Column(name = "OBJECT_TYPE")
    private String objectType;

    @Column(name = "OBJECT_ID")
    private Long objectId;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "UPDATE_DATE")
    private Date updateDate;

    @Column(name = "MEDIA_ID")
    private String mediaId;

    @Column(name = "PICTXT_ID")
    private String picTxtId;

    @Column(name = "CONTENT")
    private String content;
    
    @Column(name = "CONTENT_SOURCE_URL")
    private String contentSourceUrl;
    
    /**
     * @return WO_MASS_SEND_ID
     */
    public Long getWoMassSendId() {
        return woMassSendId;
    }

    /**
     * @param woMassSendId
     */
    public void setWoMassSendId(Long woMassSendId) {
        this.woMassSendId = woMassSendId;
    }

    /**
     * @return OPEN_ID
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * @param openId
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * @return AUTHORIZER_APPID
     */
    public String getAuthorizerAppid() {
        return authorizerAppid;
    }

    /**
     * @param authorizerAppid
     */
    public void setAuthorizerAppid(String authorizerAppid) {
        this.authorizerAppid = authorizerAppid;
    }

    /**
     * @return TITLE
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return TITLE_IMAGE_URL
     */
    public String getTitleImageUrl() {
        return titleImageUrl;
    }

    /**
     * @param titleImageUrl
     */
    public void setTitleImageUrl(String titleImageUrl) {
        this.titleImageUrl = titleImageUrl;
    }

    /**
     * @return WECHAT_TITLE_IMAGE_URL
     */
    public String getWechatTitleImageUrl() {
        return wechatTitleImageUrl;
    }

    /**
     * @param wechatTitleImageUrl
     */
    public void setWechatTitleImageUrl(String wechatTitleImageUrl) {
        this.wechatTitleImageUrl = wechatTitleImageUrl;
    }

    /**
     * @return CONTENT_URL
     */
    public String getContentUrl() {
        return contentUrl;
    }

    /**
     * @param contentUrl
     */
    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    /**
     * @return OBJECT_TYPE
     */
    public String getObjectType() {
        return objectType;
    }

    /**
     * @param objectType
     */
    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    /**
     * @return OBJECT_ID
     */
    public Long getObjectId() {
        return objectId;
    }

    /**
     * @param objectId
     */
    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    /**
     * @return STATUS
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return CREATE_DATE
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return UPDATE_DATE
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getPicTxtId() {
		return picTxtId;
	}

	public void setPicTxtId(String picTxtId) {
		this.picTxtId = picTxtId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentSourceUrl() {
		return contentSourceUrl;
	}

	public void setContentSourceUrl(String contentSourceUrl) {
		this.contentSourceUrl = contentSourceUrl;
	}
    
}