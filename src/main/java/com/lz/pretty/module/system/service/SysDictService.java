package com.lz.pretty.module.system.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.lz.pretty.module.system.mapper.SysDictMapper;
import com.lz.pretty.module.system.model.SysDict;
@Service
public class SysDictService extends ServiceImpl<SysDictMapper, SysDict> {

    
    public int updateBatch(List<SysDict> list) {
        return baseMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<SysDict> list) {
        return baseMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<SysDict> list) {
        return baseMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(SysDict record) {
        return baseMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(SysDict record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
