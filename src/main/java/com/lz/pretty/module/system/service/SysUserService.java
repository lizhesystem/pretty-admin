package com.lz.pretty.module.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lz.pretty.module.system.mapper.SysUserMapper;
import com.lz.pretty.module.system.model.SysUser;
import io.jsonwebtoken.lang.Assert;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class SysUserService {


    @Resource
    private SysUserMapper sysUserMapper;


    public SysUser getUserByUserName(String username) {
        Assert.isTrue(!StringUtils.isEmpty(username), "查询参数用户名不存在");
        SysUser sysUser = sysUserMapper.selectOne(
                new QueryWrapper<SysUser>().eq("username", username));
        if (sysUser != null) {
            sysUser.setPassword("");
        }
        return sysUser;
    }
}
