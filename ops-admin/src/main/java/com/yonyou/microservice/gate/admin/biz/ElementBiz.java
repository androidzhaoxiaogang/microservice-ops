package com.yonyou.microservice.gate.admin.biz;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yonyou.microservice.gate.admin.entity.Element;
import com.yonyou.microservice.gate.admin.mapper.ElementMapper;
import com.yonyou.microservice.gate.common.biz.BaseBiz;

/**
 * ${DESCRIPTION}
 *
 * @author joy
 * @create 2017-06-23 20:27
 */
@Service
public class ElementBiz extends BaseBiz<ElementMapper,Element> {
    public List<Element> getAuthorityElementByUserId(String userId){
       return mapper.selectAuthorityElementByUserId(userId);
    }
    public List<Element> getAuthorityElementByUserId(String userId,String menuId){
        return mapper.selectAuthorityMenuElementByUserId(userId,menuId);
    }
}
