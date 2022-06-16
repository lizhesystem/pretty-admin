package com.lz.pretty.module.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lz.pretty.module.system.mapper.SysUserMapper;
import com.lz.pretty.module.system.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser> {


    @Autowired
    private SysUserMapper sysUserMapper;

    public int updateBatch(List<SysUser> list) {
        return sysUserMapper.updateBatch(list);
    }

    public int updateBatchSelective(List<SysUser> list) {
        return sysUserMapper.updateBatchSelective(list);
    }

    public int batchInsert(List<SysUser> list) {
        return sysUserMapper.batchInsert(list);
    }

    public int insertOrUpdate(SysUser record) {
        return sysUserMapper.insertOrUpdate(record);
    }

    public int insertOrUpdateSelective(SysUser record) {
        return sysUserMapper.insertOrUpdateSelective(record);
    }

    public SysUser getUserByUserName(String username) {
        return sysUserMapper.selectOne(
                new QueryWrapper<SysUser>().eq("username", username));
    }
}
