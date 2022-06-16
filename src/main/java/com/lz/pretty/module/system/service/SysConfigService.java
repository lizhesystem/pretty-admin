package com.lz.pretty.module.system.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.lz.pretty.module.system.mapper.SysConfigMapper;
import com.lz.pretty.module.system.model.SysConfig;
@Service
public class SysConfigService extends ServiceImpl<SysConfigMapper, SysConfig> {

    
    public int updateBatch(List<SysConfig> list) {
        return baseMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<SysConfig> list) {
        return baseMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<SysConfig> list) {
        return baseMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(SysConfig record) {
        return baseMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(SysConfig record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
