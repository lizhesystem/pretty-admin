package com.lz.pretty.module.system.service;

import com.lz.pretty.module.system.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

}
