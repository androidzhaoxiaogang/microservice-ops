package com.yonyou.microservice.gate.admin.rpc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yonyou.microservice.gate.admin.rpc.service.IgnoreUriService;
import com.yonyou.microservice.gate.common.vo.authority.IgnoreUriInfo;

/**
 * ${DESCRIPTION}
 *
 * @author joy
 * @create 2017-06-21 8:15
 */
@RestController
@RequestMapping("api")
public class IgnoreUriRest {
    @Autowired
    private IgnoreUriService ignoreUriService;

    @RequestMapping(value = "/ignoreUri/all",method = RequestMethod.GET, produces="application/json")
    public  @ResponseBody List<IgnoreUriInfo> getAuthProviders() {
    	
        return ignoreUriService.getIgnoreUris();
    }

}
