package com.lz.pretty.module.system.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lz.pretty.module.system.mapper.SysRoleMapper;
import com.lz.pretty.module.system.model.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysRoleService extends ServiceImpl<SysRoleMapper, SysRole> {

    
    @Autowired
    private SysRoleMapper sysRoleMapper;
    
    public int updateBatch(List<SysRole> list) {
        return sysRoleMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<SysRole> list) {
        return sysRoleMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<SysRole> list) {
        return sysRoleMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(SysRole record) {
        return sysRoleMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(SysRole record) {
        return sysRoleMapper.insertOrUpdateSelective(record);
    }
}
