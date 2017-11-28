package com.yonyou.microservice.gate.admin.biz;

import org.springframework.stereotype.Service;

import com.yonyou.cloud.common.service.BaseService;
import com.yonyou.microservice.gate.admin.entity.Filter;
import com.yonyou.microservice.gate.admin.mapper.FilterMapper;

/**
 * ${DESCRIPTION}
 *
 * @author joy
 * @create 2017-06-08 16:23
 */
@Service
public class FilterBiz extends BaseService<FilterMapper,Filter> {

    @Override
    public void insertSelective(Filter entity) {
        super.insertSelective(entity);
    }

    @Override
    public void updateSelectiveById(Filter entity) {
        super.updateSelectiveById(entity);
    }



}
