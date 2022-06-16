package com.lz.pretty.module.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lz.pretty.module.system.model.SysApi;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysApiMapper extends BaseMapper<SysApi> {
    int updateBatch(List<SysApi> list);

    int updateBatchSelective(List<SysApi> list);

    int batchInsert(@Param("list") List<SysApi> list);

    int insertOrUpdate(SysApi record);

    int insertOrUpdateSelective(SysApi record);
}