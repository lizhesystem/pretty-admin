package com.lz.pretty.module.system.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lz.pretty.module.system.mapper.SysApiMapper;
import com.lz.pretty.module.system.model.SysApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysApiService {

    @Autowired
    private SysApiMapper sysApiMapper;

}
