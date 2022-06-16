package com.lz.pretty.module.system.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lz.pretty.module.system.mapper.SysMenuMapper;
import com.lz.pretty.module.system.model.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysMenuService extends ServiceImpl<SysMenuMapper, SysMenu> {

    @Autowired
    private SysMenuMapper sysMenuMapper;
    
    public int updateBatch(List<SysMenu> list) {
        return sysMenuMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<SysMenu> list) {
        return sysMenuMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<SysMenu> list) {
        return sysMenuMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(SysMenu record) {
        return sysMenuMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(SysMenu record) {
        return sysMenuMapper.insertOrUpdateSelective(record);
    }
}
