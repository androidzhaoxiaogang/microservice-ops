package com.yonyou.microservice.gate.admin.biz;

import org.springframework.stereotype.Service;

import com.yonyou.cloud.common.service.BaseService;
import com.yonyou.microservice.gate.admin.entity.AuthProvider;
import com.yonyou.microservice.gate.admin.entity.IgnoreUri;
import com.yonyou.microservice.gate.admin.mapper.IgnoreUriMapper;

/**
 * ${DESCRIPTION}
 *
 * @author joy
 * @create 2017-06-08 16:23
 */
@Service
public class IgnoreUriBiz extends BaseService<IgnoreUriMapper,IgnoreUri> {

    @Override
    public void insertSelective(IgnoreUri entity) {
        super.insertSelective(entity);
    }

    @Override
    public void updateSelectiveById(IgnoreUri entity) {
        super.updateSelectiveById(entity);
    }



}
