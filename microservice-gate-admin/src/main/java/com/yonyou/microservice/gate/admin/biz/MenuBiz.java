package com.yonyou.microservice.gate.admin.biz;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yonyou.microservice.gate.admin.constant.AdminCommonConstant;
import com.yonyou.microservice.gate.admin.entity.Menu;
import com.yonyou.microservice.gate.admin.mapper.MenuMapper;
import com.yonyou.microservice.gate.common.biz.BaseBiz;

/**
 * ${DESCRIPTION}
 *
 * @author joy
 * @create 2017-06-12 8:48
 */
@Service
public class MenuBiz extends BaseBiz<MenuMapper,Menu> {
    @Override
    public void insertSelective(Menu entity) {
        if(AdminCommonConstant.ROOT == entity.getParentId()){
            entity.setPath("/"+entity.getCode());
        }else{
            Menu parent = this.selectById(entity.getParentId());
            entity.setPath(parent.getPath()+"/"+entity.getCode());
        }
        super.insertSelective(entity);
    }

    @Override
    public void updateById(Menu entity) {
        if(AdminCommonConstant.ROOT == entity.getParentId()){
            entity.setPath("/"+entity.getCode());
        }else{
            Menu parent = this.selectById(entity.getParentId());
            entity.setPath(parent.getPath()+"/"+entity.getCode());
        }
        super.updateById(entity);
    }
    /**
     * 获取用户可以访问的菜单
     * @param id
     * @return
     */
    public List<Menu> getUserAuthorityMenuByUserId(int id){
        return mapper.selectAuthorityMenuByUserId(id);
    }

    /**
     * 根据用户获取可以访问的系统
     * @param id
     * @return
     */
    public List<Menu> getUserAuthoritySystemByUserId(int id){
        return mapper.selectAuthoritySystemByUserId(id);
    }
}
