package com.lz.pretty.module.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lz.pretty.module.system.mapper.SysUserMapper;
import com.lz.pretty.module.system.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService {


    @Autowired
    private SysUserMapper sysUserMapper;


    public SysUser getUserByUserName(String username) {
        return sysUserMapper.selectOne(
                new QueryWrapper<SysUser>().eq("username", username));
    }
}
