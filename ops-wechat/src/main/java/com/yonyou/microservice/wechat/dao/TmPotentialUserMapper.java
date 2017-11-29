package com.yonyou.microservice.wechat.dao;

import org.apache.ibatis.annotations.Param;

import com.yonyou.microservice.wechat.entity.TmPotentialUser;

import tk.mybatis.mapper.common.Mapper;

//@OracleDb
public interface TmPotentialUserMapper extends Mapper<TmPotentialUser> {
    
    TmPotentialUser queryUserOpenId(@Param("userId") String userId);
    
    
    
    TmPotentialUser queryUserOpenIdByOwnerId(@Param("userId") String userId);
    
}