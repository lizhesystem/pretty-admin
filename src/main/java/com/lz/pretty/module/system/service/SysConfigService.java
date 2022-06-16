package com.lz.pretty.module.system.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lz.pretty.module.system.mapper.SysConfigMapper;
import com.lz.pretty.module.system.model.SysConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysConfigService extends ServiceImpl<SysConfigMapper, SysConfig> {
    
    @Autowired
    private SysConfigMapper sysConfigMapper;

    
    public int updateBatch(List<SysConfig> list) {
        return sysConfigMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<SysConfig> list) {
        return sysConfigMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<SysConfig> list) {
        return sysConfigMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(SysConfig record) {
        return sysConfigMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(SysConfig record) {
        return sysConfigMapper.insertOrUpdateSelective(record);
    }
}
