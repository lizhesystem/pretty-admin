package com.lz.pretty.module.system.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.lz.pretty.module.system.model.SysRole;
import com.lz.pretty.module.system.mapper.SysRoleMapper;
@Service
public class SysRoleService extends ServiceImpl<SysRoleMapper, SysRole> {

    
    public int updateBatch(List<SysRole> list) {
        return baseMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<SysRole> list) {
        return baseMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<SysRole> list) {
        return baseMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(SysRole record) {
        return baseMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(SysRole record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
