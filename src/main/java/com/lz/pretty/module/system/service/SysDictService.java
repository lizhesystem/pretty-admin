package com.lz.pretty.module.system.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lz.pretty.module.system.mapper.SysDictMapper;
import com.lz.pretty.module.system.model.SysDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysDictService extends ServiceImpl<SysDictMapper, SysDict> {

    @Autowired
    private SysDictMapper sysDictMapper;
    
    public int updateBatch(List<SysDict> list) {
        return sysDictMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<SysDict> list) {
        return sysDictMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<SysDict> list) {
        return sysDictMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(SysDict record) {
        return sysDictMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(SysDict record) {
        return sysDictMapper.insertOrUpdateSelective(record);
    }
}
