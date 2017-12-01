package com.yonyou.microservice.gate.admin.rpc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yonyou.cloud.common.service.utils.TreeUtil;
import com.yonyou.microservice.auth.client.jwt.UserAuthUtil;
import com.yonyou.microservice.gate.admin.biz.AuthProviderBiz;
import com.yonyou.microservice.gate.admin.biz.ElementBiz;
import com.yonyou.microservice.gate.admin.biz.MenuBiz;
import com.yonyou.microservice.gate.admin.biz.UserBiz;
import com.yonyou.microservice.gate.admin.constant.AdminCommonConstant;
import com.yonyou.microservice.gate.admin.entity.AuthProvider;
import com.yonyou.microservice.gate.admin.entity.Element;
import com.yonyou.microservice.gate.admin.entity.Menu;
import com.yonyou.microservice.gate.admin.entity.User;
import com.yonyou.microservice.gate.admin.vo.FrontUser;
import com.yonyou.microservice.gate.admin.vo.MenuTree;
import com.yonyou.microservice.gate.common.constant.CommonConstants;
import com.yonyou.microservice.gate.common.vo.authority.PermissionInfo;
import com.yonyou.microservice.gate.common.vo.user.AuthProviderInfo;
import com.yonyou.microservice.gate.common.vo.user.UserInfo;

/**
 * Created by ace on 2017/9/12.
 */
@Service
public class AuthProviderService {
    @Autowired
    private AuthProviderBiz authProviderBiz;
    
    public  List<AuthProviderInfo> getAuthProviders() {
    	List<AuthProvider> list=authProviderBiz.selectListAll();
    	List<AuthProviderInfo> r=new ArrayList();
    	for(AuthProvider p:list){
    		AuthProviderInfo i=new AuthProviderInfo();
    		i.setId(p.getId());
    		i.setAuthService(p.getAuthService());
    		i.setSrcUrl(p.getSrcUrl());
    		i.setAcceptType(p.getAcceptType());
    		r.add(i);
    	}
        return r;
    }
}
