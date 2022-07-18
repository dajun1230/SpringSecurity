package com.ycj.springsecurity.service;

import com.ycj.springsecurity.domain.ResponseResult;
import com.ycj.springsecurity.domain.User;

public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
