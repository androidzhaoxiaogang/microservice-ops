package com.youyou.microservice.auth.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yonyou.cloud.common.beans.RestResultResponse;
import com.youyou.microservice.auth.server.service.ClientService;

/**
 * Created by ace on 2017/9/10.
 */
@RestController
@RequestMapping("client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public RestResultResponse getAccessToken(String clientId, String secret) throws Exception {
        return new RestResultResponse<String>().data(clientService.apply(clientId, secret));
    }

    @RequestMapping(value = "/myClient")
    public RestResultResponse getAllowedClient(String serviceId, String secret) {
        return new RestResultResponse<List<String>>().data(clientService.getAllowedClient(serviceId, secret));
    }

}
