package com.lz.pretty.module.system.service;

import com.lz.pretty.module.system.mapper.SysConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysConfigService {

    @Autowired
    private SysConfigMapper sysConfigMapper;

}
