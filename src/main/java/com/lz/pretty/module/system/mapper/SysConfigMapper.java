package com.lz.pretty.module.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lz.pretty.module.system.model.SysConfig;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysConfigMapper extends BaseMapper<SysConfig> {
    int updateBatch(List<SysConfig> list);

    int updateBatchSelective(List<SysConfig> list);

    int batchInsert(@Param("list") List<SysConfig> list);

    int insertOrUpdate(SysConfig record);

    int insertOrUpdateSelective(SysConfig record);
}