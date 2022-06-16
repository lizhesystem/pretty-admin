package com.lz.pretty.module.system.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.lz.pretty.module.system.mapper.SysApiMapper;
import com.lz.pretty.module.system.model.SysApi;
@Service
public class SysApiService extends ServiceImpl<SysApiMapper, SysApi> {

    
    public int updateBatch(List<SysApi> list) {
        return baseMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<SysApi> list) {
        return baseMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<SysApi> list) {
        return baseMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(SysApi record) {
        return baseMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(SysApi record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
