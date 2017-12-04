package com.youyou.microservice.auth.server.mapper;

import java.util.List;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.youyou.microservice.auth.server.entity.AuthProvider;

import tk.mybatis.mapper.common.Mapper;

public interface AuthProviderMapper extends Mapper<AuthProvider> {

    @Select(" SELECT\n" +
            "        id,src_url as srcUrl,auth_service as authService,accept_type as acceptType \n" +
            "      FROM\n" +
            "          gate_auth_provider\n" )
    @ResultType(AuthProvider.class)
    List<AuthProvider> selectAuthProviders();

}