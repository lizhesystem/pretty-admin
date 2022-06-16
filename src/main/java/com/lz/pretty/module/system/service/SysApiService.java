package com.lz.pretty.module.system.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lz.pretty.module.system.mapper.SysApiMapper;
import com.lz.pretty.module.system.model.SysApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysApiService extends ServiceImpl<SysApiMapper, SysApi> {

    @Autowired
    private SysApiMapper sysApiMapper;

    public int updateBatch(List<SysApi> list) {
        return sysApiMapper.updateBatch(list);
    }

    public int updateBatchSelective(List<SysApi> list) {
        return sysApiMapper.updateBatchSelective(list);
    }

    public int batchInsert(List<SysApi> list) {
        return sysApiMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(SysApi record) {
        return sysApiMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(SysApi record) {
        return sysApiMapper.insertOrUpdateSelective(record);
    }
}
