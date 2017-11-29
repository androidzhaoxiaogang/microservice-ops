///*
//* Copyright 2017 Yonyou Auto Information Technology（Shanghai） Co., Ltd. All Rights Reserved.
//*
//* This software is published under the terms of the YONYOU Software
//* License version 1.0, a copy of which has been included with this
//* distribution in the LICENSE.txt file.
//*
//* @Project Name : marketing-service-dealer
//*
//* @File name : DealerWoTemplateService.java
//*
//* @Author : LiuJun
//*
//* @Date : 2017年1月12日
//*
//----------------------------------------------------------------------------------
//*     Date       Who       Version     Comments
//* 1. 2017年1月12日    LiuJun    1.0
//*
//*
//*
//*
//----------------------------------------------------------------------------------
//*/
//	
//package com.yonyou.microservice.wechat.service;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.yonyou.dmc.common.exception.ServiceAppException;
//import com.yonyou.dmc.common.exception.ServiceBizException;
//import com.yonyou.microservice.wechat.common.BusinessConstant;
//import com.yonyou.microservice.wechat.dao.DealerWoTemplateDao;
//import com.yonyou.microservice.wechat.entity.DealerWoTemplate;
//
///**
//*
//* @author LiuJun
//* 经销商公众号消息模板Service
//* @date 2017年1月12日
//*/
//@Service
//public class WechatLocalTemplateService {
//    
//    private static Logger logger = Logger.getLogger(WechatLocalTemplateService.class);
//
//    
//    @Autowired
//    private DealerWoTemplateDao dealerWoTemplateDao;
//
//    /**
//    *
//    * @author LiuJun
//    * 保存公账号消息模板
//    * @date 2017年1月12日
//    * @param templateDtoList
//    * @param authorizerAppid
//    * @throws ServiceAppException
//    * @throws ServiceBizException
//    */
////    public void saveDealerWoTemplates(List<DealerWoTemplateDto> templateDtoList,String authorizerAppid) throws ServiceAppException,
////                                                                                 ServiceBizException {
////        if(CommonUtils.isNullOrEmpty(templateDtoList)){
////            throw new ServiceBizException("the params of templateDtoList is empty");
////        }
////        try {
////            Calendar calendar = Calendar.getInstance();
////            calendar.setTime(new Date());
////            DealerWoTemplatePO dealerWoTemplatePO = null;
////            long deleteCount = dealerWoTemplateDao.deleteDealerWoTemplateByAuthorizerAppid(authorizerAppid);
////            logger.info("saveDealerWoTemplates-deleteCount="+deleteCount);
////
////            for(DealerWoTemplateDto templateDto:templateDtoList){
////                dealerWoTemplatePO = new DealerWoTemplatePO();
////                BeanUtils.copyProperties(templateDto, dealerWoTemplatePO);
////                dealerWoTemplatePO.setCreateDate(calendar.getTime());
////                dealerWoTemplateDao.insertDealerWoTemplate(dealerWoTemplatePO);
////            }
////
////            logger.info("saveDealerWoTemplates is success");
////        } catch (Exception e) {
////            logger.error(e.getMessage(), e);
////            throw new ServiceAppException(e.getMessage(), e);
////        }
//
////    }
//
//    /**
//    *
//    * @author LiuJun
//    * 获取模板ID
//    * @date 2017年1月12日
//    * @param authorizerAppid
//    * @param templateNum
//    * @return
//    * @throws ServiceAppException
//    * @throws ServiceBizException
//    */
//    public String getDealerWoTemplateId(String authorizerAppid, String templateNum) throws ServiceAppException,
//    ServiceBizException {
//        try{
//            DealerWoTemplate dealerWoTemplatePO = dealerWoTemplateDao.queryDealerWoTemplateByAuthIdAndTemNum(authorizerAppid,templateNum);
//            if(dealerWoTemplatePO!=null){
//                return dealerWoTemplatePO.getTemplateId();
//            }
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//            throw new ServiceAppException(e.getMessage(), e);
//        }
////    	if(templateNum.equals("TM00628"))
////    		return "O7bNaceVzh3IBfcSEU4qT4uS5XvzoGZtvAJ2VPJGTNQ";
////    	if(templateNum.equals("TM00629"))
////    		return "qdMPCtrVxZe6_Lg7t2u9D6d__K6wXI9sr_8MAOiq5Nc";
////    	if(templateNum.equals("TM00627"))
////    		return "5iV78Jsh1V3BOHoDhc-fLRgPg0IXccpFZTfwwP9VT2A";
////    	if(templateNum.equals("TM00630"))
////    		return "GiL3Bgu28AG3zSV5bprigEpJFBuJosb6cWvOVhiSoKE";
//        return BusinessConstant.EMPTY_STRING;
//    }
//
//}
