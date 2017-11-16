/**
 * Copyright (c) 2015 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yonyou.cloud.zuul.db.store;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

import com.yonyou.cloud.zuul.db.dao.RouteDao;
import com.yonyou.cloud.zuul.db.entity.RouteEntity;

public class MysqlZuulRouteStore implements ZuulRouteStore {
	private Logger logger=Logger.getLogger(MysqlZuulRouteStore.class);
	@Autowired
    private RouteDao dao;
    
    public MysqlZuulRouteStore() {
    }

    public List<ZuulProperties.ZuulRoute> findAll() {
    	logger.info("--List<ZuulProperties.ZuulRoute> findAll()，从数据库加载路由");
    	List<ZuulProperties.ZuulRoute> zs=new ArrayList();
    	List<RouteEntity> list=dao.findAll();
    	for(RouteEntity e:list){
    		ZuulProperties.ZuulRoute zl=new ZuulProperties.ZuulRoute();
    		zl.setId(e.getId());
    		zl.setPath(e.getPath());
    		zl.setRetryable(e.getRetryable());
    		zl.setServiceId(e.getServiceId());
    		zl.setStripPrefix(e.getStripPrefix());
    		zl.setUrl(e.getUrl());
    		zs.add(zl);
    	}
        return zs;
    }

//    @Repository
//    public interface RouteDao extends JpaRepository<ZuulProperties.ZuulRoute, String>{
//    	
//
//    	@Query("select * from gate_routes")
//    	public List<ZuulProperties.ZuulRoute> findAll(); 
//     
//    }

}
