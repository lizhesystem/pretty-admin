package com.lz.pretty.module.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lz.pretty.module.system.model.SysRoleApi;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleApiMapper extends BaseMapper<SysRoleApi> {
    int updateBatch(List<SysRoleApi> list);

    int updateBatchSelective(List<SysRoleApi> list);

    int batchInsert(@Param("list") List<SysRoleApi> list);

    int insertOrUpdate(SysRoleApi record);

    int insertOrUpdateSelective(SysRoleApi record);
}