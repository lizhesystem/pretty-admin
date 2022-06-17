package com.lz.pretty.module.system.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lz.pretty.module.system.mapper.SysConfigMapper;
import com.lz.pretty.module.system.model.SysConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysConfigService {
    
    @Autowired
    private SysConfigMapper sysConfigMapper;

}
