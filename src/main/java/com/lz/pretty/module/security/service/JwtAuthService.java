package com.lz.pretty.module.security.service;

import com.lz.pretty.common.constant.CustomExceptionType;
import com.lz.pretty.common.exception.CustomException;
import com.lz.pretty.common.utils.JwtTokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * 类描述:JWT 登录认证
 *
 * @author lz
 * @create 2022-06-13 16:57
 */

public class JwtAuthService {

    private AuthenticationManager authenticationManager;
    private MyUserDetailsService myUserDetailsService;
    private JwtTokenUtil jwtTokenUtil;

    public JwtAuthService() {
    }

    public JwtAuthService(AuthenticationManager authenticationManager, MyUserDetailsService myUserDetailsService, JwtTokenUtil jwtTokenUtil) {
        // authenticationManager在SecurityConfigurerAdapter注入用来认证
        this.authenticationManager = authenticationManager;
        this.myUserDetailsService = myUserDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    /**
     * 登录认证换取JWT令牌
     */
    public String login(String username, String password) {

        // 认证账号密码
        try {
            UsernamePasswordAuthenticationToken loginToken = new UsernamePasswordAuthenticationToken(username, password);
            Authentication authenticate = authenticationManager.authenticate(loginToken);
            SecurityContextHolder.getContext().setAuthentication(authenticate);
        } catch (AuthenticationException e) {
            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR, "用户名或者密码输入错误！");
        }

        UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);
        return jwtTokenUtil.generateToken(userDetails);
    }

    /**
     * 刷新令牌
     *
     * @param oldToken
     * @return
     */
    public String refreshToken(String oldToken) {
        if (!jwtTokenUtil.isTokenExpired(oldToken)) {
            return jwtTokenUtil.refreshToken(oldToken);
        }
        return null;
    }

    /**
     * 获取角色信息列表
     *
     * @param token
     * @return
     */
    public List<String> roles(String token) {
        String username = jwtTokenUtil.getUsernameFromToken(token);
        return myUserDetailsService.findRoleByUsername(username);
    }
}
