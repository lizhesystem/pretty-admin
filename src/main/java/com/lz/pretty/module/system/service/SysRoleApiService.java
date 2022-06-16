package com.lz.pretty.module.system.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lz.pretty.module.system.mapper.SysRoleApiMapper;
import com.lz.pretty.module.system.model.SysRoleApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysRoleApiService extends ServiceImpl<SysRoleApiMapper, SysRoleApi> {

    @Autowired
    private SysRoleApiMapper sysRoleApiMapper;
    
    public int updateBatch(List<SysRoleApi> list) {
        return sysRoleApiMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<SysRoleApi> list) {
        return sysRoleApiMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<SysRoleApi> list) {
        return sysRoleApiMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(SysRoleApi record) {
        return sysRoleApiMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(SysRoleApi record) {
        return sysRoleApiMapper.insertOrUpdateSelective(record);
    }
}
