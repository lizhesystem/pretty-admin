package com.lz.pretty.module.system.service;

import com.lz.pretty.module.system.mapper.SysRoleApiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleApiService {

    @Autowired
    private SysRoleApiMapper sysRoleApiMapper;

}
