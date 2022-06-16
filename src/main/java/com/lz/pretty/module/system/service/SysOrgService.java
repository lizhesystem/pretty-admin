package com.lz.pretty.module.system.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lz.pretty.module.system.mapper.SysOrgMapper;
import com.lz.pretty.module.system.model.SysOrg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysOrgService extends ServiceImpl<SysOrgMapper, SysOrg> {

    @Autowired
    private SysOrgMapper sysOrgMapper;
    
    public int updateBatch(List<SysOrg> list) {
        return sysOrgMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<SysOrg> list) {
        return sysOrgMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<SysOrg> list) {
        return sysOrgMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(SysOrg record) {
        return sysOrgMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(SysOrg record) {
        return sysOrgMapper.insertOrUpdateSelective(record);
    }
}
