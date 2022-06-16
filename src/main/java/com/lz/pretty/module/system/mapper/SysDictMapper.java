package com.lz.pretty.module.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lz.pretty.module.system.model.SysDict;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDictMapper extends BaseMapper<SysDict> {
    int updateBatch(List<SysDict> list);

    int updateBatchSelective(List<SysDict> list);

    int batchInsert(@Param("list") List<SysDict> list);

    int insertOrUpdate(SysDict record);

    int insertOrUpdateSelective(SysDict record);
}