package com.lz.pretty.module.system.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.lz.pretty.module.system.model.SysRoleApi;
import com.lz.pretty.module.system.mapper.SysRoleApiMapper;
@Service
public class SysRoleApiService extends ServiceImpl<SysRoleApiMapper, SysRoleApi> {

    
    public int updateBatch(List<SysRoleApi> list) {
        return baseMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<SysRoleApi> list) {
        return baseMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<SysRoleApi> list) {
        return baseMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(SysRoleApi record) {
        return baseMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(SysRoleApi record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
