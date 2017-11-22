package com.yonyou.microservice.gate.admin.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonyou.microservice.auth.client.jwt.UserAuthUtil;
import com.yonyou.microservice.gate.admin.entity.Route;
import com.yonyou.microservice.gate.admin.mapper.MenuMapper;
import com.yonyou.microservice.gate.admin.mapper.RouteMapper;
import com.yonyou.microservice.gate.common.biz.BaseBiz;

/**
 * ${DESCRIPTION}
 *
 * @author joy
 * @create 2017-06-08 16:23
 */
@Service
public class RouteBiz extends BaseBiz<RouteMapper,Route> {

    @Override
    public void insertSelective(Route entity) {
        super.insertSelective(entity);
    }

    @Override
    public void updateSelectiveById(Route entity) {
        super.updateSelectiveById(entity);
    }



}
