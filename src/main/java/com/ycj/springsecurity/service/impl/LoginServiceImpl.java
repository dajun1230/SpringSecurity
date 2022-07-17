package com.ycj.springsecurity.service.impl;

import com.ycj.springsecurity.domain.LoginUser;
import com.ycj.springsecurity.domain.ResponseResult;
import com.ycj.springsecurity.domain.User;
import com.ycj.springsecurity.service.LoginService;
import com.ycj.springsecurity.utils.JwtUtil;
import com.ycj.springsecurity.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user){
        // AuthenticationManager authenticate进行用户认证
        System.out.println("user====" + user);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        // 如果认证没通过，给出对应提示
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败");
        }

        // 如果认证通过了，使用 userid 生成一个 jwt jwt存入ResponseResult返回
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        Map<String, String> map = new HashMap<>();
        map.put("token", jwt);

        // 把完成的用户信息存入到redis，userid 作为 key
        redisCache.setCacheObject("login:"+userId, loginUser);

        return new ResponseResult(200, "登录成功", map);
    }
}
