package com.lz.pretty.module.system.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.lz.pretty.module.system.model.SysRoleMenu;
import com.lz.pretty.module.system.mapper.SysRoleMenuMapper;
@Service
public class SysRoleMenuService extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> {

    
    public int updateBatch(List<SysRoleMenu> list) {
        return baseMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<SysRoleMenu> list) {
        return baseMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<SysRoleMenu> list) {
        return baseMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(SysRoleMenu record) {
        return baseMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(SysRoleMenu record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
