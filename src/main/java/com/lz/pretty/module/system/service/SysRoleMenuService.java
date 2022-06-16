package com.lz.pretty.module.system.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lz.pretty.module.system.mapper.SysRoleMenuMapper;
import com.lz.pretty.module.system.model.SysRoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysRoleMenuService extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> {

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;
    
    public int updateBatch(List<SysRoleMenu> list) {
        return sysRoleMenuMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<SysRoleMenu> list) {
        return sysRoleMenuMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<SysRoleMenu> list) {
        return sysRoleMenuMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(SysRoleMenu record) {
        return sysRoleMenuMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(SysRoleMenu record) {
        return sysRoleMenuMapper.insertOrUpdateSelective(record);
    }
}
