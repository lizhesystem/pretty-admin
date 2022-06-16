package com.lz.pretty.module.system.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lz.pretty.module.system.mapper.SysUserRoleMapper;
import com.lz.pretty.module.system.model.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysUserRoleService extends ServiceImpl<SysUserRoleMapper, SysUserRole> {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    
    public int updateBatch(List<SysUserRole> list) {
        return sysUserRoleMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<SysUserRole> list) {
        return sysUserRoleMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<SysUserRole> list) {
        return sysUserRoleMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(SysUserRole record) {
        return sysUserRoleMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(SysUserRole record) {
        return sysUserRoleMapper.insertOrUpdateSelective(record);
    }
}
