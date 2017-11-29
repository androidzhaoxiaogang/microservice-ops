package com.yonyou.microservice.wechat.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "TM_POTENTIAL_USER")
public class TmPotentialUser {
    @Id
    @Column(name = "POTENTIAL_USER_ID")
    @GeneratedValue(generator = "JDBC")
    private Long potentialUserId;

    @Column(name = "DEVICE_OPEN_ID")
    private String deviceOpenId;

    @Column(name = "SUBSCRIBE_DATE")
    private Date subscribeDate;

    @Column(name = "APP_TYPE")
    private Short appType;

    @Column(name = "VERSION")
    private String version;

    @Column(name = "SOURCE_TYPE")
    private Integer sourceType;

    @Column(name = "SERVICE_TYPE")
    private String serviceType;

    @Column(name = "DEALER_CODE")
    private String dealerCode;

    @Column(name = "PACKAGE_CODE")
    private String packageCode;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "SEX")
    private String sex;

    @Column(name = "PROVINCE")
    private String province;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "HEAD_IMGURL")
    private String headImgurl;

    @Column(name = "AUTHORIZER_APPID")
    private String authorizerAppid;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "CREATE_BY")
    private Long createBy;

    @Column(name = "UPDATE_DATE")
    private Date updateDate;

    @Column(name = "UPDATE_BY")
    private Long updateBy;

    /**
     * @return POTENTIAL_USER_ID
     */
    public Long getPotentialUserId() {
        return potentialUserId;
    }

    /**
     * @param potentialUserId
     */
    public void setPotentialUserId(Long potentialUserId) {
        this.potentialUserId = potentialUserId;
    }

    /**
     * @return DEVICE_OPEN_ID
     */
    public String getDeviceOpenId() {
        return deviceOpenId;
    }

    /**
     * @param deviceOpenId
     */
    public void setDeviceOpenId(String deviceOpenId) {
        this.deviceOpenId = deviceOpenId;
    }

    /**
     * @return SUBSCRIBE_DATE
     */
    public Date getSubscribeDate() {
        return subscribeDate;
    }

    /**
     * @param subscribeDate
     */
    public void setSubscribeDate(Date subscribeDate) {
        this.subscribeDate = subscribeDate;
    }

    /**
     * @return APP_TYPE
     */
    public Short getAppType() {
        return appType;
    }

    /**
     * @param appType
     */
    public void setAppType(Short appType) {
        this.appType = appType;
    }

    /**
     * @return VERSION
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return SOURCE_TYPE
     */
    public Integer getSourceType() {
        return sourceType;
    }

    /**
     * @param sourceType
     */
    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    /**
     * @return SERVICE_TYPE
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * @param serviceType
     */
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    /**
     * @return DEALER_CODE
     */
    public String getDealerCode() {
        return dealerCode;
    }

    /**
     * @param dealerCode
     */
    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    /**
     * @return PACKAGE_CODE
     */
    public String getPackageCode() {
        return packageCode;
    }

    /**
     * @param packageCode
     */
    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    /**
     * @return STATUS
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return NICKNAME
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return SEX
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return PROVINCE
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return CITY
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return COUNTRY
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return HEAD_IMGURL
     */
    public String getHeadImgurl() {
        return headImgurl;
    }

    /**
     * @param headImgurl
     */
    public void setHeadImgurl(String headImgurl) {
        this.headImgurl = headImgurl;
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
     * @return CREATE_BY
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
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

    /**
     * @return UPDATE_BY
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * @param updateBy
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }
}