package com.lz.pretty.module.system.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.lz.pretty.module.system.model.SysUserRole;
import com.lz.pretty.module.system.mapper.SysUserRoleMapper;
@Service
public class SysUserRoleService extends ServiceImpl<SysUserRoleMapper, SysUserRole> {

    
    public int updateBatch(List<SysUserRole> list) {
        return baseMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<SysUserRole> list) {
        return baseMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<SysUserRole> list) {
        return baseMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(SysUserRole record) {
        return baseMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(SysUserRole record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
