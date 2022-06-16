package com.lz.pretty.module.system.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.lz.pretty.module.system.mapper.SysOrgMapper;
import com.lz.pretty.module.system.model.SysOrg;
@Service
public class SysOrgService extends ServiceImpl<SysOrgMapper, SysOrg> {

    
    public int updateBatch(List<SysOrg> list) {
        return baseMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<SysOrg> list) {
        return baseMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<SysOrg> list) {
        return baseMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(SysOrg record) {
        return baseMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(SysOrg record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
