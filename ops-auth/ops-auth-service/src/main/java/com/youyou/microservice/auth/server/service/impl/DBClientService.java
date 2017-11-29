package com.youyou.microservice.auth.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.yonyou.cloud.common.service.utils.UUIDUtils;
import com.yonyou.microservice.gate.common.exception.GateException;
import com.youyou.microservice.auth.server.bean.ClientInfo;
import com.youyou.microservice.auth.server.entity.Client;
import com.youyou.microservice.auth.server.mapper.ClientMapper;
import com.youyou.microservice.auth.server.service.ClientService;
import com.youyou.microservice.auth.server.util.client.ClientTokenUtil;

/**
 * Created by ace on 2017/9/10.
 */
@Service
public class DBClientService implements ClientService {
    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private ClientTokenUtil clientTokenUtil;
    @Autowired
    private DiscoveryClient discovery;
    @Override
    public String apply(String clientId, String secret) throws Exception {
        Client client = getClient(clientId, secret);
        return clientTokenUtil.generateToken(new ClientInfo(client.getCode(),client.getName(),client.getId().toString()));
    }

    private Client getClient(String clientId, String secret) {
        Client client = new Client();
        client.setCode(clientId);
        client = clientMapper.selectOne(client);
        if(client==null||!client.getSecret().equals(secret)){
            throw GateException.CLIENT_INVALID_EXCEPTION;
        }
        return client;
    }

    @Override
    public List<String> getAllowedClient(String clientId, String secret) {
        Client info = this.getClient(clientId, secret);
        List<String> clients = clientMapper.selectAllowedClient(info.getId() + "");
        if(clients==null) {
            new ArrayList<String>();
        }
        return clients;
    }

    @Override
    @Scheduled(cron = "0 0/1 * * * ?")
    public void registryClient() {
        // 自动注册节点
        discovery.getServices().forEach((name) ->{
            Client client = new Client();
            client.setName(name);
            client.setCode(name);
            if(clientMapper.selectCount(client)== 0) {
                client.setSecret(UUIDUtils.generateShortUuid());
                clientMapper.insert(client);
            }
        });
    }
}
