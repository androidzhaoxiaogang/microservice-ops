
package com.yonyou.microservice.auth.client.jwt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.yonyou.cloud.common.beans.RestResultResponse;
import com.yonyou.cloud.common.jwt.IJWTInfo;
import com.yonyou.cloud.common.jwt.JWTHelper;
import com.yonyou.microservice.auth.client.config.ServiceAuthConfig;
import com.yonyou.microservice.auth.client.exception.JwtIllegalArgumentException;
import com.yonyou.microservice.auth.client.exception.JwtSignatureException;
import com.yonyou.microservice.auth.client.exception.JwtTokenExpiredException;
import com.yonyou.microservice.auth.client.feign.ServiceAuthFeign;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by ace on 2017/9/15.
 */
@Configuration
@Slf4j
@EnableScheduling
public class ServiceAuthUtil {
    @Autowired
    private ServiceAuthConfig serviceAuthConfig;
    @Autowired
    private ServiceAuthFeign serviceAuthFeign;
    private List<String> allowedClient;
    private String clientToken;


    public IJWTInfo getInfoFromToken(String token) throws Exception {
        try {
            return JWTHelper.getInfoFromToken(token, serviceAuthConfig.getPubKeyPath());
        } catch (ExpiredJwtException ex) {
            throw new JwtTokenExpiredException("Client token expired!");
        } catch (SignatureException ex) {
            throw new JwtSignatureException("Client token signature error!");
        } catch (IllegalArgumentException ex) {
            throw new JwtIllegalArgumentException("Client token is null or empty!");
        }
    }

    @Scheduled(cron = "0 0/5 * * * ?")
    public void refreshAllowedClient() {
        log.info("refresh allowedClient.....");
        RestResultResponse resp = serviceAuthFeign.getAllowedClient(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
        if (resp.getResultCode() == 200) {
        	RestResultResponse<List<String>> allowedClient = (RestResultResponse<List<String>>) resp;
            this.allowedClient = allowedClient.getData();
        }
    }


    @Scheduled(cron = "0 0 0/1 * * ?")
    public void refreshClientToken() {
        log.info("refresh client token.....");
        RestResultResponse resp = serviceAuthFeign.getAccessToken(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
        if (resp.getResultCode() == 200) {
        	RestResultResponse<String> clientToken = (RestResultResponse<String>) resp;
            this.clientToken = clientToken.getData();
        }
    }


    public String getClientToken() {
        if (this.clientToken == null) {
            this.refreshClientToken();
        }
        return clientToken;
    }

    public List<String> getAllowedClient() {
        if (this.allowedClient == null) {
            this.refreshAllowedClient();
        }
        return allowedClient;
    }

}