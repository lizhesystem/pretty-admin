package com.lz.pretty.module.system.service;

import com.lz.pretty.module.system.mapper.SysApiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysApiService {

    @Autowired
    private SysApiMapper sysApiMapper;

}
