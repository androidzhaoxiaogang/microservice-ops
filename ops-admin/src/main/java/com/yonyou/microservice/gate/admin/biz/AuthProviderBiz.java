package com.yonyou.microservice.gate.admin.biz;

import org.springframework.stereotype.Service;

import com.yonyou.cloud.common.service.BaseService;
import com.yonyou.microservice.gate.admin.entity.AuthProvider;
import com.yonyou.microservice.gate.admin.entity.Route;
import com.yonyou.microservice.gate.admin.mapper.AuthProviderMapper;

/**
 * ${DESCRIPTION}
 *
 * @author joy
 * @create 2017-06-08 16:23
 */
@Service
public class AuthProviderBiz extends BaseService<AuthProviderMapper,AuthProvider> {

    @Override
    public void insertSelective(AuthProvider entity) {
        super.insertSelective(entity);
    }

    @Override
    public void updateSelectiveById(AuthProvider entity) {
        super.updateSelectiveById(entity);
    }



}
