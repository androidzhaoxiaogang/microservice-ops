package com.youyou.microservice.auth.server.service;


import com.youyou.microservice.auth.server.vo.FrontUser;

public interface AuthService {
    String login(String username, String password) throws Exception;
    String loginPhone(String phone, String captch) throws Exception;
    String refresh(String oldToken);
    void validate(String token) throws Exception;
    FrontUser getUserInfo(String token) throws Exception;
    Boolean invalid(String token);
}
