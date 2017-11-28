package com.yonyou.microservice.gate.admin.biz;

import org.springframework.stereotype.Service;

import com.yonyou.cloud.common.service.BaseService;
import com.yonyou.microservice.gate.admin.entity.Route;
import com.yonyou.microservice.gate.admin.mapper.RouteMapper;

/**
 * ${DESCRIPTION}
 *
 * @author joy
 * @create 2017-06-08 16:23
 */
@Service
public class RouteBiz extends BaseService<RouteMapper,Route> {

    @Override
    public void insertSelective(Route entity) {
        super.insertSelective(entity);
    }

    @Override
    public void updateSelectiveById(Route entity) {
        super.updateSelectiveById(entity);
    }



}
