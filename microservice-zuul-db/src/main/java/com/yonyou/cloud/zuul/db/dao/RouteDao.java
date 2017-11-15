package com.yonyou.cloud.zuul.db.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yonyou.cloud.zuul.db.entity.RouteEntity;
 

@Repository
@Transactional
public interface RouteDao extends JpaRepository<RouteEntity, String>{

    	@Query("select m  from RouteEntity m where 1=1")
    	public List<RouteEntity> find_All(); 
     
    }
 


 
