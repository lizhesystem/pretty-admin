package com.lz.pretty.module.system.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.lz.pretty.module.system.model.SysUser;
import com.lz.pretty.module.system.mapper.SysUserMapper;
@Service
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser> {

    
    public int updateBatch(List<SysUser> list) {
        return baseMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<SysUser> list) {
        return baseMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<SysUser> list) {
        return baseMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(SysUser record) {
        return baseMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(SysUser record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
