package com.lz.pretty.module.system.service;

import com.lz.pretty.module.system.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleService {


    @Autowired
    private SysRoleMapper sysRoleMapper;

}
