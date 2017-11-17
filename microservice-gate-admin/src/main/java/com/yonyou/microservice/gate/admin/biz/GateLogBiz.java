package com.yonyou.microservice.gate.admin.biz;

import org.springframework.stereotype.Service;

import com.yonyou.microservice.gate.admin.entity.GateLog;
import com.yonyou.microservice.gate.admin.mapper.GateLogMapper;
import com.yonyou.microservice.gate.common.biz.BaseBiz;

/**
 * ${DESCRIPTION}
 *
 * @author joy
 * @create 2017-07-01 14:36
 */
@Service
public class GateLogBiz extends BaseBiz<GateLogMapper,GateLog> {

    @Override
    public void insert(GateLog entity) {
        mapper.insert(entity);
    }

    @Override
    public void insertSelective(GateLog entity) {
        mapper.insertSelective(entity);
    }
}
