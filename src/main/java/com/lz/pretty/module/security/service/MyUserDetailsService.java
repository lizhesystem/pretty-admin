package com.lz.pretty.module.security.service;


import com.lz.pretty.module.security.bean.MyUserDetails;
import com.lz.pretty.module.security.mapper.MyUserDetailsServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类描述: 加载用户及角色权限信息的service
 * *
 *
 * @author lz
 * @create 2022-06-15 13:40
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private MyUserDetailsServiceMapper myUserDetailsServiceMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 加载用户基础信息
        MyUserDetails myUserDetails = myUserDetailsServiceMapper.findByUserName(username);

        // 加载用户角色列表
        List<String> roleCodes = myUserDetailsServiceMapper.findRoleByUserName(username);

        // 根据当前用户角色列表获取加载用户的资源权限列表
        List<String> authorties = myUserDetailsServiceMapper.findApiByRoleCodes(roleCodes);


        // 角色是一个特殊的权限，添加ROLE_前缀
        roleCodes = roleCodes.stream()
                .map(rc -> "ROLE_" + rc)
                .collect(Collectors.toList());

        authorties.addAll(roleCodes);

        // 设置用户权限合集
        myUserDetails.setAuthorities(
                AuthorityUtils.commaSeparatedStringToAuthorityList(String.join(",", authorties))
        );
        return myUserDetails;
    }
}
