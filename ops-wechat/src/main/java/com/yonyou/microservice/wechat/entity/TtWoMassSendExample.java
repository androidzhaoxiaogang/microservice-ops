package com.yonyou.microservice.wechat.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TtWoMassSendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TtWoMassSendExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andWoMassSendIdIsNull() {
            addCriterion("WO_MASS_SEND_ID is null");
            return (Criteria) this;
        }

        public Criteria andWoMassSendIdIsNotNull() {
            addCriterion("WO_MASS_SEND_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWoMassSendIdEqualTo(Long value) {
            addCriterion("WO_MASS_SEND_ID =", value, "woMassSendId");
            return (Criteria) this;
        }

        public Criteria andWoMassSendIdNotEqualTo(Long value) {
            addCriterion("WO_MASS_SEND_ID <>", value, "woMassSendId");
            return (Criteria) this;
        }

        public Criteria andWoMassSendIdGreaterThan(Long value) {
            addCriterion("WO_MASS_SEND_ID >", value, "woMassSendId");
            return (Criteria) this;
        }

        public Criteria andWoMassSendIdGreaterThanOrEqualTo(Long value) {
            addCriterion("WO_MASS_SEND_ID >=", value, "woMassSendId");
            return (Criteria) this;
        }

        public Criteria andWoMassSendIdLessThan(Long value) {
            addCriterion("WO_MASS_SEND_ID <", value, "woMassSendId");
            return (Criteria) this;
        }

        public Criteria andWoMassSendIdLessThanOrEqualTo(Long value) {
            addCriterion("WO_MASS_SEND_ID <=", value, "woMassSendId");
            return (Criteria) this;
        }

        public Criteria andWoMassSendIdIn(List<Long> values) {
            addCriterion("WO_MASS_SEND_ID in", values, "woMassSendId");
            return (Criteria) this;
        }

        public Criteria andWoMassSendIdNotIn(List<Long> values) {
            addCriterion("WO_MASS_SEND_ID not in", values, "woMassSendId");
            return (Criteria) this;
        }

        public Criteria andWoMassSendIdBetween(Long value1, Long value2) {
            addCriterion("WO_MASS_SEND_ID between", value1, value2, "woMassSendId");
            return (Criteria) this;
        }

        public Criteria andWoMassSendIdNotBetween(Long value1, Long value2) {
            addCriterion("WO_MASS_SEND_ID not between", value1, value2, "woMassSendId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNull() {
            addCriterion("OPEN_ID is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("OPEN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("OPEN_ID =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("OPEN_ID <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("OPEN_ID >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("OPEN_ID >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("OPEN_ID <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("OPEN_ID <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("OPEN_ID like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("OPEN_ID not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("OPEN_ID in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("OPEN_ID not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("OPEN_ID between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("OPEN_ID not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidIsNull() {
            addCriterion("AUTHORIZER_APPID is null");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidIsNotNull() {
            addCriterion("AUTHORIZER_APPID is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidEqualTo(String value) {
            addCriterion("AUTHORIZER_APPID =", value, "authorizerAppid");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidNotEqualTo(String value) {
            addCriterion("AUTHORIZER_APPID <>", value, "authorizerAppid");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidGreaterThan(String value) {
            addCriterion("AUTHORIZER_APPID >", value, "authorizerAppid");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidGreaterThanOrEqualTo(String value) {
            addCriterion("AUTHORIZER_APPID >=", value, "authorizerAppid");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidLessThan(String value) {
            addCriterion("AUTHORIZER_APPID <", value, "authorizerAppid");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidLessThanOrEqualTo(String value) {
            addCriterion("AUTHORIZER_APPID <=", value, "authorizerAppid");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidLike(String value) {
            addCriterion("AUTHORIZER_APPID like", value, "authorizerAppid");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidNotLike(String value) {
            addCriterion("AUTHORIZER_APPID not like", value, "authorizerAppid");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidIn(List<String> values) {
            addCriterion("AUTHORIZER_APPID in", values, "authorizerAppid");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidNotIn(List<String> values) {
            addCriterion("AUTHORIZER_APPID not in", values, "authorizerAppid");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidBetween(String value1, String value2) {
            addCriterion("AUTHORIZER_APPID between", value1, value2, "authorizerAppid");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidNotBetween(String value1, String value2) {
            addCriterion("AUTHORIZER_APPID not between", value1, value2, "authorizerAppid");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleImageUrlIsNull() {
            addCriterion("TITLE_IMAGE_URL is null");
            return (Criteria) this;
        }

        public Criteria andTitleImageUrlIsNotNull() {
            addCriterion("TITLE_IMAGE_URL is not null");
            return (Criteria) this;
        }

        public Criteria andTitleImageUrlEqualTo(String value) {
            addCriterion("TITLE_IMAGE_URL =", value, "titleImageUrl");
            return (Criteria) this;
        }

        public Criteria andTitleImageUrlNotEqualTo(String value) {
            addCriterion("TITLE_IMAGE_URL <>", value, "titleImageUrl");
            return (Criteria) this;
        }

        public Criteria andTitleImageUrlGreaterThan(String value) {
            addCriterion("TITLE_IMAGE_URL >", value, "titleImageUrl");
            return (Criteria) this;
        }

        public Criteria andTitleImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE_IMAGE_URL >=", value, "titleImageUrl");
            return (Criteria) this;
        }

        public Criteria andTitleImageUrlLessThan(String value) {
            addCriterion("TITLE_IMAGE_URL <", value, "titleImageUrl");
            return (Criteria) this;
        }

        public Criteria andTitleImageUrlLessThanOrEqualTo(String value) {
            addCriterion("TITLE_IMAGE_URL <=", value, "titleImageUrl");
            return (Criteria) this;
        }

        public Criteria andTitleImageUrlLike(String value) {
            addCriterion("TITLE_IMAGE_URL like", value, "titleImageUrl");
            return (Criteria) this;
        }

        public Criteria andTitleImageUrlNotLike(String value) {
            addCriterion("TITLE_IMAGE_URL not like", value, "titleImageUrl");
            return (Criteria) this;
        }

        public Criteria andTitleImageUrlIn(List<String> values) {
            addCriterion("TITLE_IMAGE_URL in", values, "titleImageUrl");
            return (Criteria) this;
        }

        public Criteria andTitleImageUrlNotIn(List<String> values) {
            addCriterion("TITLE_IMAGE_URL not in", values, "titleImageUrl");
            return (Criteria) this;
        }

        public Criteria andTitleImageUrlBetween(String value1, String value2) {
            addCriterion("TITLE_IMAGE_URL between", value1, value2, "titleImageUrl");
            return (Criteria) this;
        }

        public Criteria andTitleImageUrlNotBetween(String value1, String value2) {
            addCriterion("TITLE_IMAGE_URL not between", value1, value2, "titleImageUrl");
            return (Criteria) this;
        }

        public Criteria andWechatTitleImageUrlIsNull() {
            addCriterion("WECHAT_TITLE_IMAGE_URL is null");
            return (Criteria) this;
        }

        public Criteria andWechatTitleImageUrlIsNotNull() {
            addCriterion("WECHAT_TITLE_IMAGE_URL is not null");
            return (Criteria) this;
        }

        public Criteria andWechatTitleImageUrlEqualTo(String value) {
            addCriterion("WECHAT_TITLE_IMAGE_URL =", value, "wechatTitleImageUrl");
            return (Criteria) this;
        }

        public Criteria andWechatTitleImageUrlNotEqualTo(String value) {
            addCriterion("WECHAT_TITLE_IMAGE_URL <>", value, "wechatTitleImageUrl");
            return (Criteria) this;
        }

        public Criteria andWechatTitleImageUrlGreaterThan(String value) {
            addCriterion("WECHAT_TITLE_IMAGE_URL >", value, "wechatTitleImageUrl");
            return (Criteria) this;
        }

        public Criteria andWechatTitleImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("WECHAT_TITLE_IMAGE_URL >=", value, "wechatTitleImageUrl");
            return (Criteria) this;
        }

        public Criteria andWechatTitleImageUrlLessThan(String value) {
            addCriterion("WECHAT_TITLE_IMAGE_URL <", value, "wechatTitleImageUrl");
            return (Criteria) this;
        }

        public Criteria andWechatTitleImageUrlLessThanOrEqualTo(String value) {
            addCriterion("WECHAT_TITLE_IMAGE_URL <=", value, "wechatTitleImageUrl");
            return (Criteria) this;
        }

        public Criteria andWechatTitleImageUrlLike(String value) {
            addCriterion("WECHAT_TITLE_IMAGE_URL like", value, "wechatTitleImageUrl");
            return (Criteria) this;
        }

        public Criteria andWechatTitleImageUrlNotLike(String value) {
            addCriterion("WECHAT_TITLE_IMAGE_URL not like", value, "wechatTitleImageUrl");
            return (Criteria) this;
        }

        public Criteria andWechatTitleImageUrlIn(List<String> values) {
            addCriterion("WECHAT_TITLE_IMAGE_URL in", values, "wechatTitleImageUrl");
            return (Criteria) this;
        }

        public Criteria andWechatTitleImageUrlNotIn(List<String> values) {
            addCriterion("WECHAT_TITLE_IMAGE_URL not in", values, "wechatTitleImageUrl");
            return (Criteria) this;
        }

        public Criteria andWechatTitleImageUrlBetween(String value1, String value2) {
            addCriterion("WECHAT_TITLE_IMAGE_URL between", value1, value2, "wechatTitleImageUrl");
            return (Criteria) this;
        }

        public Criteria andWechatTitleImageUrlNotBetween(String value1, String value2) {
            addCriterion("WECHAT_TITLE_IMAGE_URL not between", value1, value2, "wechatTitleImageUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlIsNull() {
            addCriterion("CONTENT_URL is null");
            return (Criteria) this;
        }

        public Criteria andContentUrlIsNotNull() {
            addCriterion("CONTENT_URL is not null");
            return (Criteria) this;
        }

        public Criteria andContentUrlEqualTo(String value) {
            addCriterion("CONTENT_URL =", value, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlNotEqualTo(String value) {
            addCriterion("CONTENT_URL <>", value, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlGreaterThan(String value) {
            addCriterion("CONTENT_URL >", value, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlGreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT_URL >=", value, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlLessThan(String value) {
            addCriterion("CONTENT_URL <", value, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlLessThanOrEqualTo(String value) {
            addCriterion("CONTENT_URL <=", value, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlLike(String value) {
            addCriterion("CONTENT_URL like", value, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlNotLike(String value) {
            addCriterion("CONTENT_URL not like", value, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlIn(List<String> values) {
            addCriterion("CONTENT_URL in", values, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlNotIn(List<String> values) {
            addCriterion("CONTENT_URL not in", values, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlBetween(String value1, String value2) {
            addCriterion("CONTENT_URL between", value1, value2, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlNotBetween(String value1, String value2) {
            addCriterion("CONTENT_URL not between", value1, value2, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andObjectTypeIsNull() {
            addCriterion("OBJECT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andObjectTypeIsNotNull() {
            addCriterion("OBJECT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andObjectTypeEqualTo(String value) {
            addCriterion("OBJECT_TYPE =", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotEqualTo(String value) {
            addCriterion("OBJECT_TYPE <>", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeGreaterThan(String value) {
            addCriterion("OBJECT_TYPE >", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("OBJECT_TYPE >=", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeLessThan(String value) {
            addCriterion("OBJECT_TYPE <", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeLessThanOrEqualTo(String value) {
            addCriterion("OBJECT_TYPE <=", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeLike(String value) {
            addCriterion("OBJECT_TYPE like", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotLike(String value) {
            addCriterion("OBJECT_TYPE not like", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeIn(List<String> values) {
            addCriterion("OBJECT_TYPE in", values, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotIn(List<String> values) {
            addCriterion("OBJECT_TYPE not in", values, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeBetween(String value1, String value2) {
            addCriterion("OBJECT_TYPE between", value1, value2, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotBetween(String value1, String value2) {
            addCriterion("OBJECT_TYPE not between", value1, value2, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectIdIsNull() {
            addCriterion("OBJECT_ID is null");
            return (Criteria) this;
        }

        public Criteria andObjectIdIsNotNull() {
            addCriterion("OBJECT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andObjectIdEqualTo(Long value) {
            addCriterion("OBJECT_ID =", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotEqualTo(Long value) {
            addCriterion("OBJECT_ID <>", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdGreaterThan(Long value) {
            addCriterion("OBJECT_ID >", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("OBJECT_ID >=", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLessThan(Long value) {
            addCriterion("OBJECT_ID <", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLessThanOrEqualTo(Long value) {
            addCriterion("OBJECT_ID <=", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdIn(List<Long> values) {
            addCriterion("OBJECT_ID in", values, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotIn(List<Long> values) {
            addCriterion("OBJECT_ID not in", values, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdBetween(Long value1, Long value2) {
            addCriterion("OBJECT_ID between", value1, value2, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotBetween(Long value1, Long value2) {
            addCriterion("OBJECT_ID not between", value1, value2, "objectId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("UPDATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("UPDATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("UPDATE_DATE =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("UPDATE_DATE <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("UPDATE_DATE >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATE >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("UPDATE_DATE <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATE <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("UPDATE_DATE in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("UPDATE_DATE not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATE between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATE not between", value1, value2, "updateDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}